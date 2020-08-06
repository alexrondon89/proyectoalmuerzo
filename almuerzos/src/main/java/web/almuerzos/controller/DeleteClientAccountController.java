package web.almuerzos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.almuerzos.ClientsApi.ClientsApi;

@Controller
public class DeleteClientAccountController {

	@Autowired
	ClientsApi clientsApi;

	@RequestMapping(value="/delete-account", method=RequestMethod.GET)
	public String showClientInfoPage() {
		return "deleteAccount";
	}
	
	@RequestMapping(value="/delete-account", method=RequestMethod.POST)
	public String clientInfoEdit(@RequestParam String email, @RequestParam String password) {
		String  response = clientsApi.deleteAccount(email, password);
		return "redirect:/signup";	}
}