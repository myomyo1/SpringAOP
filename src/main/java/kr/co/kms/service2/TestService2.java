package kr.co.kms.service2;

import org.springframework.stereotype.Service;

@Service
public class TestService2 {
	
	public void myCFoo() {
		System.out.println("myCFoo 호출함 - joinPoint");
	}
	
	public void doDGoo() {
		System.out.println("doDGoo 호출함 - joinPoint");
	}

}
