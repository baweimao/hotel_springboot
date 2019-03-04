package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.TeamInfoDAO;
import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.pojo.TeamInfo;
import com.dongzhi.hotel.util.Page4Navigator;

@Service
public class TeamInfoService {

	@Autowired
	TeamInfoDAO teamInfoDAO;
	
	public void add(TeamInfo bean) {
		teamInfoDAO.save(bean);
	}
	
	public void delete(int id) {
		teamInfoDAO.delete(id);
	}
	
	public TeamInfo get(int id) {
		return teamInfoDAO.findOne(id);
	}
	
	public void update(TeamInfo bean) {
		teamInfoDAO.save(bean);
	}
	
	public List<TeamInfo> list() {
		Sort sort = new Sort(Direction.DESC, "id");
		return teamInfoDAO.findAll(sort);
	}
	
	/**
	 * @Description:  团队分页查询，忽略查询第一个默认name为“散客”的id
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @param navigatePages
	 * @param:        @return    
	 * @return:       Page4Navigator
	 */
	public Page4Navigator list(int start, int size, int navigatePages) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		//teaminfo表默认第一个id为散客，不能删除，因此忽略查询。
		Page pageFromJPA = teamInfoDAO.findByIdNot(1, pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	public List<TeamInfo> listByName(String name) {
		Sort sort = new Sort(Direction.DESC, "id");
		return teamInfoDAO.findByName(name, sort);
	}
}
