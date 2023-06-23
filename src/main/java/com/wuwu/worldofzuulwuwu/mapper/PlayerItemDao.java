package com.wuwu.worldofzuulwuwu.mapper;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlayerItemDao {

    @Select("SELECT * FROM playerItem WHERE player_id=#{playerId}  AND id=#{id}")
    PlayerItem findOne(Long playerId,@Param("id") Integer itemId);

    @Insert("INSERT INTO playerItem VALUES (#{playerId},#{id},#{count})")
    int save(PlayerItem playerItem);

    @Select("SELECT * FROM playerItem where player_id=#{playerId}")
    List<PlayerItem> findAll(Long playerId);

    @Select("SELECT * FROM playerItem where player_id=#{playerId}")
    List<PlayerItem> findByName(Long playerId);

    @Update("UPDATE playerItem SET count=#{count} WHERE player_id=#{playerId} AND id=#{id}")
    int update(PlayerItem playerItem);

    @Delete("DELETE FROM playerItem WHERE player_id=#{playerId} AND id=#{id}")
    int delete(PlayerItem playerItem);

}
