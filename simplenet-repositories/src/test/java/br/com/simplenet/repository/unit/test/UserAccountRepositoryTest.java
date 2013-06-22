package br.com.simplenet.repository.unit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.simplenet.entities.Profile;
import br.com.simplenet.entities.UserAccount;
import br.com.simplenet.enums.Gender;
import br.com.simplenet.repository.UserAccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/repositoryContext-test.xml" })
public class UserAccountRepositoryTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserAccountRepository userAccountRepository;

	private UserAccount userAccount;
	private Calendar birthday;
	private Profile profile;

	@Before
	public void setUp() {
		userAccount = new UserAccount();
		userAccount.setName("Jairo");
		userAccount.setEmail("jttuboi@mail.com");
		userAccount.setPassword("password");

		birthday = Calendar.getInstance();
		birthday.set(1989, 04, 06);

		profile = new Profile();
		profile.setBirthday(birthday);
		profile.setAbout("bla");
		profile.setGender(Gender.MALE);
	}

	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveTest() throws Exception {
		userAccount = (UserAccount) userAccountRepository.save(userAccount);
		assertNotNull(userAccount.getId());
	}

	@Test
	public void findByTest() throws Exception {
		userAccount = userAccountRepository.save(userAccount);
		UserAccount  user = userAccountRepository.findBy(userAccount.getId());
		assertNotNull(user);
	}

	@Test
	public void findAllTest() throws Exception {
		UserAccount newUser = new UserAccount();
		newUser.setName("John");
		newUser.setEmail("john@mail.com");
		newUser.setPassword("password2");

		userAccountRepository.save(newUser);
		List<UserAccount> userAccounts = userAccountRepository.findAll();

		assertTrue(userAccounts.size() > 0);
	}

	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTest() throws Exception {

		UserAccount user = userAccountRepository.save(userAccount);
		
		userAccount = userAccountRepository.findBy(user.getId());
				
		userAccount.setName("Jorge");
		userAccount.setEmail("jorge@mail.com");
		userAccount.setPassword("senha");

		UserAccount updatedUser = userAccountRepository.update(userAccount);

		assertEquals("Jorge", updatedUser.getName());
		assertEquals("jorge@mail.com", updatedUser.getEmail());
		assertEquals("senha", updatedUser.getPassword());
	}

	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTest() throws Exception {
		UserAccount user = userAccountRepository.save(userAccount);
		assertTrue(userAccountRepository.delete(user));
	}

	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	@ExpectedException(Exception.class)
	public void deleteExceptionTest() throws Exception {
		boolean deleted = userAccountRepository.delete(null);
		assertTrue(deleted);
	}
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveProfileTest() throws Exception {
		userAccount.setProfile(profile);
		UserAccount returnedUserAccount = userAccountRepository.save(userAccount);		
		assertNotNull(returnedUserAccount.getProfile());
	}
}
