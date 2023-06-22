package zuul;

import java.util.HashMap;

/**
 * @author:wangyuze
 * @create: 2023-06-22 19:38
 * @Description: 房间配置类
 */
public class RoomSetting {
    public static HashMap<RoomId, Room> rooms=new HashMap<>();
    static {
        rooms.put(RoomId.OUTSIDE,new Room("outside the main entrance of the university"));

    }

}
