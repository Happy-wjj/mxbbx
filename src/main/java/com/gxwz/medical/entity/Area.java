package com.gxwz.medical.entity;

/*
 * 行政区域类
 * 
 */
public class Area {

	// 自增主键
	private String id;

	//县级编码(县级名称)
	private String cityno;

	// 镇级编码(镇级名称)
	private String areaname;

	//乡级编码(乡级名称)
	private String level;

	//乡组编码(乡组名称)
	private String group;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityno() {
		return cityno;
	}

	public void setCityno(String cityno) {
		this.cityno = cityno;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}


	@Override
	public String toString() {
		return "Area{" +
				"id='" + id + '\'' +
				", cityno='" + cityno + '\'' +
				", areaname='" + areaname + '\'' +
				", level='" + level + '\'' +
				", group='" + group + '\'' +
				'}';
	}
}