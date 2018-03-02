package kr.co.kms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.kms.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService tservice;
	
	@RequestMapping(value = "/doA", method=RequestMethod.GET)
	String doA(Model model) {
		System.out.println("doA 호출");
		String serviceResult = tservice.testService1();
		model.addAttribute("msg", serviceResult);
		return "doA";
	}
	
	@RequestMapping(value = "/doB", method=RequestMethod.GET)
	String doB(Model model) {
		System.out.println("doB 호출");
		String serviceResult = tservice.doBService();
		model.addAttribute("msgg", serviceResult);
		return "doB";
		
	}

}
