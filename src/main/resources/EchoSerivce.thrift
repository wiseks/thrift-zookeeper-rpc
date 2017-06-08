namespace java cn.slimsmart.thrift.rpc.demo
service EchoSerivce
{
	string echo(1: string msg);
	User getUser(1: i64 playerId,2: i32 x,3: i32 y);
}

struct User{

	1: i32 userId,
	2: string name
}