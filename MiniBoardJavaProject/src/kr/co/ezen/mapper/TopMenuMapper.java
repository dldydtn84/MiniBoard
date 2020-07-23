package kr.co.ezen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.ezen.beans.BoardInfoBean;

//selecr문을 사용할 때, 데이터를 가져오려면 어떤 컬럼의 값을 bean에 주입할 것인지 결정을 해줘야 하는데, 
//이 역할을 판단하는 클래스가 Mapper 클래스이므로 아래와 같이 코딩합니다. 
public interface TopMenuMapper {

	@Select("select board_info_idx, board_info_name " + 
			"from board_info_table " + 
			"order by board_info_idx")
	List<BoardInfoBean> getTopMenuList();
	
	
	
}

