package kr.co.ezen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.ezen.beans.ContentBean;
import kr.co.ezen.beans.UserBean;
import kr.co.ezen.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{

	private UserBean loginUserBean;
	
	private BoardService boardService;
	
	public CheckWriterInterceptor(UserBean loginUserBean, BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardService = boardService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String str1 = request.getParameter("content_idx");
		int content_idx = Integer.parseInt(str1);
		
		ContentBean currentContentBean = boardService.getContentInfo(content_idx);
		
		if(loginUserBean.getUser_idx()!= currentContentBean.getContent_writer_idx()) {
			String contextPath = request.getContextPath();
			System.out.println("노롸이트");
			response.sendRedirect(contextPath + "/board/not_writer");
			return false;
		}
		System.out.println("인롸이트");
		return true;
	}
}
