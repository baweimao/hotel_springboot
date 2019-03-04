package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.UserDao;
import com.dongzhi.hotel.pojo.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public void add(User bean) {
		userDao.save(bean);
	}
	
	public void delete(int id) {
		userDao.delete(id);
	}
	
	public User get(int id) {
		return userDao.findOne(id);
	}
	
	public void update(User bean) {
		userDao.save(bean);
	}
	
	public List<User> list() {
		return userDao.findAll();
	}
	
	public User getOne(User bean) {
		return userDao.findByNameAndPassword(bean.getName(), bean.getPassword());
	}
}
