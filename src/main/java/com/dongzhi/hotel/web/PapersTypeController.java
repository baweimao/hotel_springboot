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
import com.dongzhi.hotel.service.PapersTypeService;
import com.dongzhi.hotel.util.Result;

/**
 * @ClassName:     PapersTypeController.java
 * @Description:   Controller控制层
 * @author         dongzhi
 * @version        V1.0  
 * @Date           2019年2月17日 下午8:48:15
 */
@RestController
public class PapersTypeController {

	@Autowired
	PapersTypeService papersTypeService;
	
	@GetMapping("/paperstypes")
	public Object list() throws Exception{
		List<PapersType> beans = papersTypeService.list();
		return Result.success(beans);
	}
	
	@PostMapping("/paperstypes")
	public Object add(@RequestBody PapersType bean) throws Exception{
		papersTypeService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/paperstypes/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		papersTypeService.delete(id);
		return Result.success("");
	}
	
	@GetMapping("/paperstypes/{id}")
	public Object get(@PathVariable("id") int id) throws Exception{
		PapersType bean = papersTypeService.get(id);
		return Result.success(bean);
	}
	
	@PutMapping("/paperstypes")
	public Object update(@RequestBody PapersType bean) throws Exception{
		papersTypeService.update(bean);
		return Result.success(bean);
	}
}
