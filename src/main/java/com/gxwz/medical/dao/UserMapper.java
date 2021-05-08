package com.gxwz.medical.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxwz.medical.entity.User;

/**
 * 用户数据访问层
 * @author 吴俊杰
 *
 */
public interface UserMapper {
	
	/**
	 * 检查用户名是否重复
	 * @param userid 用户id
	 * @param loginname 登录名
	 * @return
	 */
	List<User> loginnameValidate(@Param("userid") Integer userid, 
			@Param("loginname") String loginname);

	/**
	 * 登录检查
	 * @param loginname 登录名
	 * @param password 密码
	 * @return 符合用户名密码组合的用户记录
	 */
	User loginValidate(@Param("loginname") String loginname, 
			@Param("password") String password);
	
	/**
	 * 按条件模糊查询
	 * @param user
	 * @return
	 */
	List<User> selectByKeyWord(User user);
	
	/**
	 * 按主键更新
	 * @param userid
	 * @return
	 */
	User selectByPrimaryKey(Integer userid);
	
	/**
	 * 动态插入记录
	 * @param record
	 * @return
	 */
    int insertSelective(User record);

    /**
     * 动态更新记录
     * @param record
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(User record);
}