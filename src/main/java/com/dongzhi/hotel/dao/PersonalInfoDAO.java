package com.dongzhi.hotel.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dongzhi.hotel.pojo.PersonalInfo;

public interface PersonalInfoDAO extends JpaRepository<PersonalInfo, Integer>{

	List<PersonalInfo> findByNameLike(String name, Sort sort);
	List<PersonalInfo> findByNumberLike(int number, Sort sort);
	Page<PersonalInfo> findByIdNot(int id, Pageable pageable);
	List<PersonalInfo> findByIdNot(int id, Sort sort);
}
