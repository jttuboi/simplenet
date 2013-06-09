package br.com.simplenet.repository.unit.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.simplenet.entities.UserAccount;
import br.com.simplenet.repository.UserAccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/repositoryContext-test.xml" })
public class UserAccountRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveTest() throws Exception {
		UserAccount t = new UserAccount();
		userAccountRepository.save(t);
		assertNotNull(t.getId());
		System.out.println(t.getId());
	}
}
