package com.dongzhi.hotel.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dongzhi.hotel.pojo.PapersType;
import com.dongzhi.hotel.pojo.RoomType;
import com.dongzhi.hotel.service.RoomTypeService;
import com.dongzhi.hotel.util.Result;

@RestController
public class RoomTypeController {

	@Autowired
	RoomTypeService roomTypeService;
	
	@GetMapping("/roomtypes")
	public Object list() throws Exception{
		List<RoomType> beans = roomTypeService.list();
		return Result.success(beans);
	}
	
	@PostMapping("/roomtypes")
	public Object add(@RequestBody RoomType bean) throws Exception{
		roomTypeService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/roomtypes/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		roomTypeService.delete(id);
		return Result.success("");
	}
	
	@GetMapping("/roomtypes/{id}")
	public Object get(@PathVariable("id") int id) throws Exception{
		RoomType bean = roomTypeService.get(id);
		return Result.success(bean);
	}
	
	@PutMapping("/roomtypes")
	public Object update(@RequestBody RoomType bean) throws Exception{
		roomTypeService.update(bean);
		return Result.success(bean);
	}
}
