package connection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import exceptions.InputException;
import master.Window;

public class Group_Test {
	
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
	public void testAddNewGroup_success() throws InputException {
		Groups group = Groups.addNewGroup("Test_Gruppe");
		
		assertEquals(group.getGroupName(), "Test_Gruppe");
		
		group.deleteGroup();
	}
	
	@Test
	public void testAddNewGroup_failure() {
		
		assertThrows(InputException.class, () -> {
			Groups.addNewGroup("TestGruppe1");
		});
		
	}
	
	@AfterAll
	public static void terminate() {
		Validator.killValidator();
		v = null;
	}

}
