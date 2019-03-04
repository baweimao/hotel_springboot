package com.dongzhi.hotel.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dongzhi.hotel.pojo.ConsumeInfo;
import com.dongzhi.hotel.pojo.OrderInfo;
import com.dongzhi.hotel.pojo.PapersType;
import com.dongzhi.hotel.pojo.RegisterInfo;
import com.dongzhi.hotel.service.ConsumeInfoService;
import com.dongzhi.hotel.service.OrderInfoService;
import com.dongzhi.hotel.util.Result;

@RestController
public class ConsumeInfoController {

	@Autowired
	ConsumeInfoService consumeInfoService;
	@Autowired
	OrderInfoService orderInfoService;
	
//	@GetMapping("/consumeinfos")
//	public Object list() throws Exception{
//		List<ConsumeInfo> beans = consumeInfoService.list();
//		return Result.success(beans);
//	}
	
	/**
	 * @Description:  根据订单查询所有消费表
	 * @param:        @param id
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@GetMapping("/orderinfos/{id}/consumeinfos")
	public Object listByOrder(@PathVariable("id") int id) throws Exception{
		OrderInfo orderInfo = orderInfoService.get(id);
		List<ConsumeInfo> beans = consumeInfoService.listByOrderInfo(orderInfo);
		return Result.success(beans);
	}
	
	/**
	 * @Description:  增加消费表，并关联订单id
	 * @param:        @param id
	 * @param:        @param bean
	 * @param:        @return
	 * @param:        @throws Exception    
	 * @return:       Object
	 */
	@PostMapping("/orderinfos/{id}/consumeinfos")
	public Object add(@PathVariable("id") int id, @RequestBody ConsumeInfo bean) throws Exception{
		//获取相关订单信息
		OrderInfo orderInfo = orderInfoService.get(id);
		
		bean.setOrderInfo(orderInfo);	
		consumeInfoService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/consumeinfos/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		consumeInfoService.delete(id);
		return Result.success("");
	}
	
//	@GetMapping("/consumeinfos/{id}")
//	public Object get(@PathVariable("id") int id) throws Exception{
//		ConsumeInfo bean = consumeInfoService.get(id);
//		return Result.success(bean);
//	}
//	
//	@PutMapping("/consumeinfos")
//	public Object update(@RequestBody PapersType bean) throws Exception{
//		consumeInfoService.list();
//		return Result.success(bean);
//	}
}
