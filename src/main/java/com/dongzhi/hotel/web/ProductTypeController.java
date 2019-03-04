package com.dongzhi.hotel.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dongzhi.hotel.pojo.PapersType;
import com.dongzhi.hotel.pojo.ProductType;
import com.dongzhi.hotel.service.ProductTypeService;
import com.dongzhi.hotel.util.Result;

@RestController
public class ProductTypeController {

	@Autowired
	ProductTypeService productTypeService;
	
	@GetMapping("/producttypes")
	public Object list() throws Exception{
		List<ProductType> beans = productTypeService.list();
		return Result.success(beans);
	}
	
	@PostMapping("/producttypes")
	public Object add(@RequestBody ProductType bean) throws Exception{
		productTypeService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/producttypes/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		productTypeService.delete(id);
		return Result.success("");
	}
	
	@GetMapping("/producttypes/{id}")
	public Object get(@PathVariable("id") int id) throws Exception{
		ProductType bean = productTypeService.get(id);
		return Result.success(bean);
	}
	
	@PutMapping("/producttypes")
	public Object update(@RequestBody ProductType bean) throws Exception{
		productTypeService.update(bean);
		return Result.success(bean);
	}
}
