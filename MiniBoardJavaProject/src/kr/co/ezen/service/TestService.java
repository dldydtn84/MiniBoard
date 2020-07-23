package kr.co.ezen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezen.dao.TestDAO;

@Service
public class TestService {

	@Autowired
	private TestDAO dao; //TestDAO dao = new TestDAO(); 
	
	public String testMethod() {
		String str = dao.testDaoMethod();
		return str;
	}	
	
	
	
}
