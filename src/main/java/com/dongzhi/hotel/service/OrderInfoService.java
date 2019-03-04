package com.dongzhi.hotel.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.ConsumeInfoDAO;
import com.dongzhi.hotel.dao.OrderInfoDAO;
import com.dongzhi.hotel.pojo.ConsumeInfo;
import com.dongzhi.hotel.pojo.OrderInfo;
import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.pojo.RegisterInfo;
import com.dongzhi.hotel.pojo.RoomInfo;
import com.dongzhi.hotel.pojo.TeamInfo;
import com.dongzhi.hotel.util.Page4Navigator;

@Service
public class OrderInfoService {

	/** 预约 */
	public static final int mark = 0;
	
	/** 未登记 */
	public static final int unregister = 1;
	
	/** 登记 */
	public static final int registered = 2;
	
	/** 订单完成 */
	public static final int finish = 3;
	
	/** 取消订单 */
	public static final int off = 4;
	
	@Autowired
	OrderInfoDAO orderInfoDAO;
	@Autowired
	PersonalInfoService personalInfoService;
	@Autowired
	TeamInfoService teamInfoService;
	@Autowired
	ConsumeInfoService consumeInfoService;
	@Autowired
	RegisterInfoService registerInfoService;
	
	public void add(OrderInfo bean) {
		orderInfoDAO.save(bean);
	}
	
	public void delete(int id) {
		orderInfoDAO.delete(id);
	}
	
	public OrderInfo get(int id) {
		return orderInfoDAO.findOne(id);
	}
	
	public void update(OrderInfo bean) {
		orderInfoDAO.save(bean);
	}
	
	public List<OrderInfo> list() {
		Sort sort = new Sort(Direction.DESC, "id");
		return orderInfoDAO.findAll(sort);
	}
	
	public Page4Navigator list(int start, int size, int navigatePages) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = orderInfoDAO.findAll(pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	/**
	 * @Description:  根据订单状态分页查询
	 * @param:        @param status
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @param navigatePages
	 * @param:        @return    
	 * @return:       Page4Navigator
	 */
	public Page4Navigator listByStatus(int status, int start, int size, int navigatePages) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = orderInfoDAO.findByStatus(status, pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	/**
	 * @Description:  根据订单状态(同时查询两种状态)分页查询
	 * @param:        @param status
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @param navigatePages
	 * @param:        @return    
	 * @return:       Page4Navigator
	 */
	public Page4Navigator listByStatusBetween(int status, int status2, int start, int size, int navigatePages) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = orderInfoDAO.findByStatusBetween(status, status2, pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	/**
	 * @Description:  根据入住时间区间分页查询所有订单
	 * @param:        @param inTime
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @param navigatePages
	 * @param:        @return    
	 * @return:       Page4Navigator
	 */
	public Page4Navigator listByInTime(Date startTime, Date endTime, int start, int size, int navigatePages) {	
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = orderInfoDAO.findByInTimeBetween(startTime, endTime, pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	/**
	 * @Description:  根据当前月份查询所有订单
	 * @param:        @param date
	 * @param:        @return    
	 * @return:       List<OrderInfo>
	 */
	public List<OrderInfo> listByMonth(Date date) {
		Date startData = DateUtils.truncate(date, Calendar.MONTH);
		Calendar c = new GregorianCalendar();
		c.setTime(startData);
		c.add(Calendar.MONTH, 1);
		Date endDate = c.getTime();
		return listByTime(startData, endDate);
	}
	
	/**
	 * @Description:  根据入住时间区间查询所有订单
	 * @param:        @param inTime
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @param navigatePages
	 * @param:        @return    
	 * @return:       Page4Navigator
	 */
	public List<OrderInfo> listByTime(Date startTime, Date endTime) {		
		Sort sort = new Sort(Direction.DESC, "id");
		return orderInfoDAO.findByInTimeBetween(startTime, endTime);
	}
	
	/**
	 * @Description:  根据预约的某个人分页查询所有订单
	 * @param:        @param id
	 * @param:        @return    
	 * @return:       List<OrderInfo>
	 */
	public Page4Navigator<OrderInfo> listByPersonalInfo(int id , int start, int size, int navigatePages) {
		PersonalInfo personalInfo = personalInfoService.get(id);
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = orderInfoDAO.findByPersonalInfo(personalInfo, pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	/**
	 * @Description:  根据某个团队分页查询所有订单 
	 * @param:        @param id
	 * @param:        @return    
	 * @return:       List<OrderInfo>
	 */
	public Page4Navigator<OrderInfo> listByTeamInfo(int id , int start, int size, int navigatePages) {
		TeamInfo teamInfo = teamInfoService.get(id);
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = orderInfoDAO.findByTeamInfo(teamInfo, pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	/**
	 * @Description:  初始化每笔订单的商品消费总额和登记人数
	 * @param:        @param navigator    
	 * @return:       void
	 */
	public void initConsumeAndPeopleTotalByOrders(Page4Navigator<OrderInfo> navigator) {
		List<OrderInfo> orderInfos = navigator.getContent();
		if(!orderInfos.isEmpty()) {
			for(OrderInfo orderInfo : orderInfos) {
				initConsumeByOrder(orderInfo);
				initPeopleTotalByOrder(orderInfo);
			}
		}
	}
	
	/**
	 * @Description:  初始化每笔订单的商品消费总额和登记人数
	 * @param:        @param navigator    
	 * @return:       void
	 */
	public void initConsumeAndPeopleTotalByOrders(List<OrderInfo> orderInfos) {
		if(!orderInfos.isEmpty()) {
			for(OrderInfo orderInfo : orderInfos) {
				initConsumeByOrder(orderInfo);
				initPeopleTotalByOrder(orderInfo);
			}
		}
	}
	
	/**
	 * @Description:  计算单笔订单的商品消费总额
	 * @param:        @param orderInfo    
	 * @return:       void
	 */
	public void initConsumeByOrder(OrderInfo orderInfo) {
		float total = 0;
		List<ConsumeInfo> consumeInfos = consumeInfoService.listByOrderInfo(orderInfo);
		if(!consumeInfos.isEmpty()) {
			for(ConsumeInfo consumeInfo : consumeInfos) {
				total += consumeInfo.getNumber() * consumeInfo.getProductInfo().getPrice();
			}
			orderInfo.setConsumePrice(total);
		}
	}
	
	/**
	 * @Description:  计算单笔订单的登记人数,并装填登记人
	 * @param:        @param orderInfo    
	 * @return:       void
	 */
	public void initPeopleTotalByOrder(OrderInfo orderInfo) {
		List<RegisterInfo> registerInfos = registerInfoService.listByOrderInfo(orderInfo);
		if(!registerInfos.isEmpty()) {
			orderInfo.setPeopleTotal(registerInfos.size());
		}
	}
	
	/**
	 * @Description:  计算所有订单的所有消费总额
	 * @param:        @param orderInfo    
	 * @return:       void
	 */
	public float totalByOrders(List<OrderInfo> orderInfos) {
		float total = 0;
		if(!orderInfos.isEmpty()) {
			for(OrderInfo orderInfo : orderInfos) {
				total += totalByOrder(orderInfo);
			}
		}
		return total;
	}
	
	/**
	 * @Description:  计算单笔订单的所有消费总额
	 * @param:        @param orderInfo    
	 * @return:       void
	 */
	public float totalByOrder(OrderInfo orderInfo) {
		float roomTotal = orderInfo.getDays()*orderInfo.getRoomInfo().getPrice();
		float total = roomTotal + orderInfo.getConsumePrice();
		return total;
	}
	
	/**
	 * @Description:  计算所有订单的总入住人数
	 * @param:        @param orderInfo    
	 * @return:       void
	 */
	public int peopleByOrders(List<OrderInfo> orderInfos) {
		int total = 0;
		if(!orderInfos.isEmpty()) {
			for(OrderInfo orderInfo : orderInfos) {
				total += orderInfo.getPeopleTotal();
			}
		}
		return total;
	}
	
}
