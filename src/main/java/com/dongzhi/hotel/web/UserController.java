package com.dongzhi.hotel.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dongzhi.hotel.pojo.PapersType;
import com.dongzhi.hotel.pojo.User;
import com.dongzhi.hotel.service.UserService;
import com.dongzhi.hotel.util.Result;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public Object list() throws Exception{
		List<User> beans = userService.list();
		return Result.success(beans);
	}
	
	@PostMapping("/users")
	public Object add(@RequestBody User bean) throws Exception{
		userService.add(bean);
		return Result.success(bean);
	}
	
	@DeleteMapping("/users/{id}")
	public Object delete(@PathVariable("id") int id) throws Exception{
		userService.delete(id);
		return Result.success("");
	}
	
	@GetMapping("/users/{id}")
	public Object get(@PathVariable("id") int id) throws Exception{
		User bean = userService.get(id);
		return Result.success(bean);
	}
	
	@PutMapping("/users")
	public Object update(@RequestBody PapersType bean) throws Exception{
		userService.list();
		return Result.success(bean);
	}
	
	@PostMapping("/users/login")
	public Object login(@RequestBody User bean, HttpSession session) throws Exception{
//		String name = HtmlUtils.htmlEscape(bean.getName());
//		bean.setName(name);

		User user = userService.getOne(bean);
		if(null == user) {
			return Result.fail("账号密码错误");
		}
		session.setAttribute("user", user);
		return Result.success(bean);
	}

}
