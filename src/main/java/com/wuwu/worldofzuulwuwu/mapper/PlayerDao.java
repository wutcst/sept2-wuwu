package com.wuwu.worldofzuulwuwu.mapper;

import com.wuwu.worldofzuulwuwu.entity.Player;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PlayerDao {

    @Select("SELECT * FROM player WHERE name=#{name}")
    Player findByName(@Param("name") String username);

    @Update("UPDATE player WHERE name=#{name}}")
    int update(Player player);

    @Insert("INSERT INTO player VALUES (#{id},#{name},#{password},#{currentRoom},#{capacity}))")
    Player save(Player player);


}
