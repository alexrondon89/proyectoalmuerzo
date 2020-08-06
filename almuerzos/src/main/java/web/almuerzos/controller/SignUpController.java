package web.almuerzos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.almuerzos.ClientsApi.ClientsApi;

@Controller
public class SignUpController {

	@Autowired
	ClientsApi clientsApi;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String showSignUpPage() {
		return "signUp";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signUp(@RequestParam String fullName, @RequestParam String email, @RequestParam String password, @RequestParam String phone) {
		String  response = clientsApi.signUp(fullName,  email,  password,  phone);
		return "redirect:/signup";
	}

	
	
}
