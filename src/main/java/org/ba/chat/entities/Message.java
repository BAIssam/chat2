package org.ba.chat.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Entity
public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMessage;
	
	private String message;
	private Date dateMessage;
	
	@ManyToOne
	@JoinColumn(name="FK_conversationId")
	private Conversation conversation;
	
	@ManyToOne
	@JoinColumn(name="FK_userId")
	private User user;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Message(String message, Date dateMessage, Conversation conversation, User user) {
		super();
		this.message = message;
		this.dateMessage = dateMessage;
		this.conversation = conversation;
		this.user = user;
	}

	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
