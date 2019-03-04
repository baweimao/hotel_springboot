package com.dongzhi.hotel.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dongzhi.hotel.pojo.PapersType;
import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.pojo.ProductInfo;
import com.dongzhi.hotel.pojo.TeamInfo;
import com.dongzhi.hotel.service.ProductInfoService;
import com.dongzhi.hotel.service.TeamInfoService;
import com.dongzhi.hotel.util.Page4Navigator;
import com.dongzhi.hotel.util.Result;

@RestController
public class ProductInfoController {

	@Autowired
	ProductInfoService productInfoService;
	
	@GetMapping("/productinfos")
	public Object list(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		Page4Navigator<ProductInfo> page = productInfoService.list(start, size, 5);
		return Result.success(page);
	}
	
	@PostMapping("/productinfos")
	public Object add(@RequestBody ProductInfo bean) throws Exception{
		productInfoService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/productinfos/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		productInfoService.delete(id);
		return Result.success("");
	}
	
	@GetMapping("/productinfos/{id}")
	public Object get(@PathVariable("id") int id) throws Exception{
		ProductInfo bean = productInfoService.get(id);
		return Result.success(bean);
	}
	
	@PutMapping("/productinfos")
	public Object update(@RequestBody ProductInfo bean) throws Exception{
		productInfoService.update(bean);
		return Result.success(bean);
	}
	
	@GetMapping("/productinfos/all")
	public Object listAll() throws Exception{
		List<ProductInfo> beans = productInfoService.list();
		return Result.success(beans);
	}
}
