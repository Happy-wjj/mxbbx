package com.gxwz.medical.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author 吴俊杰
 *
 */
@JsonInclude(Include.NON_NULL)
public class TreeDto implements Serializable {
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -738769624230897381L;

	/**
	 * 节点显示的文本
	 */
	private String text;
	
	/**
	 * 子节
	 */
	private List<TreeDto> nodes;
	
	/**
	 * 节点的id，也就是用户id
	 */
	private Integer id;
	
	/**
	 * 控制节点是否被选中
	 */
	private State state;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TreeDto> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeDto> nodes) {
		this.nodes = nodes;
	}
	
	public void addNode(TreeDto treeDto) {
		if (nodes == null) {
			nodes = new ArrayList();
		}
		nodes.add(treeDto);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "TreeDto [text=" + text + ", nodes=" + nodes + ", id=" + id + ", state=" + state + "]";
	}
}
