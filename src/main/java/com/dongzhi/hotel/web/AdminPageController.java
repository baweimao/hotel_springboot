package com.dongzhi.hotel.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName:     AdminPageController.java
 * @Description:   后台页面跳转 
 * @author         dongzhi
 * @version        V1.0  
 * @Date           2019年2月17日 上午2:21:06
 */
@Controller
public class AdminPageController {

	@GetMapping(value = "/login")
	public String login() {
		return "admin/login";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:login";
	}
	
	@GetMapping(value = "/admin")
	public String admin() {
		return "redirect:admin_mark_list";
	}
	
	@GetMapping(value = "/admin_mark_list")
	public String mark() {
		return "admin/listMark";
	}
	
	@GetMapping(value = "/admin_mark_edit")
	public String markEdit() {
		return "admin/editMark";
	}
	
	@GetMapping(value = "/admin_hotel_list")
	public String hotel() {
		return "admin/listHotel";
	}
	
	@GetMapping(value = "/admin_hotel_edit")
	public String hotelEdit() {
		return "admin/editHotel";
	}
	
	@GetMapping(value = "/admin_register_list")
	public String register() {
		return "admin/listRegister";
	}
	
	@GetMapping(value = "/admin_consume_list")
	public String consume() {
		return "admin/listConsume";
	}
	
	@GetMapping(value = "/admin_personal_list")
	public String personal() {
		return "admin/listPersonal";
	}
	
	@GetMapping(value = "/admin_personal_edit")
	public String personalEdit() {
		return "admin/editPersonal";
	}
	
	@GetMapping(value = "/admin_papers_list")
	public String papers() {
		return "admin/listPapers";
	}
	
	@GetMapping(value = "/admin_papers_edit")
	public String papersEdit() {
		return "admin/editPapers";
	}
	
	@GetMapping(value = "/admin_team_list")
	public String team() {
		return "admin/listTeam";
	}
	
	@GetMapping(value = "/admin_team_edit")
	public String edit() {
		return "admin/editTeam";
	}
	
	@GetMapping(value = "/admin_room_list")
	public String room() {
		return "admin/listRoom";
	}
	
	@GetMapping(value = "/admin_room_edit")
	public String roomEdit() {
		return "admin/editRoom";
	}
	
	@GetMapping(value = "/admin_roomtype_list")
	public String roomType() {
		return "admin/listRoomType";
	}
	
	@GetMapping(value = "/admin_roomtype_edit")
	public String roomTypeEdit() {
		return "admin/editRoomType";
	}
	
	@GetMapping(value = "/admin_product_list")
	public String product() {
		return "admin/listProduct";
	}
	
	@GetMapping(value = "/admin_product_edit")
	public String productEdit() {
		return "admin/editProduct";
	}
	
	@GetMapping(value = "/admin_producttype_list")
	public String productType() {
		return "admin/listProductType";
	}
	
	@GetMapping(value = "/admin_producttype_edit")
	public String productTypeEdit() {
		return "admin/editProductType";
	}
	
	@GetMapping(value = "/admin_querytime_list")
	public String queryTime() {
		return "admin/listQueryTime";
	}
	
	@GetMapping(value = "/admin_detailstime_list")
	public String detailsTime() {
		return "admin/listDetailsTime";
	}
	
	@GetMapping(value = "/admin_querypersonal_list")
	public String queryPersonal() {
		return "admin/listQueryPersonal";
	}
	
	@GetMapping(value = "/admin_detailspersonal_list")
	public String detailsPersonal() {
		return "admin/listDetailsPersonal";
	}
	
	@GetMapping(value = "/admin_data_list")
	public String data() {
		return "admin/listData";
	}

}
