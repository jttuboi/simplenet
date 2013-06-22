package br.com.simplenet.repository.integration.test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/repositoryContext-test.xml" })
public class PersistenceContextTest {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void entityManagerTest() {
		assertNotNull(entityManager);
	}


	@Test
	public void criteriaTest() {
		assertNotNull(entityManager.getCriteriaBuilder());
	}

}
