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
import com.dongzhi.hotel.pojo.TeamInfo;
import com.dongzhi.hotel.service.TeamInfoService;
import com.dongzhi.hotel.util.Page4Navigator;
import com.dongzhi.hotel.util.Result;

@RestController
public class TeamInfoController {

	@Autowired
	TeamInfoService teamInfoService;
	
	@GetMapping("/teaminfos")
	public Object list(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		Page4Navigator<PersonalInfo> page = teamInfoService.list(start, size, 5);
		return Result.success(page);
	}
	
	@GetMapping("/teaminfos/all")
	public Object listAll() throws Exception{
		List<TeamInfo> beans = teamInfoService.list();
		return Result.success(beans);
	}
	
	@PostMapping("/teaminfos")
	public Object add(@RequestBody TeamInfo bean) throws Exception{
		teamInfoService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/teaminfos/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		teamInfoService.delete(id);
		return Result.success("");
	}
	
	@GetMapping("/teaminfos/{id}")
	public Object get(@PathVariable("id") int id) throws Exception{
		TeamInfo bean = teamInfoService.get(id);
		return Result.success(bean);
	}
	
	@PutMapping("/teaminfos")
	public Object update(@RequestBody TeamInfo bean) throws Exception{
		teamInfoService.update(bean);
		return Result.success(bean);
	}
}
