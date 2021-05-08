package com.gxwz.medical.entity;
/*
 * 区域(市)类
 * 
 */
public class City {

    //自增主键
    private Integer id;

    //镇(对应编码)
    private String cityid;

    //(省)对应编码
    private String city;

    //自增主键
    private String father;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father == null ? null : father.trim();
    }

	@Override
	public String toString() {
		return "City [id=" + id + ", cityid=" + cityid + ", city=" + city + ", father=" + father + "]";
	}
    
}