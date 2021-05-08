package com.gxwz.medical.entity;

import java.util.Date;

/*
 * 参合登记表类
 * 
 */
public class Persinfo {
	
	// 自增主键
    private Integer id;
    
    // 身份证号
    private String cardno;
    
    // 姓名
    private String persname;
    
    // 性别
    private String sex;
    
    // 年龄
    private String age;
    
    // 家庭地址
    private String address;
    
    // 家庭联系方式
    private String tel;
    
    // 参合时间
    private String joinyear;

    // 参合发票
    private String invnumber;

    // 参合证号
    private String persnumber;
    
    // 家庭档案表ID
    private Integer familyid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getPersname() {
		return persname;
	}

	public void setPersname(String persname) {
		this.persname = persname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJoinyear() {
		return joinyear;
	}

	public void setJoinyear(String joinyear) {
		this.joinyear = joinyear;
	}

	public String getInvnumber() {
		return invnumber;
	}

	public void setInvnumber(String invnumber) {
		this.invnumber = invnumber;
	}

	public String getPersnumber() {
		return persnumber;
	}

	public void setPersnumber(String persnumber) {
		this.persnumber = persnumber;
	}

	public Integer getFamilyid() {
		return familyid;
	}

	public void setFamilyid(Integer familyid) {
		this.familyid = familyid;
	}

	@Override
	public String toString() {
		return "Persinfo [id=" + id + ", cardno=" + cardno + ", persname=" + persname + ", sex=" + sex + ", age=" + age
				+ ", address=" + address + ", tel=" + tel + ", joinyear=" + joinyear + ", invnumber=" + invnumber
				+ ", persnumber=" + persnumber + ", familyid=" + familyid + "]";
	}

	
}