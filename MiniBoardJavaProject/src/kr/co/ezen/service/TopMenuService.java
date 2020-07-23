package kr.co.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezen.beans.BoardInfoBean;
import kr.co.ezen.dao.TopMenuDao;


//서비스는 Dao에 있는 메소드(getTopMenuList()) 호출하여 받아온 정보를 가지고 필요한 처리를 해주는 역할 
//여기서는 dao의 메소드를 호출하여 반환합니다. 
@Service
public class TopMenuService {
	
	@Autowired
	private TopMenuDao topMenuDao;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = topMenuDao.getTopMenuList();
		
		return topMenuList;
	}
	
	
}
