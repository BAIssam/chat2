package org.ba.chat.dao;

import java.util.List;

import org.ba.chat.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	@Query("SELECT m FROM Message m WHERE m.user.idUser = :x")
	List<Message> getListMessageByUser(@Param("x") Integer idMessage);
}
