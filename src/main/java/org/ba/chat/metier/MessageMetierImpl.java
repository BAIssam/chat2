package org.ba.chat.metier;

import java.util.Date;
import java.util.List;

import org.ba.chat.dao.ConversationRepository;
import org.ba.chat.dao.MessageRepository;
import org.ba.chat.dao.UserRepository;
import org.ba.chat.entities.Conversation;
import org.ba.chat.entities.Message;
import org.ba.chat.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageMetierImpl implements MessageMetier {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	ConversationRepository conversationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Message envoyer(String message, Integer userId, Integer conversationId) {
		
		Conversation conversation = conversationRepository.getOne(conversationId);
		User user = userRepository.getOne(userId);
		
		Message msg = new Message(message, new Date(), conversation, user);
		return messageRepository.save(msg);
	}

	@Override
	public List<Message> getListMessageByUser(Integer idUser) {

		return messageRepository.getListMessageByUser(idUser);
	}

}
