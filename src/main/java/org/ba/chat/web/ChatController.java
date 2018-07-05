package org.ba.chat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	
	@RequestMapping(value={"/","/chat"})
	public String index(){
		
		//ModelAndView mv = new ModelAndView("chat");
		
		return "chat";
	}

}
