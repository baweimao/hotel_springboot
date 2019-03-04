package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.RoomInfoDAO;
import com.dongzhi.hotel.pojo.RoomInfo;
import com.dongzhi.hotel.util.Page4Navigator;

@Service
public class RoomInfoService {

	public static final int able = 0; //空房
	public static final int mark = 1; //预约
	public static final int use = 2; //入住
	public static final int repair = 3; //维修
	
	@Autowired
	RoomInfoDAO roomInfoDAO;
	
	public void add(RoomInfo bean) {
		roomInfoDAO.save(bean);
	}
	
	public void delete(int id) {
		roomInfoDAO.delete(id);
	}
	
	public RoomInfo get(int id) {
		return roomInfoDAO.findOne(id);
	}
	
	public void update(RoomInfo bean) {
		roomInfoDAO.save(bean);
	}
	
	public List<RoomInfo> list() {
		Sort sort = new Sort(Direction.DESC, "id");
		return roomInfoDAO.findAll(sort);
	}
	
	public Page4Navigator list(int start, int size, int navigatePages) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = roomInfoDAO.findAll(pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	public Page4Navigator listByStatusPage(int status, int start, int size, int navigatePages) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = roomInfoDAO.findByStatus(status, pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	public List<RoomInfo> listByStatus(int status) {
		Sort sort = new Sort(Direction.DESC, "id");
		return roomInfoDAO.findByStatus(status, sort);
	}
}
