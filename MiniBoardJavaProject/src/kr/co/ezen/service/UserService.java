package kr.co.ezen.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezen.beans.UserBean;
import kr.co.ezen.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	
	//아이디가 존재하는가? 
	public boolean checkUserIdExist(String user_id){		 
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name == null) {			
			return true;			
		} else {
			return false;
		}
	}
	
	//회원가입에 대한 서비스 
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean); 
	}
	
	//session 저장하기위한 서비스 명시 
	public void getLoginUserInfo(UserBean tempLoginUserBean){
		
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2  != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx()); 
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name()); 
			loginUserBean.setUserLogin(true); 
		}
	}
	
	public void getModifyUserInfo(UserBean modifyUserBean) {
		UserBean tempModfiyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());
		
		modifyUserBean.setUser_id(tempModfiyUserBean.getUser_id()); //login id call
		modifyUserBean.setUser_name(tempModfiyUserBean.getUser_name()); //login name call
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());// idx call		
	}
	
	public void  modifyUserInfo(UserBean modifyUserBean) {
		
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx()); 
		userDao.modifyUserInfo(modifyUserBean); 
	}
	
	
}
