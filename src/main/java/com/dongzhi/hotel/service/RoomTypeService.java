package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.RoomTypeDAO;
import com.dongzhi.hotel.pojo.RoomType;

@Service
public class RoomTypeService {

	@Autowired
	RoomTypeDAO roomTypeDAO;
	
	public void add(RoomType bean) {
		roomTypeDAO.save(bean);
	}
	
	public void delete(int id) {
		roomTypeDAO.delete(id);
	}
	
	public RoomType get(int id) {
		return roomTypeDAO.findOne(id);
	}
	
	public void update(RoomType bean) {
		roomTypeDAO.save(bean);
	}
	
	public List<RoomType> list() {
		return roomTypeDAO.findAll();
	}
}
