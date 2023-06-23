package com.wuwu.worldofzuulwuwu.zuul;

public enum RoomId {
    ENTRANCE(0), COOKIE_ROOM(1), CAVE(2), TREASURE_ROOM(3), DARKROOM(4), LOBBY(5), WEAPON_ROOM(6), JAIL(7), READING_ROOM(8), SECRET_ROOM(9),
    EXIT1(10), EXIT2(11), EXIT3(12), EXIT4(13), EXIT5(14), EXIT6(15), EXIT7(16);
    private Integer id;
    RoomId(){}
    RoomId(int _id){
        id=_id;
    }
    public Integer getId(){
        return id;
    }
    public static Integer getRoomId(String name){
        return RoomId.valueOf(name.toUpperCase()).getId();
    }

}
