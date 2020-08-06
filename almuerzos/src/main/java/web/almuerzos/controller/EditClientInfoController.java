package web.almuerzos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.almuerzos.ClientsApi.ClientsApi;

@Controller
public class EditClientInfoController {

	@Autowired
	ClientsApi clientsApi;

	@RequestMapping(value="/clientinfo", method=RequestMethod.GET)
	public String showClientInfoPage() {
		return "clientInfoEdit";
	}
	
	@RequestMapping(value="/clientinfo", method=RequestMethod.POST)
	public String clientInfoEdit(@RequestParam(required=false) String fullName, @RequestParam(required=false) String password,
												  @RequestParam(required=false) String phone) {
		String  response = clientsApi.clientInfoEdit(fullName,  password,  phone);
		return "clientInfoEdit";	}
}
