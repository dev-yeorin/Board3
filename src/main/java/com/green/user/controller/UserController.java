package com.green.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.user.dto.UserDto;
import com.green.user.mapper.UserMapper;

@Controller
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private  UserMapper  userMapper;
	
	// /Users/WriteForm() 
	@RequestMapping("/WriteForm")
	public  ModelAndView  writeForm() {

		ModelAndView  mv  =  new ModelAndView();
		mv.setViewName("users/write");
		mv.addObject("msg", "여린");
		
		return  mv;

	}
	
	// /Users/Write?userid=&passwd=&username=&email=
	@RequestMapping("/Write")
	public  ModelAndView  write( UserDto  userDto  ) {
		System.out.println( "UserController write() userDto:" + userDto );
		
		// 넘어온 data 로 db 에 저장
		userMapper.insertUser( userDto  );
		
		ModelAndView  mv  =  new ModelAndView();
		mv.setViewName("redirect:/Users/List");		
		return  mv;		
	}
	
	// /Users/List
	@RequestMapping("/List")
	public  ModelAndView  list() {
		
		// db 에서 사용자 목록을 조회
		List<UserDto> userList = userMapper.getUserList();
		
		ModelAndView  mv  =  new ModelAndView();
		mv.setViewName("users/list");
		mv.addObject("userList", userList);
		
		return mv;
	}
	
	// http://localhost:8080/Users/Delete?userid=SKY
	@RequestMapping("/Delete")
	public ModelAndView Delete( UserDto  userDto  ) {
		
		// 넘겨받은 자료를 출력
		System.out.println( "userDto2:" + userDto );
		
		// db의 자료를 삭제
		userMapper.deleteUser( userDto );
		
		// 목록으로 이동
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Users/List");

		return mv;
		
		
	}
	
	// http://localhost:8080/Users/UpdateForm?userid=sea
	@RequestMapping("/UpdateForm")
	public ModelAndView updateForm( UserDto userDto ) {
		// 넘어온 정보
		System.out.println("userDto: " + userDto);
		
		// 수정을 위해 db에서 조회한 정보
		UserDto user = userMapper.getUser( userDto );
		System.out.println("조회된 userDto: " + user);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/update");
		mv.addObject("user", user);
		
		return mv;
	}
	
	@RequestMapping("/Update")
	public ModelAndView update( UserDto userDto) {
		
		userMapper.updateUser( userDto );
		
		// 목록으로 이동
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Users/List");

		return mv;
	}
	
	
	// 아이디 중복확인 - 결과 문자열을 리턴
	// 사용 가능한 아이디
	@GetMapping("/IdDupcheck2")
	@ResponseBody					// return 퇴는 글자는 jsp가 아님
	public UserDto idDupcheck2(UserDto userDto) {
		
		
		UserDto user = userMapper.getIdDupCheck(userDto);  // 조회한 userid
		
		if(user == null)
			user = new UserDto();

		return user;
	}
	
	// /Users/DupCheckWindow
	@GetMapping("/DupCheckWindow")
	public ModelAndView dupCheckWindow() {
		

		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/idcheck");
		mv.addObject("userid", "aaa");
		return mv;
	}
	
	// 중복확인
	// /Users/DupCheckuserid
	@RequestMapping("DupCheck")
	public ModelAndView dupCheck(UserDto userDto) {
		
		UserDto user    = userMapper.getUser( userDto );
		String  msg     = "<b class='red> 사용할 수 없는 아이디입니다</b>";
		if(user == null)
				msg		= "<b class='red> 사용 가능한 아이디입니다</b>";
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/idcheck");
		mv.addObject("msg", msg);

		
		return mv;
	}
}