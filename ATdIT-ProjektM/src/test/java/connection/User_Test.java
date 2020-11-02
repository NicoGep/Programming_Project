package connection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exceptions.InputException;
import exceptions.LoginCredentialsException;
import master.Window;

public class User_Test {
	
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
	public void testLogin_correct() throws LoginCredentialsException {
		User usr = v.getUser("TestBenutzer1");
		User.loginUser(usr, "pass");
		assertEquals(User.getLoggedUser(), usr);
	}
	
	@Test
	public void testLogin_incorrect() {
		assertThrows(LoginCredentialsException.class, () -> {
			
			User.loginUser(v.getUser("TestBenutzer1"), "testfall");
			
		});
	}
	
	@Test
	public void testAddUser_success() throws InputException {
		User u = User.addNewUser("Benutzer_Test", "a.b@c.de", "password");
		
		assertEquals(u.getName(), "Benutzer_Test");
		
		u.deleteUser();
	}
	
	@Test
	public void testAddUser_failure() {
		assertThrows(InputException.class, () -> {
			User.addNewUser("TestBenutzer1", "a.b@c.de", "password");
		});
	}
	
	@Test
	public void testIsInGroup_true() {
		User user = Validator.getValidator().getUser("TestBenutzer1");
		Groups group = Validator.getValidator().getGroup("TestGruppe1");
		assertTrue(user.isInGroup(group));
	}
	
	@Test
	public void testIsInGroup_false() {
		User user = Validator.getValidator().getUser("TestBenutzer1");
		Groups group = Validator.getValidator().getGroup("TestGruppe2");
		assertFalse(user.isInGroup(group));
	}
	
	@Test
	public void testAddToGroup_success() throws InputException {
		User user = Validator.getValidator().getUser("TestBenutzer1");
		Groups group = Validator.getValidator().getGroup("TestGruppe3");
		
		user.addToGroup(group);
		
		assertTrue(user.isInGroup(group));
		
		user.removeFromGroup(group);
		
	}
	
	@Test
	public void testAddToGroup_failure() {
		User user = Validator.getValidator().getUser("TestBenutzer1");
		Groups group = Validator.getValidator().getGroup("TestGruppe1");
		
		assertThrows(InputException.class, () -> {
			user.addToGroup(group);
		});
		
	}
	
	@Test
	public void testChangePassword() {
		User user = Validator.getValidator().getUser("TestBenutzer1");
		
		user.changePassword("testPassword");
		
		assertTrue(v.checkPassword(user, "testPassword"));
		
		user.changePassword("pass");
	}
	
	@AfterAll
	public static void terminate() {
		Validator.killValidator();
		v = null;
	}
	
	
}
