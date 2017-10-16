package com.star.yibancinema;

import com.star.mapper.SeatMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YibancinemaApplicationTests {
	@Autowired
	SeatMapper seatMapper;
	@Test
	public void contextLoads() {
		System.out.println(seatMapper.getBySeatNum("1_1_05_15").size());
	}

}
