package kr.co.ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ezen.beans.ContentBean;
import kr.co.ezen.service.BoardService;

@Controller
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/main")
	public String main(Model model) {
		
		/*
		 * public List<ContentBean> getMainInfo(int board_info_idx) { List<ContentBean>
		 * MainminiBean = boardDao.getMainInfo(board_info_idx); return MainminiBean; }
		 */
		
		
		
		 List<ContentBean> MainminiBean = boardService.getMainInfo();
		 
		 model.addAttribute("MainminiBean",MainminiBean);
	
		
		
		return "main";
	}
}

	
	
	