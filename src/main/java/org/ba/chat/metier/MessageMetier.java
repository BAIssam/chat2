package org.ba.chat.metier;

import java.util.List;

import org.ba.chat.entities.Message;

public interface MessageMetier {
	
	Message envoyer(String message, Integer userId, Integer conversationId);
	List<Message> getListMessageByUser(Integer idUser);

}
