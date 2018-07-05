package org.ba.chat.controller;

import java.util.Optional;

import org.ba.chat.entities.Conversation;
import org.ba.chat.metier.ConversationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversationController {
	
	@Autowired
	public ConversationMetier conversationMetier;
	
	@RequestMapping(value="/addConversation", method=RequestMethod.POST)
	public Conversation addConversation(@RequestBody Conversation c){
		return conversationMetier.addConversation(c);
	}
	
	@RequestMapping(value="/conversation/{num}", method=RequestMethod.GET)
	public Optional<Conversation> getConversation(@PathVariable Integer num){
		return conversationMetier.getConversation(num);
	}

}
