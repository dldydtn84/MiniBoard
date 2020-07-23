package kr.co.ezen.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.ezen.beans.BoardInfoBean;
import kr.co.ezen.beans.UserBean;
import kr.co.ezen.service.TopMenuService;

//상단메뉴는 어떠한 주소를 요청하더라도 다 동작해야 하므로 인터셉터로 구현하면 한번에 처리 가능합니다. 
public class TopMenuInterceptor implements HandlerInterceptor {

	@Autowired
	private TopMenuService topMenuService;	
	private UserBean loginUserBean;
	
	  public TopMenuInterceptor(TopMenuService topMenuService, UserBean loginUserBean) {
	  this.topMenuService = topMenuService; 
	  this.loginUserBean = loginUserBean;
	 }	 				
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
			 List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
			 request.setAttribute("topMenuList", topMenuList);
			 request.setAttribute("loginUserBean", loginUserBean); 
			 
		return true;//다음 단계로 갈 수 있도록 
	}
	
	
}
