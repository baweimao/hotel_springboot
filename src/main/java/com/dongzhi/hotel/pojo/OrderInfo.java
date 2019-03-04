package com.dongzhi.hotel.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "order_info")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "room_info_id")
	private RoomInfo roomInfo;
	
	@ManyToOne
	@JoinColumn(name = "team_info_id")
	private TeamInfo teamInfo;
	
	@ManyToOne
	@JoinColumn(name = "personal_info_id")
	private PersonalInfo personalInfo;
	
	@Transient
	private List<ConsumeInfo> consumeInfo;
	
	@Transient
	private float consumePrice;
	
	@Transient
	private int peopleTotal;
	
	private Integer days;
	private Integer status;
	private String remarks;
	private Date reserveTime;
	private Date inTime;
	private Date outTime;
	
	public int getPeopleTotal() {
		return peopleTotal;
	}
	public void setPeopleTotal(int peopleTotal) {
		this.peopleTotal = peopleTotal;
	}
	public float getConsumePrice() {
		return consumePrice;
	}
	public void setConsumePrice(float consumePrice) {
		this.consumePrice = consumePrice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RoomInfo getRoomInfo() {
		return roomInfo;
	}
	public void setRoomInfo(RoomInfo roomInfo) {
		this.roomInfo = roomInfo;
	}
	public TeamInfo getTeamInfo() {
		return teamInfo;
	}
	public void setTeamInfo(TeamInfo teamInfo) {
		this.teamInfo = teamInfo;
	}
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public List<ConsumeInfo> getConsumeInfo() {
		return consumeInfo;
	}
	public void setConsumeInfo(List<ConsumeInfo> consumeInfo) {
		this.consumeInfo = consumeInfo;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	public Date getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(Date reserveTime) {
		this.reserveTime = reserveTime;
	}
	
}
