package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.PapersTypeDAO;
import com.dongzhi.hotel.pojo.PapersType;

/**
 * @ClassName:     PapersTypeService.java
 * @Description:   Service层
 * @author         dongzhi
 * @version        V1.0  
 * @Date           2019年2月17日 上午2:04:44
 */
@Service
public class PapersTypeService {

	@Autowired
	PapersTypeDAO papersTypeDAO;
	
	public void add(PapersType bean) {
		papersTypeDAO.save(bean);
	}
	
	public void delete(int id) {
		papersTypeDAO.delete(id);
	}
	
	public PapersType get(int id) {
		return papersTypeDAO.findOne(id);
	}
	
	public void update(PapersType bean) {
		papersTypeDAO.save(bean);
	}
	
	public List<PapersType> list() {
		return papersTypeDAO.findAll();
	}
}
