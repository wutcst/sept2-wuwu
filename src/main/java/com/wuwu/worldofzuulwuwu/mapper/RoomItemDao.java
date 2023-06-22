package com.wuwu.worldofzuulwuwu.mapper;

import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomItemDao {

    @Select("SELECT * FROM roomItem WHERE roomId=#{roomId} AND playerId=#{playerId}")
    List<RoomItem> findAll(Long playerId,int roomId);

    @Select("SELECT * FROM roomItem WHERE roomId=#{roomId} AND playerId=#{playerId} AND id=#{id}")
    RoomItem findOne(Long playerId,int roomId,int id);

    @Update("UPDATE roomItem SET count=#{count} WHERE roomId=#{roomId} AND playerId=#{playerId} AND id=#{id}")
    int update(RoomItem roomItem);

    @Delete("DELETE FROM roomItem WHERE roomId=#{roomId} AND playerId=#{playerId} AND id=#{id}")
    int delete(RoomItem roomItem);

    @Insert("INSERT INTO roomItem VALUES (#{playerId},#{roomId},#{id},#{count})")
    int save(RoomItem roomItem);
}
