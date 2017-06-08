package cn.slimsmart.thrift.rpc.demo;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.slimsmart.thrift.rpc.ThriftServiceClientProxyFactory;

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
			ThriftServiceClientProxyFactory factory = context.getBean(ThriftServiceClientProxyFactory.class);
			EchoSerivce.Iface echoSerivce = (EchoSerivce.Iface)factory.getService(EchoSerivce.Iface.class);
//			EchoSerivce.Iface echoSerivce = (EchoSerivce.Iface) context.getBean("echoSerivce");
			System.out.println(echoSerivce.echo("hello--echo"));
			User user = echoSerivce.getUser(111L,0,0);
			System.out.println(">>>>>>>>>"+user.getUserId()+","+user.getName());
			//关闭连接的钩子
			Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                	Map<String,ThriftServiceClientProxyFactory>
                	clientMap = context.getBeansOfType(ThriftServiceClientProxyFactory.class);
                	for(Entry<String, ThriftServiceClientProxyFactory> client : clientMap.entrySet()){
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
