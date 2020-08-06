package web.almuerzos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.almuerzos.ClientsApi.ClientsApi;

@Controller
public class SignInController {

	@Autowired
	ClientsApi clientsApi;
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public  String showSignInPage() {
		return "signIn";
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public  String signIn(@RequestParam String email, @RequestParam String password) {
		String response = clientsApi.signIn(email, password);
		return "signIn";
	}
}