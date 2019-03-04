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
import com.dongzhi.hotel.pojo.RoomInfo;
import com.dongzhi.hotel.service.RoomInfoService;
import com.dongzhi.hotel.util.Page4Navigator;
import com.dongzhi.hotel.util.Result;

@RestController
public class RoomInfoController {

	@Autowired
	RoomInfoService roomInfoService;
	
	@GetMapping("/roominfos")
	public Object list(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		Page4Navigator<RoomInfo> page = roomInfoService.list(start, size, 5);
		return Result.success(page);
	}
	
	@GetMapping("/roominfos/able")
	public Object listAble(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		Page4Navigator<RoomInfo> page = roomInfoService.listByStatusPage(roomInfoService.able, start, size, 5);
		return Result.success(page);
	}
	
	@GetMapping("/roominfos/able/all")
	public Object listAllAble() throws Exception{
		List<RoomInfo> beans = roomInfoService.listByStatus(roomInfoService.able);
		return Result.success(beans);
	}
	
	@GetMapping("/roominfos/mark")
	public Object listMark(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		Page4Navigator<RoomInfo> page = roomInfoService.listByStatusPage(roomInfoService.mark, start, size, 5);
		return Result.success(page);
	}
	
	@GetMapping("/roominfos/use")
	public Object listUse(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		Page4Navigator<RoomInfo> page = roomInfoService.listByStatusPage(roomInfoService.use, start, size, 5);
		return Result.success(page);
	}
	
	@GetMapping("/roominfos/repair")
	public Object listRepair(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
		Page4Navigator<RoomInfo> page = roomInfoService.listByStatusPage(roomInfoService.repair, start, size, 5);
		return Result.success(page);
	}
	
	@PostMapping("/roominfos")
	public Object add(@RequestBody RoomInfo bean) throws Exception{
		bean.setStatus(roomInfoService.able);
		roomInfoService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/roominfos/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		roomInfoService.delete(id);
		return Result.success("");
	}
	
	@GetMapping("/roominfos/{id}")
	public Object get(@PathVariable("id") int id) throws Exception{
		RoomInfo bean = roomInfoService.get(id);
		return Result.success(bean);
	}
	
	@PutMapping("/roominfos")
	public Object update(@RequestBody RoomInfo bean) throws Exception{
		roomInfoService.update(bean);
		return Result.success(bean);
	}
}
