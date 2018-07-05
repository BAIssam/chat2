package org.ba.chat.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
	
	/*@RequestMapping(value="/login")
	public String login(){		
		return "login";
	}*/
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false) String error,
			@RequestParam(name="logout", required = false) String logout){
		
		ModelAndView mv = new ModelAndView("login");
		
		if(error != null){
			mv.addObject("message", "Nom d&acute;utilisateur et mot de passe sont invalides!");
		}
		
		if(logout != null){
			mv.addObject("logout", "L&acute;utilisateur s&acute;est d&eacute;connect&eacute; avec succ&egrave;s!");
		}
		
		mv.addObject("title", "Login");
		
		return mv;
		
	}
}
