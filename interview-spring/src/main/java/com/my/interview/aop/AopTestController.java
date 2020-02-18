package com.my.interview.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopTestController {
	
	@GetMapping
	@AopTestAnnotation//标注切入点
	public String aop1() {
		return "aop1";
	}

}
