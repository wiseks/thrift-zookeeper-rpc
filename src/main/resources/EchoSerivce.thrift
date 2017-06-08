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

//103�鿴����ؿ鷵��,128���о�
struct WorldViewTileResp{
	1: list<WorldTileData> infos, // �ؿ���Ϣ
	2: i64 playerId,// ���ID
	3: bool isEndPacket//�Ƿ���������
}

//��Ԫ����Ϣ
struct WorldTileData {
	1: i32 x, //x����
	2: i32 y, //y����
	3: string name, // �ǳ���
	4: i64 cityId, // �ǳر�ʾ
	5: i64 playerId, // ���ID
	6: i32 terrain,// ����
	7: i32 tileType,//0��ͨ�ؿ�,1���ǣ�2�ֳǣ�3Ҫ��,4npcС�ǣ�5npc���,6npc����ܱ߸���
	8: double allDurability,//���;ö�
	9: double currentDurability,//��ǰ�;ö�
	10: i32 defendType,//פ�����ͣ�0��פ����1�Լ�פ����2����פ����3�о�פ��
	11: i32 giveUpEndTime,//�����ؿ����ʱ���
	12: string playerName,//�������
	13: bool isHaveRandomEvent,//�Ƿ��������¼�
	14: i64 randomEventId,//����¼�ID
	15: i64 eventEndTime//����¼�����ʱ��
	
}