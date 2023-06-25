package com.wuwu.worldofzuulwuwu;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import com.wuwu.worldofzuulwuwu.mapper.PlayerItemDao;
import com.wuwu.worldofzuulwuwu.mapper.RoomItemDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class WorldOfZuulWuwuApplicationTests {

	@Autowired
	PlayerDao playerDao;

	@Autowired
	PlayerItemDao playerItemDao;

	@Autowired
	RoomItemDao roomItemDao;


	@Test
	void contextLoads() {
//		Player player = playerDao.findByName("123");
////		playerDao.save(player);
//		playerDao.update(player);
//
//		PlayerItem playerItem = playerItemDao.findOne(0L, 0);
//		List<PlayerItem> itemList = playerItemDao.findAll(0L);
//
//		List<RoomItem> byRoomId = roomItemDao.findAll(0L, 0);
//		RoomItem one = roomItemDao.findOne(0L, 0, 0);
////		roomItemDao.save(one);
//		roomItemDao.update(one);

	}

}
