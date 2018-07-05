package org.ba.chat.controller;

import java.util.List;

import org.ba.chat.entities.Message;
import org.ba.chat.metier.MessageMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	public MessageMetier messageMetier;
	
	@RequestMapping(value="/envoyer", method=RequestMethod.POST)
	public Message envoyerMessage(
			@RequestParam(name="message") String message,
			@RequestParam(name="userId") Integer userId,
			@RequestParam(name="conversationId") Integer conversationId
			){
		return messageMetier.envoyer(message,userId,conversationId);
	}
	
	@RequestMapping(value="/showMessage/{userId}", method=RequestMethod.GET)
	public List<Message> showMessage(@PathVariable Integer userId){
		return messageMetier.getListMessageByUser(userId);
	}
	
}
