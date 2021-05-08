package com.gxwz.medical.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 附件
 * @author 李圣凤
 *
 */
public class Attachment implements Serializable {
	
    /**
	 * 序列化id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 附件id
	 */
	private Integer attachmentid;

	/**
	 * 附件名称
	 */
    private String filename;

    /**
     * 附件大小（以kb为单位）
     */
    private Long filesize;

    /**
     * 上传时间
     */
    private Date uploadtime;

    /**
     * 文件id，上传文件存入JackRabbit之后可以获得（不是外键）
     */
    private String fileid;

    /**
     * 附件类型:0表示正文�? 1表示附件
     */
    private Integer attachtype;

    /**
     * mime类型（用于下载的时�?�指定文件类型）
     */
    private String mimetype;

    /**
     * 附件�?属公文id
     */
    private Integer articleId;
    
    /**
     * 附件�?属公文信�?
     */


	public Integer getAttachmentid() {
		return attachmentid;
	}

	public void setAttachmentid(Integer attachmentid) {
		this.attachmentid = attachmentid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public Integer getAttachtype() {
		return attachtype;
	}

	public void setAttachtype(Integer attachtype) {
		this.attachtype = attachtype;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}


	@Override
	public String toString() {
		return "Attachment [attachmentid=" + attachmentid + ", filename=" + filename + ", filesize=" + filesize
				+ ", uploadtime=" + uploadtime + ", fileid=" + fileid + ", attachtype=" + attachtype + ", mimetype="
				+ mimetype + "]";
	}

	/**
	 * 以附件id作为唯一标示
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachmentid == null) ? 0 : attachmentid.hashCode());
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
		Attachment other = (Attachment) obj;
		if (attachmentid == null) {
			if (other.attachmentid != null)
				return false;
		} else if (!attachmentid.equals(other.attachmentid))
			return false;
		return true;
	}

    
}