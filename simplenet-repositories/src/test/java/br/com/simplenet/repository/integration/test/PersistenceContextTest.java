package br.com.simplenet.repository.integration.test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.simplenet.entities.UserAccount;

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
	@Transactional(propagation = Propagation.REQUIRED)
	public void persistTest() {
		UserAccount teste = new UserAccount();
		entityManager.persist(teste);
		assertNotNull(teste.getId());
		System.out.println(teste.getId().intValue());
	}

	@Test
	public void criteriaTest() {
		assertNotNull(entityManager.getCriteriaBuilder());
	}

}
