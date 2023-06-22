package com.wuwu.worldofzuulwuwu;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import com.wuwu.worldofzuulwuwu.mapper.PlayerItemDao;
import com.wuwu.worldofzuulwuwu.mapper.RoomItemDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorldOfZuulWuwuApplicationTests {

	@Autowired
	PlayerDao playerDao;

	@Autowired
	PlayerItemDao playerItemDao;

	@Autowired
	RoomItemDao roomItemDao;


	@Test
	void contextLoads() {
	}

}
