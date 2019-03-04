package com.dongzhi.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dongzhi.hotel.dao.ProductInfoDAO;
import com.dongzhi.hotel.pojo.ProductInfo;
import com.dongzhi.hotel.util.Page4Navigator;

@Service
public class ProductInfoService {

	@Autowired
	ProductInfoDAO productInfoDAO;
	
	public void add(ProductInfo bean) {
		productInfoDAO.save(bean);
	}
	
	public void delete(int id) {
		productInfoDAO.delete(id);
	}
	
	public ProductInfo get(int id) {
		return productInfoDAO.findOne(id);
	}
	
	public void update(ProductInfo bean) {
		productInfoDAO.save(bean);
	}
	
	public List<ProductInfo> list() {
		Sort sort = new Sort(Direction.DESC, "id");
		return productInfoDAO.findAll(sort);
	}
	
	public Page4Navigator list(int start, int size, int navigatePages) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page pageFromJPA = productInfoDAO.findAll(pageable);
		return new Page4Navigator<>(pageFromJPA, navigatePages);
	}
}
