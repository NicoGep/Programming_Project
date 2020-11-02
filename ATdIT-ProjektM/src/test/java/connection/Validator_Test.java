package connection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import connection.Groups;
import connection.User;
import connection.Validator;
import master.Window;

public class Validator_Test {
	
	static Validator v;
	
	@BeforeAll
	public static void creation() {
		Window frame = new Window();
		
		Validator.createValidator();
		v = Validator.getValidator();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}
	
	
	@Test
	public void testValidatorRunning() {
		assertTrue(v.isAlive());
	}
	
	@Test
	public void testValidatorDeamon() {
		assertTrue(v.isDaemon());
	}
	
	@Test
	public void testGetUser_Exists() {
		User user = v.getUser("TestBenutzer1");
		assertEquals(user.getName(), "TestBenutzer1");
	}
	
	@Test
	public void testGetUser_NotExists() {
		User user = v.getUser("Testfall");
		assertNull(user);
	}
	
	@Test
	public void testGetGroup_Exists() {
		Groups group = v.getGroup("TestGruppe1");
		assertEquals(group.getGroupName(), "TestGruppe1");
	}

	@Test
	public void testGetGroup_NotExists() {
		Groups group = v.getGroup("Testfall");
		assertNull(group);
	}
	
	@Test
	public void checkPasswordTest_correct() {
		assertTrue(v.checkPassword(v.getUser("TestBenutzer1"), "pass"));
	}
	
	@Test
	public void checkPasswordTest_incorrect() {
		assertFalse(v.checkPassword(v.getUser("TestBenutzer1"), "testfall"));
	}
	
	
	@AfterAll
	public static void terminate() {
		Validator.killValidator();
		v = null;
	}
	
	
	
}