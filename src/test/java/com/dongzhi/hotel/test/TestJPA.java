package com.dongzhi.hotel.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.dongzhi.hotel.Application;
import com.dongzhi.hotel.dao.RoomInfoDAO;
import com.dongzhi.hotel.pojo.OrderInfo;
import com.dongzhi.hotel.pojo.PapersType;
import com.dongzhi.hotel.pojo.RoomInfo;
import com.dongzhi.hotel.pojo.User;
import com.dongzhi.hotel.service.OrderInfoService;
import com.dongzhi.hotel.service.PapersTypeService;
import com.dongzhi.hotel.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestJPA {

	@Autowired
	UserService userService;
	@Autowired
	PapersTypeService papersTypeService;
	@Autowired
	RoomInfoDAO roomInfoDAO;
	@Autowired
	OrderInfoService orderInfoService;
	
	@Test
	public void test() {
		OrderInfo orderInfo = orderInfoService.get(11);
		List<OrderInfo> orderInfos = orderInfoService.listByMonth(new Date());
		int total = orderInfoService.peopleByOrders(orderInfos);
		System.out.println(total);
		System.out.println("执行成功");
	}

}
