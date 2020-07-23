package kr.co.ezen.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ezen.beans.ContentBean;

@Controller
public class MainController {
	
	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,
			Model model) {
		
		/*
		 * public List<ContentBean> getMainInfo(int board_info_idx) { List<ContentBean>
		 * MainminiBean = boardDao.getMainInfo(board_info_idx); return MainminiBean; }
		 */
		/*List<ContentBean> boardresult = boardService.getContentList(board_info_idx);
		
		model.addAttribute("boardresult",boardresult);*/
		
		
		
		return "main";
	}
}

	
	
	