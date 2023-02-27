package com.spring.user.controller;

import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.HomeController;
import com.spring.common.CommonUtil;
import com.spring.user.service.userService;
import com.spring.user.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired 
	userService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/user/userJoin.do", method = RequestMethod.GET)
	public String userJoin(Locale locale, Model model) throws Exception{
		
		System.out.println("회원가입 페이지입니다.");
		
		return "user/userJoin";
	}
	
	@RequestMapping(value = "/user/userJoinAction.do", method = RequestMethod.POST)
	@ResponseBody
	public String userJoinAction(Locale locale, UserVo userdVo) throws Exception{
		
		HashMap<String, String> rslt = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		
		int rsltCnt = userService.userInsert(userdVo);
		
		rslt.put("success", (rsltCnt > 0) ? "Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ", rslt);
		
		System.out.println("callbackMsg :: " + callbackMsg);
		
		return callbackMsg;
	}
	
	@RequestMapping(value = "/user/userIdChk.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean userIdChk(String userId) throws Exception{
		
		boolean status = true;
		int checkNum = userService.userIdChk(userId);
		System.out.println(checkNum);
		
		if(checkNum == 1) {
			System.out.println("중복된 아이디 입니다.");
			status =  false;
		}else {
			System.out.println("사용가능한 아이디 입니다.");
			status =  true;
		}
		return status;
	}
}
