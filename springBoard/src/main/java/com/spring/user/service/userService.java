package com.spring.user.service;

import java.util.List;

import com.spring.user.vo.UserVo;

public interface userService {

	public int userInsert(UserVo userVo) throws Exception;

	public int userIdChk(String userId) throws Exception;

}
