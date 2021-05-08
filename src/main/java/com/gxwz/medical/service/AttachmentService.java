package com.gxwz.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxwz.medical.dao.AttachmentMapper;
import com.gxwz.medical.entity.Attachment;

/**
 * 附件业务逻辑
 * @author 李圣�?
 *
 */
@Service
public class AttachmentService {
	
	/**
	 * 附件Mapper
	 */
	@Autowired
	private AttachmentMapper attachmentMapper;
	
	/**
	 * 删除附件
	 * @param attachmenId
	 * @return
	 */
	public boolean deleteAttachment(Integer attachmenId) {
		
		return attachmentMapper.deleteByPrimaryKey(attachmenId) > 0;
	}
	
	/**
	 * 添加�?个附�?
	 * @param attachment
	 * @return
	 */
	public boolean addAttachment(Attachment attachment) {
		
		return attachmentMapper.insertSelective(attachment) > 0;
	}
	
	/**
	 * 模糊查询
	 * @param attachment
	 * @return
	 */
	public List<Attachment> findByKeyword(Attachment attachment) {
		
		return attachmentMapper.selectByKeyword(attachment);
	}

}
