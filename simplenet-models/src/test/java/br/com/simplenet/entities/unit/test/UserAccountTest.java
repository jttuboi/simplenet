package br.com.simplenet.entities.unit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import br.com.simplenet.entities.UserAccount;

public class UserAccountTest {

	private UserAccount userAccount;

	@Before
	public void setUp() {
		userAccount = new UserAccount();
	}

	@Test
	public void validUserTest() {
		userAccount.setName("Jairo");
		userAccount.setEmail("jairo@mail.com");
		userAccount.setPassword("password");

		assertNotNull(userAccount.getName());
		assertNotNull(userAccount.getEmail());
		assertNotNull(userAccount.getPassword());
	}

	@Test
	public void invalidUserTest() {
		userAccount.setEmail(null);
		userAccount.setPassword(null);

		assertNull(userAccount.getEmail());
		assertNull(userAccount.getPassword());
	}
}
