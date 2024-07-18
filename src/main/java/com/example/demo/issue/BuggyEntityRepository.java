package com.example.demo.issue;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BuggyEntityRepository
		extends JpaRepository<Entity, Long> {

	
	// this was working
	Entity findFirstByCreationDate(Date creationDate);
}
