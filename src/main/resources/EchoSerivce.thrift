namespace java cn.slimsmart.thrift.rpc.demo
service EchoSerivce
{
	string echo(1: string msg);
	User getUser(1: i64 playerId,2: i32 x,3: i32 y);
	WorldViewTileResp viewWorld(1: i64 playerId,2: i32 x,3: i32 y);
}

struct User{

	1: i32 userId,
	2: string name
}

//103查看世界地块返回,128是行军
struct WorldViewTileResp{
	1: list<WorldTileData> infos, // 地块信息
	2: i64 playerId,// 玩家ID
	3: bool isEndPacket//是否最后结束包
}

//单元格信息
struct WorldTileData {
	1: i32 x, //x坐标
	2: i32 y, //y坐标
	3: string name, // 城池名
	4: i64 cityId, // 城池标示
	5: i64 playerId, // 玩家ID
	6: i32 terrain,// 地形
	7: i32 tileType,//0普通地块,1主城，2分城，3要塞,4npc小城，5npc大城,6npc大城周边格子
	8: double allDurability,//总耐久度
	9: double currentDurability,//当前耐久度
	10: i32 defendType,//驻军类型，0无驻军，1自己驻军，2联盟驻军，3敌军驻军
	11: i32 giveUpEndTime,//放弃地块结束时间戳
	12: string playerName,//玩家名称
	13: bool isHaveRandomEvent,//是否存在随机事件
	14: i64 randomEventId,//随机事件ID
	15: i64 eventEndTime//随机事件结束时间
	
}