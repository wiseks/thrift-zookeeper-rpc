package cn.slimsmart.thrift.rpc.demo;

import org.apache.thrift.TException;

//实现类
public class EchoSerivceImpl implements EchoSerivce.Iface {

	@Override
	public String echo(String msg) throws TException {
		return "server2222222222222 :"+msg;
	}

	@Override
	public User getUser() throws TException {
		User user = new User();
		user.setUserId(888);
		user.setName("tom");
		return user;
	}
}
