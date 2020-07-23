package kr.co.ezen.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.ezen.beans.UserBean;

public interface UserMapper {

	@Select("select user_name " + 
			"from user_table " + 
			"where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	
	@Insert("insert into user_table (user_idx, user_name, user_id, user_pw) " +
			"values(user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean joinUserBean);
	
	//Session Area에 저장하기 위한 준비 작업
	@Select("select user_idx, user_name " + 
			"from user_table " + 
			"where user_id = #{user_id} and user_pw = #{user_pw}")
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);
	
	//로그인 정보 확인
	@Select("select user_id, user_name " + 
			"from user_table " + 
			"where user_idx = #{user_idx}")
	UserBean getModifyUserInfo(Integer user_idx);
	
	//비밀번호 수정
	@Update("update user_table set user_pw = #{user_pw} " +
			"where user_idx = #{user_idx}")
	void modifyUserInfo(UserBean modifyUserBean);
	
	
	
	
}

