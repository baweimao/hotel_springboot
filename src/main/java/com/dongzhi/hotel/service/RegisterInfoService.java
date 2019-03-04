package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.RegisterInfoDAO;
import com.dongzhi.hotel.pojo.OrderInfo;
import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.pojo.RegisterInfo;
import com.dongzhi.hotel.util.Page4Navigator;

@Service
public class RegisterInfoService {

	@Autowired
	RegisterInfoDAO registerInfoDAO;
	@Autowired
	PersonalInfoService personalInfoService;
	
	public void add(RegisterInfo bean) {
		registerInfoDAO.save(bean);
	}
	
	public void delete(int id) {
		registerInfoDAO.delete(id);
	}
	
	public RegisterInfo get(int id) {
		return registerInfoDAO.findOne(id);
	}
	
	public void update(RegisterInfo bean) {
		registerInfoDAO.save(bean);
	}
	
	public List<RegisterInfo> list() {
		return registerInfoDAO.findAll();
	}
	
	public List<RegisterInfo> listByOrderInfo(OrderInfo orderInfo) {
		return registerInfoDAO.findByOrderInfo(orderInfo);
	}
	
	public Page4Navigator<RegisterInfo> listByPersonalInfo(int id , int start, int size, int navigatePages) {
		PersonalInfo personalInfo = personalInfoService.get(id);
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = registerInfoDAO.findByPersonalInfo(personalInfo, pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}

}
