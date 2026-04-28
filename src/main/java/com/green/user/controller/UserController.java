package com.green.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}