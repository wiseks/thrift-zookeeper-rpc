package cn.slimsmart.thrift.rpc.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//服务端启动
public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			new ClassPathXmlApplicationContext("classpath:spring-context-thrift-server.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
