package kr.co.ezen.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ezen.beans.ContentBean;
import kr.co.ezen.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,
						Model model) {
		model.addAttribute("board_info_idx", board_info_idx); 
		
		String boardInfoName = boardService.getBoardInfoName(board_info_idx);
		model.addAttribute("boardInfoName",boardInfoName);
		List<ContentBean> boardresult = boardService.getContentList(board_info_idx);
		
		model.addAttribute("boardresult",boardresult);
		
		
		return "board/main";//board/main.jsp
	}
	
	@GetMapping("/read")
	public String read(@RequestParam("content_idx") int content_idx,
			Model model) {		
	
		   ContentBean contentBean = boardService.getContentInfoBean(content_idx);
		  model.addAttribute("contentBean",contentBean);

		
		return "board/read";//board/read.jsp
	}
	
	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentBean") ContentBean writeContentBean, @RequestParam("board_info_idx") int board_info_idx) {		
		writeContentBean.setContent_board_idx(board_info_idx);
		return "board/write";//board/write.jsp
	}
	
	@PostMapping("/write_pro")
	public String write(@Valid @ModelAttribute("writeContentBean") ContentBean writeContentBean, BindingResult result) throws IllegalStateException, IOException {
		
		if(result.hasErrors()) {
			
			return "board/write";//board/write.jsp
		}else {
		System.out.println("...안돼");
		boardService.addContentInfo(writeContentBean);
		return "board/write_success";//board/write_success.jsp
	}
	}
	
	
	@GetMapping("/modify")
	public String modify() {		
		return "board/modify";//board/modify.jsp
	}
	

	@GetMapping("/delete")
	public String delete() {		
		return "board/delete";//board/delete.jsp
	}
	
	
}
