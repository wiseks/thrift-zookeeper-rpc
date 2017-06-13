package cn.slimsmart.thrift.rpc;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.TServiceClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import cn.slimsmart.thrift.rpc.zookeeper.ThriftServerAddressProvider;

/**
 * 客户端代理
 */
public class ThriftServiceClientProxyFactory implements InitializingBean,Closeable {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	private Integer maxActive = 32;// 最大活跃连接数

	// ms,default 3 min,链接空闲时间
	// -1,关闭空闲检测
	private Integer idleTime = 180000;
	private ThriftServerAddressProvider serverAddressProvider;

	private Map<Class<?>,Object> map = new HashMap<>();

	private GenericObjectPool<TServiceClient> clusterPool;
	
	private static final String resourcePattern = "*$Iface.class";
	
	private String basePackage = "cn/slimsmart/thrift/rpc/*";
	
	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

	private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);


	@Override
	public void afterPropertiesSet() throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String[] basePackages = basePackage.split(",");
		for (String basePackageName : basePackages) {
			if(basePackageName==null||basePackageName.equals("")){
				continue;
			}
			String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + basePackageName + "/"
					+ resourcePattern;
			try {
				Resource[] resources = this.resourcePatternResolver.getResources(packageSearchPath);
				for (Resource resource : resources) {
					if (!resource.isReadable()) {
						return;
					}
					MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);
					ClassMetadata classMetadata = metadataReader.getClassMetadata();
					String className = classMetadata.getClassName();
					// 加载Iface接口
					Class<?> objectClass = ClassUtils.forName(className, ClassUtils.getDefaultClassLoader());
//					objectClass = classLoader.loadClass(serverAddressProvider.getService() + "$Iface");
					// 加载Client.Factory类
					@SuppressWarnings("unchecked")
					Class<TServiceClientFactory<TServiceClient>> fi = (Class<TServiceClientFactory<TServiceClient>>) classLoader.loadClass(serverAddressProvider.getService() + "$Client$Factory");
					TServiceClientFactory<TServiceClient> clientFactory = fi.newInstance();
					ThriftClientPoolFactory clientClusterPool = new ThriftClientPoolFactory(serverAddressProvider, clientFactory, callback);
					GenericObjectPool.Config poolConfig = new GenericObjectPool.Config();
					poolConfig.maxActive = maxActive;
					poolConfig.maxIdle = 1;
					poolConfig.minIdle = 0;
					poolConfig.minEvictableIdleTimeMillis = idleTime;
					poolConfig.timeBetweenEvictionRunsMillis = idleTime * 2L;
					poolConfig.testOnBorrow=true;
					poolConfig.testOnReturn=false;
					poolConfig.testWhileIdle=false;
					clusterPool = new GenericObjectPool<TServiceClient>(clientClusterPool, poolConfig);
					Object proxyClient = Proxy.newProxyInstance(classLoader, new Class[] { objectClass }, new InvocationHandler() {
						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							//
							TServiceClient client = clusterPool.borrowObject();
							boolean flag = true;
							try {
								return method.invoke(client, args);
							} catch (Exception e) {
								flag = false;
								throw e;
							} finally {
								if(flag){
									clusterPool.returnObject(client);
								}else{
									clusterPool.invalidateObject(client);
								}
							}
						}
					});
					map.put(objectClass, proxyClient);
				}
			} catch (IOException e) {
			} catch (ClassNotFoundException e) {
			} catch (LinkageError e) {
			}
		}
	}
	
	
	private PoolOperationCallBack callback = new PoolOperationCallBack() {
		@Override
		public void make(TServiceClient client) {
			logger.info("create");
		}

		@Override
		public void destroy(TServiceClient client) {
			logger.info("destroy");
		}
	};
	
	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}

	public void setIdleTime(Integer idleTime) {
		this.idleTime = idleTime;
	}

	public void setServerAddressProvider(ThriftServerAddressProvider serverAddressProvider) {
		this.serverAddressProvider = serverAddressProvider;
	}
	
	public Object getService(Class<?> clazz){
		return map.get(clazz);
	}

	@Override
	public void close() {
		if(clusterPool!=null){
			try {
				clusterPool.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (serverAddressProvider != null) {
			try {
				serverAddressProvider.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
