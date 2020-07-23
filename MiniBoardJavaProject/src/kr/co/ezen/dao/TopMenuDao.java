package kr.co.ezen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ezen.beans.BoardInfoBean;
import kr.co.ezen.mapper.TopMenuMapper;

//TopMenuMapper 클래스의 getTopMenuList()를 호출하여 쿼리문을 실행하는 역할을 하는 클래스로 코딩함.
@Repository  //어떤 역할를 하는지 명시해주는 부분
public class TopMenuDao {
	
	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = topMenuMapper.getTopMenuList();//1, 2, 3, 4
		
		return topMenuList;
	}
	
	
	
	
}
