package com.dongzhi.hotel.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dongzhi.hotel.pojo.OrderInfo;
import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.pojo.RegisterInfo;

public interface RegisterInfoDAO extends JpaRepository<RegisterInfo, Integer>{

	List<RegisterInfo> findByOrderInfo(OrderInfo orderInfo);
	Page<RegisterInfo> findByPersonalInfo(PersonalInfo personalInfo, Pageable pageable);
}
