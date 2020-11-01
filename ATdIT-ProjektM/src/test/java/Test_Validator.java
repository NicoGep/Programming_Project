import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import connection.User;
import connection.Validator;

public class Test_Validator {
	
	static Validator v;
	
	@BeforeAll
	public static void creation() {
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

}
