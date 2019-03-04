package com.dongzhi.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dongzhi.hotel.pojo.ConsumeInfo;
import com.dongzhi.hotel.pojo.OrderInfo;

public interface ConsumeInfoDAO extends JpaRepository<ConsumeInfo, Integer>{

	List<ConsumeInfo> findByOrderInfo(OrderInfo orderInfo);
}
