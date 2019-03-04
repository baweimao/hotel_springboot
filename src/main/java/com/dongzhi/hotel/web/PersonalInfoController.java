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

import com.dongzhi.hotel.pojo.PersonalInfo;
import com.dongzhi.hotel.service.PersonalInfoService;
import com.dongzhi.hotel.util.Page4Navigator;
import com.dongzhi.hotel.util.Result;

@RestController
public class PersonalInfoController {

	@Autowired
	PersonalInfoService personalInfoService;
	
	@GetMapping("/personalinfos")
	public Object list(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		Page4Navigator<PersonalInfo> page = personalInfoService.list(start, size, 5);
		return Result.success(page);
	}
	
	@PostMapping("/personalinfos")
	public Object add(@RequestBody PersonalInfo bean) throws Exception{
		personalInfoService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/personalinfos/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		personalInfoService.delete(id);
		return Result.success("");
	}
	
	@GetMapping("/personalinfos/{id}")
	public Object get(@PathVariable("id") int id) throws Exception{
		PersonalInfo bean = personalInfoService.get(id);
		return Result.success(bean);
	}
	
	@PutMapping("/personalinfos")
	public Object update(@RequestBody PersonalInfo bean) throws Exception{
		personalInfoService.update(bean);
		return Result.success(bean);
	}
	
	@GetMapping("/personalinfos/all")
	public Object listAll() throws Exception{
		List<PersonalInfo> beans = personalInfoService.list();
		return Result.success(beans);
	}
	
	@GetMapping("/personalinfos/searchname")
	public Object searchName(@RequestParam("name") String name) throws Exception{
		System.out.println("name"+name);
		List<PersonalInfo> beans = personalInfoService.listByName("%"+name+"%");
		System.out.println(beans.get(0).getName());
		return Result.success(beans);
	}
	
	@GetMapping("/personalinfos/searchnumber")
	public Object searchNumber(@RequestParam("name") int number) throws Exception{
		System.out.println(number);
		List<PersonalInfo> beans = personalInfoService.listByNumber(number);
		System.out.println(beans.get(0).getName());
		return Result.success(beans);
	}
}
