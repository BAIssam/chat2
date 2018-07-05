package org.ba.chat.metier;

import java.util.Optional;

import org.ba.chat.entities.Conversation;

public interface ConversationMetier {
	Conversation addConversation(Conversation c);
	Optional<Conversation> getConversation(Integer id);
}
