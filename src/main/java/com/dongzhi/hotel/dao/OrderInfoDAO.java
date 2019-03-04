package com.dongzhi.hotel.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dongzhi.hotel.pojo.OrderInfo;
import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.pojo.TeamInfo;

public interface OrderInfoDAO extends JpaRepository<OrderInfo, Integer>{

	Page<OrderInfo> findByStatus(int status, Pageable pageable);
	Page<OrderInfo> findByStatusBetween(int status, int status2, Pageable pageable);
	Page<OrderInfo> findByInTimeBetween(Date date1, Date date2, Pageable pageable);
	List<OrderInfo> findByInTimeBetween(Date date1, Date date2);
	Page<OrderInfo> findByPersonalInfo(PersonalInfo personalInfo, Pageable pageable);
	Page<OrderInfo> findByTeamInfo(TeamInfo teamInfo, Pageable pageable);
}
