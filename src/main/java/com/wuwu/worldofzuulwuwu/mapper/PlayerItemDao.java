package com.wuwu.worldofzuulwuwu.mapper;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlayerItemDao {

    @Select("SELECT * FROM playerItem WHERE playerId=#{playerId}  AND itemId=#{id}")
    PlayerItem findOne(Long playerId,@Param("id") Integer itemId);

    @Insert("INSERT INTO playerItem VALUES (#{playerId},#{id},#{count})")
    PlayerItem save(PlayerItem playerItem);

    @Select("SELECT * FROM playerItem")
    List<PlayerItem> findAll();

    @Update("UPDATE playerItem SET count=#{count} WHERE playerId=#{playerId} AND id=#{id}")
    int update(PlayerItem playerItem);

    @Delete("DELETE FROM playerItem WHERE playerId=#{playerId} AND id=#{id}")
    int delete(PlayerItem playerItem);

}
