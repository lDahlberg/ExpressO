package lukedahlbergfinal.lukedahlbergfinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The following methods maps the home page value
 * @author ldahlberg
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(){
		
		return "employee-create.html";
		
	}
}

