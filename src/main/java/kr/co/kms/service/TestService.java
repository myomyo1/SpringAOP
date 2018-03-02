package kr.co.kms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kms.dao.TestDao;

@Service
public class TestService {

	@Autowired
	TestDao tdao;
	
	//실제 사용자가 호출하려고 했던 joinpoint가 된다. aop를 사용함에 따라 프록시에 의해 대신 호출된다(proceed()호출시 testServiceOne이 실행된다는 뜻)
	public String testService1() {
		System.out.println("Service 실행  - joinpoint");
		return "Hello";
	}
	
	public String doBService() {
		System.out.println("Service 실행 - joinpoint");
		return "Hi";
	}
}
