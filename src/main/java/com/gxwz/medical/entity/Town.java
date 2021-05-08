package com.gxwz.medical.entity;

/*
 * 区域(镇)类
 * 
 */
public class Town {
	private Integer id;

	private String areaid;

	private String area;

	private String father;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid == null ? null : areaid.trim();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area == null ? null : area.trim();
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father == null ? null : father.trim();
	}
	@Override
	public String toString() {
		return "Town [id=" + id + ", areaid=" + areaid + ", area=" + area + ", father=" + father + "]";
	}

   
}