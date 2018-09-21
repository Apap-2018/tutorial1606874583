package com.example.demo.controller;

import java.util.Optional;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/generator")
	public String ViralGenerator(@RequestParam(value = "a") Optional<String> a,@RequestParam(value = "b") Optional<String> b ,String result, Model model) {
		
		
		
		int aInt=0;
		int bInt=0;
		String preResult = "hm";
		result = "";
		
		if (String.valueOf(a.get()).chars().allMatch( Character::isDigit )) {
			aInt = Integer.valueOf(a.get());;
		}
		
		if (String.valueOf(b.get()).chars().allMatch( Character::isDigit )) {
			bInt = Integer.valueOf(b.get());
		}
		
		
		
		if(aInt>1) {
			for (int i = 1; i<aInt; i++) {
				preResult += "m";
			}
		}
		
		if(bInt>1) {
			for (int i = 0; i<bInt; i++) {
				result += " "+preResult;
			}
		}else result=preResult;
		
		
		model.addAttribute("a",String.valueOf(aInt));
		model.addAttribute("b",String.valueOf(bInt));
		model.addAttribute("result",result);
		
		return "generator";
	}
	
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
//	@RequestMapping("/challenge")
//	public String challenge(@RequestParam(value = "name") String name, Model model) {
//		model.addAttribute("name",name);
//		return "challenge";
//	}
	
	@RequestMapping({"/challenge","/challenge/{name}"})
	public String challangePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name",name.get());

		}else {
			model.addAttribute("name","KB");

		}
		return "challenge";
	}
}
