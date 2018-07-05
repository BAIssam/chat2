package org.ba.chat.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	
	private String pseudo;
	private String login;
	private String password;
	private String role;
	private int active;
	
	@OneToMany(mappedBy="user")
	private List<Conversation> conversations;
	
	@OneToMany(mappedBy="user")
	private List<Message> messages;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String pseudo, String login, String password, String role, int active, List<Conversation> conversations,
			List<Message> messages) {
		super();
		this.pseudo = pseudo;
		this.login = login;
		this.password = password;
		this.role = role;
		this.conversations = conversations;
		this.messages = messages;
		this.active = active;
	}



	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@JsonIgnore
	public List<Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}
	@JsonIgnore
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	

}
