package kr.co.ezen.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.ezen.beans.UserBean;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean) target;

		String beanName = errors.getObjectName();

		//가입되어 있는 정보이거나 수정하는 경우에  
		if (beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {  
			if (userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}

			if(beanName.equals("joinUserBean")) {
			if (userBean.isUserIdExist() == false) {
				errors.rejectValue("user_id", "DontCheckUserIdExist");
				}
			}

		}
	}

}
