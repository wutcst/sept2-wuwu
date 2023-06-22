package com.wuwu.worldofzuulwuwu.mapper;

import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoomItemDao {

    @Select("SELECT * FROM roomItem WHERE roomId=#{roomId}")
    List<RoomItem> findByRoomId(int roomId);

    @Update("UPDATE roomItem SET count=#{count} WHERE roomId=#{roomId} AND playerId=#{playerId} AND id=#{id}")
    int update(RoomItem roomItem);

    @Delete("DELETE FROM roomItem WHERE roomId=#{roomId} AND playerId=#{playerId} AND id=#{id}")
    int delete(RoomItem roomItem);

    @Insert("INSERT INTO roomItem VALUES (#{playerId},#{roomId},#{id},#{count})")
    int save(RoomItem roomItem);
}
