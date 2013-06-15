package br.com.simplenet.entities.unit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.simplenet.entities.Profile;
import br.com.simplenet.enums.Gender;

public class ProfileTest {

	private Profile profile;
	
	@Before
	public void setUp() {
		profile = new Profile();
	}
	
	@Test
	public void validProfileTest() {
		Calendar birthday = Calendar.getInstance();
		birthday.set(1989, 04, 06);
		
		profile.setId(1L);		
		profile.setBirthday(birthday);
		profile.setAbout("bla bla");
		profile.setGender(Gender.MALE);
		
		assertNotNull(profile.getId());
		assertNotNull(profile.getBirthday());
		assertNotNull(profile.getAbout());
		assertNotNull(profile.getGender());
	}
	
	@Test
	public void InvalidProfileTest() {
		profile.setGender(null);
		
		assertNull(profile.getGender());
	}
}
