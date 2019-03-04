package com.dongzhi.hotel.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dongzhi.hotel.pojo.RoomInfo;

public interface RoomInfoDAO extends JpaRepository<RoomInfo, Integer>{

	List<RoomInfo> findByStatus(int status, Sort sort);
	Page<RoomInfo> findByStatus(int status, Pageable pageable);
}
