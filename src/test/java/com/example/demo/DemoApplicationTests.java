package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.issue.Entity;
import com.example.demo.issue.WorkingEntityRepository;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	WorkingEntityRepository repository;

	@Test
	void contextLoads() {
		Date creationDate = new Date();

		Entity entity = new Entity();
		entity.setCreationDate(creationDate);
		Entity expected = repository.save(entity);

		// assertThat(repository.findFirstByCreationDate(creationDate))
		// 		.isEqualTo(expected);
		assertThat(repository.working(creationDate))
				.isEqualTo(expected);
	}

}
