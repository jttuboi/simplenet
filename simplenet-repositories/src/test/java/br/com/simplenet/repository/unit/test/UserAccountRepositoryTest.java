package br.com.simplenet.repository.unit.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
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
	
	private UserAccount userAccount;
	
	@Before
	public void setUp() {
		userAccount = new UserAccount();
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveTest() throws Exception {
		userAccount.setName("Jairo");
		userAccount.setName("jttuboi@mail.com");
		userAccount.setName("password");
		userAccountRepository.save(userAccount);
		
		assertNotNull(userAccount.getId());
		System.out.println(userAccount.getId());
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveNameTest() throws Exception {
		userAccount.setName("Jairo");
		userAccountRepository.save(userAccount);
		
		assertNotNull(userAccount.getName());
		System.out.println(userAccount.getName());
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveEmailTest() throws Exception {
		userAccount.setEmail("jttuboi@mail.com");
		userAccountRepository.save(userAccount);
		
		assertNotNull(userAccount.getEmail());
		System.out.println(userAccount.getEmail());
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void savePasswordTest() throws Exception {
		userAccount.setPassword("password");
		userAccountRepository.save(userAccount);
		
		assertNotNull(userAccount.getPassword());
		System.out.println(userAccount.getPassword());
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTest() throws Exception {
		userAccountRepository.save(userAccount);
		
		userAccountRepository.delete(Long.valueOf(1));
		
		assertNull(userAccountRepository.findBy(Long.valueOf(1)));
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTest() throws Exception {
		userAccount.setName("Jorge");
		userAccount.setEmail("jorge@mail.com");
		userAccount.setPassword("senha");
		userAccountRepository.update(userAccount);
		
		assertEquals("Jorge", userAccount.getName());
		assertEquals("jorge@mail.com", userAccount.getEmail());
		assertEquals("senha", userAccount.getPassword());
		System.out.println(userAccount.getName());
		System.out.println(userAccount.getEmail());
		System.out.println(userAccount.getPassword());
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateNameTest() throws Exception {
		userAccount.setName("Jorge");
		userAccountRepository.update(userAccount);
		
		assertEquals("Jorge", userAccount.getName());
		System.out.println(userAccount.getName());
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateEmailTest() throws Exception {
		userAccount.setEmail("jorge@mail.com");
		userAccountRepository.update(userAccount);
		
		assertEquals("jorge@mail.com", userAccount.getEmail());
		System.out.println(userAccount.getEmail());
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void updatePasswordTest() throws Exception {
		userAccount.setPassword("senha");
		userAccountRepository.update(userAccount);
		
		assertEquals("senha", userAccount.getPassword());
		System.out.println(userAccount.getPassword());
	}
}
