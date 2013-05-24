package br.com.simplenet.repository.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.simplenet.entities.UserAccount;
import br.com.simplenet.repository.UserAccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "**/resources/repository-context-test.xml" })
public class UserAccountRepositoryImplTest extends
		AbstractJUnit4SpringContextTests {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveTest() throws Exception {
		UserAccount userAccount = new UserAccount();
		userAccount.setName("kkkk");
		userAccountRepository.save(userAccount);
		assertNotNull(userAccount.getId());
	}

}
