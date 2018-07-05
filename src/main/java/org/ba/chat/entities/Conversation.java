package org.ba.chat.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conversation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConversatioin;
	
	private String sujet;
	
	@ManyToOne
	@JoinColumn(name="FK_userId")
	private User user;
	
	@OneToMany(mappedBy="conversation")
	private List<Message> messages;

	public Conversation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conversation(String sujet, User user, List<Message> messages) {
		super();
		this.sujet = sujet;
		this.user = user;
		this.messages = messages;
	}

	public Integer getIdConversatioin() {
		return idConversatioin;
	}

	public void setIdConversatioin(Integer idConversatioin) {
		this.idConversatioin = idConversatioin;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	

}
