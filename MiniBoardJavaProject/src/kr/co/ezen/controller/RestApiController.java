package kr.co.ezen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ezen.service.UserService;

@RestController  //html 데이터가 아닌경우를 대비하여 사용하되, 문자열이 아닌 데이터는 json을 사용합니다.
public class RestApiController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/checkUserIdExist/{user_id}") //null 체크
	public String checkUserIdExist(@PathVariable String user_id) {		
		 
		boolean chk = userService.checkUserIdExist(user_id);
		
		return chk + "";
	}
	
	
	
}
