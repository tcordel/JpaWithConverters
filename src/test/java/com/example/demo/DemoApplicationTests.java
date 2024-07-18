package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.issue.Entity;
import com.example.demo.issue.WorkingEntityRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	WorkingEntityRepository repository;

	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
		Date creationDate = new Date();

		Entity entity = new Entity();
		entity.setCreationDate(creationDate);
		Entity expected = repository.save(entity);

		// assertThat(repository.findFirstByCreationDate(creationDate))
		// .isEqualTo(expected);
		assertThat(repository.working(creationDate))
				.isEqualTo(expected);

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(Entity.class);
		Root<Entity> root = criteriaQuery.from(Entity.class);
		ParameterExpression<Date> createDateParameter = criteriaBuilder.parameter(Date.class);
		TypedQuery<Entity> query = entityManager
				.createQuery(criteriaQuery.where(criteriaBuilder.equal(root.get("creationDate"), createDateParameter)));
		query.setParameter(createDateParameter, creationDate);
		assertThat(query.getResultList().get(0)).isEqualTo(expected);
	}

}
