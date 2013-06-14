package br.com.simplenet.entities.unit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.simplenet.entities.Profile;
import br.com.simplenet.entities.UserAccount;
import br.com.simplenet.enums.Gender;

public class UserAccountTest {

	private UserAccount userAccount;
	private Profile profile;
	
	@Before
	public void setUp() {
		userAccount = new UserAccount();
		profile = new Profile();
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
	
	@Test
	public void hasProfileTest() {
		Calendar birthday = Calendar.getInstance();
		birthday.set(1989, 04, 06);
		
		profile.setBirthday(birthday);
		profile.setAbout("bla");
		profile.setGender(Gender.MALE);
		
		userAccount.setProfile(profile);
		
		assertEquals(birthday, userAccount.getProfile().getBirthday());
		assertEquals("bla", userAccount.getProfile().getAbout());
		assertEquals(Gender.MALE, userAccount.getProfile().getGender());
	}
	
	@Test
	public void hasInvalidProfileTest() {
		profile.setGender(null);
		
		userAccount.setProfile(profile);
		
		assertNull(userAccount.getProfile().getGender());
	}
}
