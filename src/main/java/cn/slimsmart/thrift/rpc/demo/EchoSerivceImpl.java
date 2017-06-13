package cn.slimsmart.thrift.rpc.demo;

import org.apache.thrift.TException;

//实现类
public class EchoSerivceImpl implements EchoSerivce.Iface {

	@Override
	public String echo(String msg) throws TException {
		return "server1111111111111:"+msg;
	}

	@Override
	public User getUser(long playerId,int x,int y) throws TException {
		User user = new User();
		user.setUserId(888);
		user.setName("tom");
		return user;
	}

	@Override
	public WorldViewTileResp viewWorld(long playerId, int x, int y) throws TException {
		// TODO Auto-generated method stub
		return null;
	}
}
