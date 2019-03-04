package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.ConsumeInfoDAO;
import com.dongzhi.hotel.pojo.ConsumeInfo;
import com.dongzhi.hotel.pojo.OrderInfo;

@Service
public class ConsumeInfoService {

	@Autowired
	ConsumeInfoDAO consumeInfoDAO;
	
	public void add(ConsumeInfo bean) {
		consumeInfoDAO.save(bean);
	}
	
	public void delete(int id) {
		consumeInfoDAO.delete(id);
	}
	
	public ConsumeInfo get(int id) {
		return consumeInfoDAO.findOne(id);
	}
	
	public void update(ConsumeInfo bean) {
		consumeInfoDAO.save(bean);
	}
	
	public List<ConsumeInfo> list() {
		return consumeInfoDAO.findAll();
	}
	
	public List<ConsumeInfo> listByOrderInfo(OrderInfo orderInfo) {
		return consumeInfoDAO.findByOrderInfo(orderInfo);
	}
}
