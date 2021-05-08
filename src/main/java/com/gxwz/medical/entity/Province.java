package com.gxwz.medical.entity;
/*
 * 区域(省)类
 * 
 */
public class Province {
    private Integer id;

    private String provinceid;

    private String province;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceid=" + provinceid + ", province=" + province + "]";
	}
    
    
}