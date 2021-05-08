package com.gxwz.medical.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

//系统功能菜单类
public class Function implements Serializable {

	private static final long serialVersionUID = 1L;

	// 自增主键
	private Integer funid;

	// 菜单名称
	@NotNull(message = "功能名称不能为?")
	@NotBlank(message = "功能名称不能为空白！")
	@Length(min = 4, max = 15, message = "功能名称输入长度不合法！")
	private String funname;

	//菜单地址
	@NotBlank(message = "功能URL不能为空白！")
	@Length(max = 100, message = "功能URL输入长度不合法！")
	private String funurl;

	/**
	 * 父功能id（自关联外键?
	 */
	private Integer funpid;

	/**
	 * 父功能信息（数据库不对应表字段，靠级联查询）
	 */
	private Function parentFunction;

	/**
	 * 菜单状态 功能使用状态不合法：0表示禁用,1表示正常
	 */
	@Range(min = 0, max = 1, message = "功能使用状态不合法?")
	private Integer funstate;

	public Integer getFunid() {
		return funid;
	}

	public void setFunid(Integer funid) {
		this.funid = funid;
	}

	public String getFunname() {
		return funname;
	}

	public void setFunname(String funname) {
		this.funname = funname;
	}

	public String getFunurl() {
		return funurl;
	}

	public void setFunurl(String funurl) {
		this.funurl = funurl;
	}

	public Integer getFunpid() {
		return funpid;
	}

	public void setFunpid(Integer funpid) {
		this.funpid = funpid;
	}

	public Function getParentFunction() {
		return parentFunction;
	}

	public void setParentFunction(Function parentFunction) {
		this.parentFunction = parentFunction;
	}

	public Integer getFunstate() {
		return funstate;
	}

	public void setFunstate(Integer funstate) {
		this.funstate = funstate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	@Override
	public String toString() {
		return "Function [funid=" + funid + ", funname=" + funname + ", funurl=" + funurl + ", funpid=" + funpid
				+ ", parentFunction=" + parentFunction + ", funstate=" + funstate + ", getFunid()=" + getFunid()
				+ ", getFunname()=" + getFunname() + ", getFunurl()=" + getFunurl() + ", getFunpid()=" + getFunpid()
				+ ", getParentFunction()=" + getParentFunction() + ", getFunstate()=" + getFunstate() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	/**
	 * 以功能id作为唯一标示
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funid == null) ? 0 : funid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Function other = (Function) obj;
		if (funid == null) {
			if (other.funid != null)
				return false;
		} else if (!funid.equals(other.funid))
			return false;
		return true;
	}

}