package kr.co.ezen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ezen.beans.ContentBean;
import kr.co.ezen.mapper.BoardMapper;

@Repository 
public class BoardDao {

	@Autowired
	private BoardMapper boardMapper;
	
	
	public void addContentInfo(ContentBean writeContentBean) {
		System.out.println("되나요?");
		boardMapper.addContentInfo(writeContentBean);

		
	}
	
	public String getBoardInfoName(int board_info_idx) {
		
		return boardMapper.getBoardInfoName(board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx){
		List<ContentBean> boardresult = boardMapper.getContentList(board_info_idx);
		return boardresult;
		
	}
	
	public ContentBean getContentInfoBean(int content_idx) {
	ContentBean contentBean = boardMapper.getContentInfoBean(content_idx);
		
	return contentBean;
	}
	
	public List<ContentBean> getMainInfo(int board_info_idx) {
		List<ContentBean> MainminiBean = boardMapper.getMainInfo(board_info_idx);
		return MainminiBean;
	} 

	
}
