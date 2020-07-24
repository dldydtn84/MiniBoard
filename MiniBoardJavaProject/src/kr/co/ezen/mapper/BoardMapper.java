package kr.co.ezen.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.ezen.beans.ContentBean;

public interface BoardMapper { // Mapper준비 단계

	@Insert("insert into content_table(content_idx, content_subject, content_text, content_file,"
			+ " content_writer_idx, content_board_idx, content_date)"
			+ " values(content_seq.nextval, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean writeContentBean);

	@Select("select board_info_name from board_info_table where board_info_idx= #{board_info_idx}")
	String getBoardInfoName(int board_info_idx);

	@Select("select ct.content_idx, ct.content_subject, ut.user_name as content_writer_name ,to_char(ct.content_date, 'YYYY-MM-DD') as content_date from content_table ct , user_table ut where ct.content_writer_idx = ut.user_idx and ct.content_board_idx = #{board_info_idx} order by ct.content_idx desc")
	List<ContentBean> getContentList(int board_info_idx);

	@Select("select a2.user_name as content_writer_name, " + "to_char(a1.content_date, 'YYYY-MM-DD') as content_date, "
			+ "a1.content_subject, a1. content_text, a1.content_file, a1.content_writer_idx, a1.content_board_idx, a1.content_idx  "
			+ "from content_table a1, user_table a2 " + "where a1.content_writer_idx = a2.user_idx "
			+ "  and a1.content_idx = #{content_idx}")
	ContentBean getContentInfo(int content_idx);

	@Select("select content_idx, content_subject, to_char(content_date, 'YYYY-MM-DD') as content_date from content_table  where  content_board_idx = 4 and rownum<=5 order by content_idx desc")
	List<ContentBean> getMainInfo();

	@Update("update content_table set content_subject = 'ㅋㅋㅋ', content_text='zzz', content_file='' where content_idx=12")
	void updatamodify(ContentBean modifyContentBean);

}
