package org.ba.chat.metier;

import java.util.Optional;

import org.ba.chat.dao.ConversationRepository;
import org.ba.chat.entities.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationMetierImpl implements ConversationMetier {

	@Autowired
	ConversationRepository conversationRepository;
	
	@Override
	public Conversation addConversation(Conversation c) {
		
		return conversationRepository.save(c);
	}

	@Override
	public Optional<Conversation> getConversation(Integer id) {
		
		return conversationRepository.findById(id);
	}

}
