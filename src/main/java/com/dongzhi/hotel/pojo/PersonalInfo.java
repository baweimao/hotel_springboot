package com.dongzhi.hotel.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "personal_info")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class PersonalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "papers_type_id")
	private PapersType papersType;
	
	private String name;
	private Integer sex;
	private String number;
	private String address;
	private String phone;
	private String remarks;
	private String nation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PapersType getPapersType() {
		return papersType;
	}
	public void setPapersType(PapersType papersType) {
		this.papersType = papersType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "PersonalInfo [id=" + id + "papersType(id)="+ papersType.getId() +", name=" + name + ", sex=" + sex +", number=" + number +", address=" + address +", phone=" + phone +", remarks=" + remarks +", nation=" + nation +"]";
	}
}
