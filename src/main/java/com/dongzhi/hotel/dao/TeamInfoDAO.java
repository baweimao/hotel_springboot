package com.dongzhi.hotel.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dongzhi.hotel.pojo.TeamInfo;

public interface TeamInfoDAO extends JpaRepository<TeamInfo, Integer>{

	List<TeamInfo> findByName(String name, Sort sort);
	Page<TeamInfo> findByIdNot(int id, Pageable pageable);
}
