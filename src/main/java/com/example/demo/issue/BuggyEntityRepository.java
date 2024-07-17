package com.example.demo.issue;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuggyEntityRepository
		extends JpaRepository<Entity, Long> {

	Entity findFirstByCreationDate(Date creationDate);
}
