package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Attachment;

/**
 * 附件Mapper
 * @author 王凯
 *
 */
public interface AttachmentMapper {
	
	/**
	 * 按主键删�?
	 * @param attachmentid
	 * @return
	 */
    int deleteByPrimaryKey(Integer attachmentid);

    /**
     * 按主键插�?
     * @param record 待插入记�?
     * @return
     */
    int insertSelective(Attachment record);

    /**
     * 级联模糊查询
     * @param attachment 模糊查询条件
     * @return
     */
    List<Attachment> selectByKeyword(Attachment attachment);
}