package com.gxwz.medical.dto;

import java.io.Serializable;

/**
 * 树的状态
 * @author 吴俊杰
 *
 */
public class State implements Serializable {
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 5556273520036525736L;
	
	/**
	 * 树的节点是否被选中
	 */
	private boolean checked;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
