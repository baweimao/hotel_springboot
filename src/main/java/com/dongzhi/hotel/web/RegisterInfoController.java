package com.dongzhi.hotel.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dongzhi.hotel.pojo.OrderInfo;
import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.pojo.RegisterInfo;
import com.dongzhi.hotel.service.OrderInfoService;
import com.dongzhi.hotel.service.PersonalInfoService;
import com.dongzhi.hotel.service.RegisterInfoService;
import com.dongzhi.hotel.util.Page4Navigator;
import com.dongzhi.hotel.util.Result;

@RestController
public class RegisterInfoController {

	@Autowired
	RegisterInfoService registerInfoService;
	@Autowired
	OrderInfoService orderInfoService;
	@Autowired
	PersonalInfoService personalInfoService;
	
//	@GetMapping("/registerinfos")
//	public Object list() throws Exception{
//		List<RegisterInfo> beans = registerInfoService.list();
//		return Result.success(beans);
//	}
	
	/**
	 * @Description:  根据订单查询所有登记表
	 * @param:        @param id
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/{id}/registerinfos")
	public Object listByOrder(@PathVariable("id") int id) throws Exception{
		OrderInfo orderInfo = orderInfoService.get(id);
		List<RegisterInfo> beans = registerInfoService.listByOrderInfo(orderInfo);
		return Result.success(beans);
	}
	
	/**
	 * @Description:  增加登记表并关联订单id，修改主订单状态
	 * @param:        @param id
	 * @param:        @param bean
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@PostMapping("/orderinfos/{id}/registerinfos")
	public Object add(@PathVariable("id") int id, @RequestBody RegisterInfo bean) throws Exception{
		//获取相关订单信息
		OrderInfo orderInfo = orderInfoService.get(id);
		
		bean.setOrderInfo(orderInfo);
		registerInfoService.add(bean);
		
		//修改订单状态为已登记
		orderInfo.setStatus(orderInfoService.registered);
		orderInfoService.update(orderInfo);
		
		return Result.success(bean);
	}
	
	/**
	 * @Description:  删除登记表并修改主订单状态
	 * @param:        @param id
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@DeleteMapping("/registerinfos/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		//获取删除登记表的从属订单信息
		OrderInfo orderInfo = registerInfoService.get(id).getOrderInfo();
		
		registerInfoService.delete(id);
		//判断此订单下是否还有登记表，没有则更新订单状态为未登记
		List<RegisterInfo> beans = registerInfoService.listByOrderInfo(orderInfo);
		if(beans.isEmpty()) {
			orderInfo.setStatus(orderInfoService.unregister);
			orderInfoService.update(orderInfo);
		}
		return Result.success("");
	}
	
//	@GetMapping("/registerinfos/{id}")
//	public Object get(@PathVariable("id") int id) throws Exception{
//		RegisterInfo bean = registerInfoService.get(id);
//		return Result.success(bean);
//	}
//	
//	@PutMapping("/registerinfos")
//	public Object update(@RequestBody RegisterInfo bean) throws Exception{
//		registerInfoService.update(bean);
//		return Result.success(bean);
//	}
	
	
	/**
	 * @Description:  根据旅客id获取该旅客所有登记集合) 
	 * @param:        @param personalId
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/personalinfos/{id}/registerinfos")
	public Object listPersonal(@PathVariable("id") int id, @RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		start = start<0?0:start;
		Page4Navigator<RegisterInfo> page = registerInfoService.listByPersonalInfo(id, start, size, 5);
		
		//初始化登记相关订单的消费和人数
		List<RegisterInfo> registerInfos = page.getContent();
		for(RegisterInfo registerInfo : registerInfos) {
			OrderInfo orderInfo = registerInfo.getOrderInfo();
			orderInfoService.initConsumeByOrder(orderInfo);
			orderInfoService.initPeopleTotalByOrder(orderInfo);
		}
		return Result.success(page);
	}

}
