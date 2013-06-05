package br.com.simplenet.unit;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.simplenet.entities.UserAccount;
import br.com.simplenet.repository.UserAccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/repository-context-test.xml")
public class UserAccountRepositoryTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Test
	public void saveTest() throws Exception {

		UserAccount userAccount = new UserAccount();
		assertNotNull(userAccountRepository.save(userAccount));

	}

}
