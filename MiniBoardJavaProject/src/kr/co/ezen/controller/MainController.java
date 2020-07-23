package kr.co.ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ezen.beans.ContentBean;

@Controller
public class MainController {
	
	@GetMapping("/main")
	public String main() {
		/*
		 * public ContentBean getMainInfo(int board_info_idx) { ContentBean MainBean =
		 * boardDao.getMainInfo(board_info_idx); return MainBean; }
		 */
		return "main";
	}
}
