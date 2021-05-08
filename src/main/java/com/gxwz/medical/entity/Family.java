package com.gxwz.medical.entity;

//家庭档案类
public class Family {

	// 自增主键
	private Integer fid;
	
	// 县级编号
	private String countyno;

	// 乡镇编号
	private String townshipno;

	// 村编号
	private String groupno;

	// 家庭编号
	private String familyno;

	// 户主姓名
	private String mastername;
	
	// 家庭人口数
	private String familynumber;

	// 家庭地址
	private String address;

	// 联系方式
	private String tel;
	
	
	private Integer perid;
	
	// 与户主的关系
	private String bind;

	//参合状态
	private Integer perstate;

	// 身份证号码
	private String cardno;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getCountyno() {
		return countyno;
	}

	public void setCountyno(String countyno) {
		this.countyno = countyno;
	}

	public String getTownshipno() {
		return townshipno;
	}

	public void setTownshipno(String townshipno) {
		this.townshipno = townshipno;
	}

	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	public String getFamilyno() {
		return familyno;
	}

	public void setFamilyno(String familyno) {
		this.familyno = familyno;
	}

	public String getMastername() {
		return mastername;
	}

	public void setMastername(String mastername) {
		this.mastername = mastername;
	}

	public String getFamilynumber() {
		return familynumber;
	}

	public void setFamilynumber(String familynumber) {
		this.familynumber = familynumber;
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

	public Integer getPerid() {
		return perid;
	}

	public void setPerid(Integer perid) {
		this.perid = perid;
	}

	public String getBind() {
		return bind;
	}

	public void setBind(String bind) {
		this.bind = bind;
	}

	public Integer getPerstate() {
		return perstate;
	}

	public void setPerstate(Integer perstate) {
		this.perstate = perstate;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	@Override
	public String toString() {
		return "Family [fid=" + fid + ", countyno=" + countyno + ", townshipno=" + townshipno + ", groupno=" + groupno
				+ ", familyno=" + familyno + ", mastername=" + mastername + ", familynumber=" + familynumber
				+ ", address=" + address + ", tel=" + tel + ", perid=" + perid + ", bind=" + bind + ", perstate="
				+ perstate + ", cardno=" + cardno + "]";
	}

	
	
}