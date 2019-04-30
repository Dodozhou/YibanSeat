package com.star.yibancinema;

import com.star.mapper.SeatMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class YibancinemaApplicationTests {
	@Autowired
	SeatMapper seatMapper;
	@Test
	public void contextLoads() {

	}

}
