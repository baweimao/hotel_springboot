package com.dongzhi.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dongzhi.hotel.pojo.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByNameAndPassword(String name, String password);
}
