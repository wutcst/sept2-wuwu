package com.wuwu.worldofzuulwuwu.mapper;

import com.wuwu.worldofzuulwuwu.entity.Player;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PlayerDao {

    @Select("SELECT * FROM player WHERE name=#{name}")
    Player findByName(@Param("name") String username);

    @Update("UPDATE player SET capacity=#{capacity},currentRoom=#{currentRoom} WHERE name=#{name}")
    int update(Player player);

    @Insert("INSERT INTO player VALUES (#{id},#{name},#{password},#{currentRoom},#{capacity})")
    Player save(Player player);

    @Select("SELECT * FROM player WHERE id=#{id}")
    Player findById(Long id);

}
