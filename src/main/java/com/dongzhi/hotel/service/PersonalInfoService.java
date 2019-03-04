package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.PersonalInfoDAO;
import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.util.Page4Navigator;

@Service
public class PersonalInfoService {

	@Autowired
	PersonalInfoDAO personalInfoDAO;
	
	public void add(PersonalInfo bean) {
		personalInfoDAO.save(bean);
	}
	
	public void delete(int id) {
		personalInfoDAO.delete(id);
	}
	
	public PersonalInfo get(int id) {
		return personalInfoDAO.findOne(id);
	}
	
	public void update(PersonalInfo bean) {
		personalInfoDAO.save(bean);
	}
	
	/**
	 * @Description:  旅客查询，忽略查询第一个默认name为“空”的id
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @param navigatePages
	 * @param:        @return    
	 * @return:       Page4Navigator
	 */
	public List<PersonalInfo> list() {
		Sort sort = new Sort(Direction.DESC, "id");
		return personalInfoDAO.findByIdNot(1, sort);
	}
	
	/**
	 * @Description:  旅客分页查询，忽略查询第一个默认name为“空”的id
	 * @param:        @param start
	 * @param:        @param size
	 * @param:        @param navigatePages
	 * @param:        @return    
	 * @return:       Page4Navigator
	 */
	public Page4Navigator list(int start, int size, int navigatePages) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		//personalInfo表默认第一个id的name为“无”，不能删除，因此忽略查询。
		Page pageFromJPA = personalInfoDAO.findByIdNot(1, pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
	
	public List<PersonalInfo> listByName(String name) {
		Sort sort = new Sort(Direction.DESC, "id");
		return personalInfoDAO.findByNameLike(name, sort);
	}
	
	public List<PersonalInfo> listByNumber(int number) {
		Sort sort = new Sort(Direction.DESC, "id");
		return personalInfoDAO.findByNumberLike(number, sort);
	}
}
