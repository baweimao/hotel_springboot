package com.dongzhi.hotel.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.PageableExecutionUtils.TotalSupplier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dongzhi.hotel.pojo.OrderInfo;
import com.dongzhi.hotel.pojo.PapersType;
import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.pojo.RoomInfo;
import com.dongzhi.hotel.service.OrderInfoService;
import com.dongzhi.hotel.service.PersonalInfoService;
import com.dongzhi.hotel.service.RegisterInfoService;
import com.dongzhi.hotel.service.RoomInfoService;
import com.dongzhi.hotel.util.Page4Navigator;
import com.dongzhi.hotel.util.Result;

@RestController
public class OrderInfoController {

	@Autowired
	OrderInfoService orderInfoService;
	@Autowired
	PersonalInfoService personalInfoService;
	@Autowired
	RegisterInfoService registerInfoService;
	@Autowired
	RoomInfoService roomInfoService;
	
	/**
	 * @Description:  默认全类型订单分页查询
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos")
	public Object list(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		start = start<0?0:start;
		Page4Navigator<OrderInfo> page = orderInfoService.list(start, size, 5);
		orderInfoService.initConsumeAndPeopleTotalByOrders(page);
		return Result.success(page);
	}
	
	@PostMapping("/orderinfos")
	public Object add(@RequestBody OrderInfo bean) throws Exception{
		orderInfoService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/orderinfos/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		orderInfoService.delete(id);
		return Result.success("");
	}
	
	@GetMapping("/orderinfos/{id}")
	public Object get(@PathVariable("id") int id) throws Exception{
		OrderInfo bean = orderInfoService.get(id);
		return Result.success(bean);
	}
	
	@PutMapping("/orderinfos")
	public Object update(@RequestBody OrderInfo bean) throws Exception{
		orderInfoService.update(bean);
		return Result.success(bean);
	}


	
/*************** 以下为订单获取 ***************************/

	/**
	 * @Description:  获取预约订单集合
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/mark")
	public Object listMark(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		start = start<0?0:start;
		Page4Navigator<OrderInfo> page = orderInfoService.listByStatus(orderInfoService.mark, start, size, 5);
		orderInfoService.initConsumeAndPeopleTotalByOrders(page);
		return Result.success(page);
	}
	
	/**
	 * @Description:  获取未登记订单集合
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/unregister")
	public Object listUnRegister(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		start = start<0?0:start;
		Page4Navigator<OrderInfo> page = orderInfoService.listByStatus(orderInfoService.unregister, start, size, 5);
		orderInfoService.initConsumeAndPeopleTotalByOrders(page);
		return Result.success(page);
	}
	
	/**
	 * @Description:  获取已经登记订单集合
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/registered")
	public Object listRegistered(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		start = start<0?0:start;
		Page4Navigator<OrderInfo> page = orderInfoService.listByStatus(orderInfoService.registered,start, size, 5);
		orderInfoService.initConsumeAndPeopleTotalByOrders(page);
		return Result.success(page);
	}
	
	/**
	 * @Description:  获取已登记和未登记集合
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/register")
	public Object listRegister(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		start = start<0?0:start;
		Page4Navigator<OrderInfo> page = orderInfoService.listByStatusBetween(orderInfoService.unregister, orderInfoService.registered, start, size, 5);
		orderInfoService.initConsumeAndPeopleTotalByOrders(page);
		return Result.success(page);
	}
	
//	/**
//	 * @Description:  获取完成订单集合 
//	 * @param:        @param start
//	 * @param:        @param size
//	 * @param:        @return
//	 * @param:        @throws Exception    
//	 * @return:       Object
//	 */
//	@GetMapping("/orderinfos/finish")
//	public Object listFinish(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
//		start = start<0?0:start;
//		Page4Navigator<OrderInfo> page = orderInfoService.listByStatus(orderInfoService.finish, start, size, 5);
//		orderInfoService.initConsumeAndPeopleTotalByOrders(page);
//		return Result.success(page);
//	}
//	
//	/**
//	 * @Description:  获取取消订单集合 
//	 * @param:        @param start
//	 * @param:        @param size
//	 * @param:        @return
//	 * @param:        @throws Exception    
//	 * @return:       Object
//	 */
//	@GetMapping("/orderinfos/off")
//	public Object listOff(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
//		start = start<0?0:start;
//		Page4Navigator<OrderInfo> page = orderInfoService.listByStatus(orderInfoService.off, start, size, 5);
//		orderInfoService.initConsumeAndPeopleTotalByOrders(page);
//		return Result.success(page);
//	}

	/**
	 * @Description:  根据时间区间获取所有订单集合
	 * @param:        @param startTime
	 * @param:        @param endTime
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/time")
	public Object listTime(@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime, @RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		//解析时间字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(startTime);
		Date endDate = sdf.parse(endTime);
		
		start = start<0?0:start;
		Page4Navigator<OrderInfo> page = orderInfoService.listByInTime(startDate, endDate, start, size, 5);
		orderInfoService.initConsumeAndPeopleTotalByOrders(page);
		return Result.success(page);
	}

	/**
	 * @Description:  最近12个月营收数据统计
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/data")
	public Object listData() throws Exception{
		
		List<Float> totals = new ArrayList<>(); //存放12个月每月总营收
		List<Integer> months = new ArrayList<>(); //存放12个月月份
		List<Integer> peoples = new ArrayList<>(); //存放12个月每月入住人数
		Map<String, Object> beans = new HashMap<>();
		
		Date day = new Date(); //获取当前日期
		Calendar c = new GregorianCalendar(); //创建日历类
		c.setTime(day);
		
		for (int i = 0; i < 12; i++) {
			
			//月份装填
			int month = c.get(Calendar.MONTH);
			month += 1; //基0，改为基1
			months.add(month);
			
			//查询并初始化
			List<OrderInfo> orderInfos = orderInfoService.listByMonth(day);
			orderInfoService.initConsumeAndPeopleTotalByOrders(orderInfos);
			
			//每月总营收装填
			float total = orderInfoService.totalByOrders(orderInfos);
			totals.add(total);
			
			//每月入住人数装填
			int people = orderInfoService.peopleByOrders(orderInfos);
			peoples.add(people);
			
			//日历类和data类同时减1月
			c.add(Calendar.MONTH, -1);
			day = c.getTime();
		}
		
		//坐标系倒序排列
		Collections.reverse(months);
		Collections.reverse(totals);
		Collections.reverse(peoples);
		
		beans.put("peoples", peoples);
		beans.put("months", months);
		beans.put("totals", totals);
		return Result.success(beans);
	}


/*************** 以下为新增订单 ***************************/
	
	/**
	 * @Description:  增加新订单，状态为预定 
	 * @param:        @param bean
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@PostMapping("/orderinfos/mark")
	public Object addMark(@RequestBody OrderInfo bean) throws Exception{
		
		bean.setStatus(orderInfoService.mark); //添加订单状态
		
		//房间状态同步修改
		int riid = bean.getRoomInfo().getId();
		RoomInfo roomInfo = roomInfoService.get(riid);
		roomInfo.setStatus(roomInfoService.mark);
		roomInfoService.update(roomInfo);
		
		orderInfoService.add(bean);
		return Result.success(bean);
	}
	
	/**
	 * @Description:  增加新订单，状态为未登记
	 * @param:        @param bean
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@PostMapping("/orderinfos/unregister")
	public Object addUnRegister(@RequestBody OrderInfo bean) throws Exception{
		
		bean.setStatus(orderInfoService.unregister); //添加订单状态

		//房间状态同步修改
		int riid = bean.getRoomInfo().getId();
		RoomInfo roomInfo = roomInfoService.get(riid);
		roomInfo.setStatus(roomInfoService.use);
		roomInfoService.update(roomInfo);
		
		//添加预订人为“无”
//		PersonalInfo personalInfo = personalInfoService.get(1);
//		bean.setPersonalInfo(personalInfo);
		
		bean.setInTime(new Date()); //添加入住时间
		
		orderInfoService.add(bean);
		return Result.success(bean);
	}

	
	
	
/*************** 以下为(订单修改)功能实现 ***************************/	
	
	@PutMapping("/orderinfos/mark")
	public Object updateMark(@RequestBody OrderInfo bean, @RequestParam("oldriid") int oldriid) throws Exception{
		
		//释放旧房间，修改状态
		RoomInfo oldRoomInfo = roomInfoService.get(oldriid);
		oldRoomInfo.setStatus(roomInfoService.able);
		roomInfoService.update(oldRoomInfo);
		
		//新房间状态同步修改
		int riid = bean.getRoomInfo().getId();
		RoomInfo roomInfo = roomInfoService.get(riid);
		roomInfo.setStatus(roomInfoService.mark);
		roomInfoService.update(roomInfo);
		
		orderInfoService.update(bean);
		return Result.success(bean);
	}
	
	@PutMapping("/orderinfos/register")
	public Object updateRegister(@RequestBody OrderInfo bean, @RequestParam("oldriid") int oldriid) throws Exception{
		
		//释放旧房间，修改状态
		RoomInfo oldRoomInfo = roomInfoService.get(oldriid);
		oldRoomInfo.setStatus(roomInfoService.able);
		roomInfoService.update(oldRoomInfo);
		
		//新房间状态同步修改
		int riid = bean.getRoomInfo().getId();
		RoomInfo roomInfo = roomInfoService.get(riid);
		roomInfo.setStatus(roomInfoService.use);
		roomInfoService.update(roomInfo);
		
		orderInfoService.update(bean);
		return Result.success(bean);
	}
	
	
	
/*************** 以下为(订单状态修改)功能实现 ***************************/
	
	/**
	 * @Description:  实现入住功能 
	 * @param:        @param id
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/{id}/in")
	public Object in(@PathVariable("id") int id) throws Exception{
		OrderInfo bean = orderInfoService.get(id);
		bean.setStatus(orderInfoService.unregister);
		
		//房间状态同步修改
		int riid = bean.getRoomInfo().getId();
		RoomInfo roomInfo = roomInfoService.get(riid);
		roomInfo.setStatus(roomInfoService.use);
		roomInfoService.update(roomInfo);
		
		bean.setInTime(new Date());
		orderInfoService.update(bean);
		return Result.success();
	}
	
	/**
	 * @Description:  实现登记功能 
	 * @param:        @param id
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/{id}/register")
	public Object register(@PathVariable("id") int id) throws Exception{
		OrderInfo bean = orderInfoService.get(id);
		bean.setStatus(orderInfoService.registered);
		orderInfoService.update(bean);
		return Result.success();
	}
	
	/**
	 * @Description:  实现订单完成功能
	 * @param:        @param id
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/{id}/out")
	public Object finish(@PathVariable("id") int id) throws Exception{
		
		OrderInfo bean = orderInfoService.get(id);
		bean.setStatus(orderInfoService.finish); //添加订单状态
		
		//房间状态同步修改
		int riid = bean.getRoomInfo().getId();
		RoomInfo roomInfo = roomInfoService.get(riid);
		roomInfo.setStatus(roomInfoService.able);
		roomInfoService.update(roomInfo);
		
		bean.setOutTime(new Date());
		orderInfoService.update(bean);
		return Result.success();
	}
	
	/**
	 * @Description:  实现取消订单功能
	 * @param:        @param id
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/{id}/off")
	public Object off(@PathVariable("id") int id) throws Exception{
		OrderInfo bean = orderInfoService.get(id);
		bean.setStatus(orderInfoService.off);
		
		//房间状态同步修改
		int riid = bean.getRoomInfo().getId();
		RoomInfo roomInfo = roomInfoService.get(riid);
		roomInfo.setStatus(roomInfoService.able);
		roomInfoService.update(roomInfo);
		
		orderInfoService.update(bean);
		return Result.success();
	}
}
