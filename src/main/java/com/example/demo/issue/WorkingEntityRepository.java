package com.example.demo.issue;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkingEntityRepository
		extends JpaRepository<Entity, Long> {

	// This is still working
	@Query("SELECT E from Entity E where E.creationDate = :creationDate")
	Entity working(@Param("creationDate") Date creationDate);
}
