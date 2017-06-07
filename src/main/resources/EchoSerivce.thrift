namespace java cn.slimsmart.thrift.rpc.demo
service EchoSerivce
{
	string echo(1: string msg);
	User getUser();
}

struct User{

	1: i32 userId,
	2: string name
}