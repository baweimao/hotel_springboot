package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.ProductTypeDAO;
import com.dongzhi.hotel.pojo.ProductType;

@Service
public class ProductTypeService {

	@Autowired
	ProductTypeDAO productTypeDAO;
	
	public void add(ProductType bean) {
		productTypeDAO.save(bean);
	}
	
	public void delete(int id) {
		productTypeDAO.delete(id);
	}
	
	public ProductType get(int id) {
		return productTypeDAO.findOne(id);
	}
	
	public void update(ProductType bean) {
		productTypeDAO.save(bean);
	}
	
	public List<ProductType> list() {
		return productTypeDAO.findAll();
	}
}
