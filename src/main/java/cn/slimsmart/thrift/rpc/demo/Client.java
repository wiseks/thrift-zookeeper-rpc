package cn.slimsmart.thrift.rpc.demo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.slimsmart.thrift.rpc.ThriftServiceClientSingleProxyFactory;

//客户端调用
@SuppressWarnings("resource")
public class Client {
	public static void main(String[] args) {
		//simple();
		spring();
	}

	public static void spring() {
		try {
			final ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-thrift-client.xml");
			//ThriftServiceClientProxyFactory factory = context.getBean(ThriftServiceClientProxyFactory.class);
			//EchoSerivce.Iface echoSerivce = (EchoSerivce.Iface)factory.getService(EchoSerivce.Iface.class);
			ThriftServiceClientSingleProxyFactory factory = context.getBean(ThriftServiceClientSingleProxyFactory.class);
			EchoSerivce.Iface echoSerivce = (EchoSerivce.Iface)factory.getServiceByServerId(2,EchoSerivce.Iface.class);
			Thread.sleep(2000);
//			EchoSerivce.Iface echoSerivce = (EchoSerivce.Iface) context.getBean("echoSerivce");
			System.out.println(echoSerivce.echo("hello--echo"));
			User user = echoSerivce.getUser(111L,0,0);
			System.out.println(">>>>>>>>>"+user.getUserId()+","+user.getName());
			Random random = new Random();
			for(int i=0;i<100;i++){
				int index = random.nextInt(2)+1;
				EchoSerivce.Iface echoSerivce1 = (EchoSerivce.Iface)factory.getServiceByServerId(index,EchoSerivce.Iface.class);
//				EchoSerivce.Iface echoSerivce = (EchoSerivce.Iface) context.getBean("echoSerivce");
				System.out.println(echoSerivce1.echo("hello--echo"));
			}
			
//			Random random = new Random();
//			List<Integer> xList = new ArrayList<Integer>();
//			List<Integer> yList = new ArrayList<Integer>();
//			for(int i=-1000;i<=1000;i++){
//				xList.add(i);
//				yList.add(i);
//			}
//			for(int i=0;i<=200000;i++){
//				long playerId = i;// BeanUtil.idGenerator.nextId();
//				Cache.playerIds.put(i, playerId);
//			}
//			long start = System.currentTimeMillis();
//			for(int i=0;i<=200000;i++){
//				int x = xList.get(random.nextInt(xList.size()));
//				int y = yList.get(random.nextInt(xList.size()));
//				WorldViewTileResp resp = echoSerivce.viewWorld(Cache.playerIds.get(i), x, y);
//				List<WorldTileData> info = resp.getInfos();
//			}
//			long endTime = System.currentTimeMillis();
//			System.out.println("needTime="+(endTime-start));
			//关闭连接的钩子
			Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                	Map<String,ThriftServiceClientSingleProxyFactory>
                	clientMap = context.getBeansOfType(ThriftServiceClientSingleProxyFactory.class);
                	for(Entry<String, ThriftServiceClientSingleProxyFactory> client : clientMap.entrySet()){
                		System.out.println("serviceName : "+client.getKey() + ",class obj: "+client.getValue());
                		client.getValue().close();
                	}
                }
            });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class TThread extends Thread {
		EchoSerivce.Iface echoSerivce;
		TThread(EchoSerivce.Iface service) {
			echoSerivce = service;
		}
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(1000*i);
					System.out.println(Thread.currentThread().getName()+"  "+echoSerivce.echo("hello"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void simple() {
		try {
			
			long start = System.currentTimeMillis();
			TSocket socket = new TSocket("127.0.0.1", 9003);
			TTransport transport = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(transport);
			EchoSerivce.Client client = new EchoSerivce.Client(protocol);
			for(int i=0;i<100000;i++){
				boolean isOpen = transport.isOpen();
				boolean isOpen1 = socket.isOpen();
				if(!isOpen&&!isOpen1){
					transport.open();
				}
				client.echo("helloword");
				transport.close();
				socket.close();
			}
			long end = System.currentTimeMillis();
			long useTime = (end-start);
			System.out.println("useTime:"+useTime);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
