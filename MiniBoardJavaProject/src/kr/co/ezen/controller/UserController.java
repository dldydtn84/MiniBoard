package kr.co.ezen.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ezen.beans.UserBean;
import kr.co.ezen.service.UserService;
import kr.co.ezen.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//로그인을 성공 여부 체크
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	
	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
						@RequestParam(value="fail", defaultValue = "false") boolean fail,
						Model model) {
		model.addAttribute("fail", fail); 
		
		return "user/login";//user/login.jsp
	}
	
	// 로그인에 대한 유효성 검사 
	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/login";
		}
		
		userService.getLoginUserInfo(tempLoginUserBean); 
		
		if(loginUserBean.isUserLogin() == true ) {
			return "user/login_success"; //user/login_success.jsp
		}else {		
			return "user/login_fail"; //user/login_fail.jsp
		}
	}
	
		
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		
		return "user/join";//user/join.jsp
	}
	
	//회원가입에 대한 유효성 검사
	@PostMapping("/join_pro")
	public String join(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		
		if(result.hasErrors()) {
		return "user/join";//user/join.jsp
		}
		
		userService.addUserInfo(joinUserBean); 		
		
		return "user/join_success";//user/join_success.jsp
	}
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUserBean") UserBean modifyUserBean) {
		
		userService.getModifyUserInfo(modifyUserBean);		
		
		return "user/modify";//user/modify.jsp
	}
	
	@PostMapping("/modify_pro")
	public String modify(@Valid @ModelAttribute("modifyUserBean") UserBean modifyUserBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/modify";
		}
		userService.modifyUserInfo(modifyUserBean); 
		
		return "user/modify_success";//modify_success.jsp
	}
	
	
	
	@GetMapping("/logout")
	public String logout() {
		
		loginUserBean.setUserLogin(false);
		
		return "user/logout";//user/logout.jsp
	}
	
	@GetMapping("/not_login")
	public String not_login() {
		
		return "user/not_login";// user/not_login.jsp
	}
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator = new UserValidator();
		binder.addValidators(validator); 
	}
	
	
	
	
}
