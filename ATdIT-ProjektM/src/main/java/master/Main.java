package master;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import connection.Validator;
import exceptions.InputException;

/** Main-Klasse: main-Methode starten, um die Applikation zu starten
 * 
 * @author I518230
 *
 */
public class Main {
	
	/**	main-Methode
	 * 
	 * @param args : String[] (args-Array)
	 * @throws InterruptedException 
	 * @throws InputException 
	 */
	public static void main(String[] args) {
		
		Window frame = new Window();
//		Window.reset();
		Window.showDisconnectScreen(1);
		
		Validator.createValidator();
		
		frame.setVisible(true);
	
		
	}
	
	
	static File errorLogFile = new File("./logs/Error_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_kk-mm-ss")) + ".log");
	static boolean logCreated = false;
	
	public static void printError(Exception e) {
		Main.printError(e, "");
	}
	
	public static void printError(Exception e, String message) {
		
		try {
		
			if(Main.logCreated == false) {
				Main.errorLogFile.createNewFile();
				Main.logCreated = true;
			}
		
			FileWriter fileWriter = new FileWriter(Main.errorLogFile, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		
			printWriter.print(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_kk-mm-ss.S")) + " -- ");
			printWriter.println(e.getClass() + "\n" + (message.isBlank() ? "" : (message + "\n")));
			e.printStackTrace(printWriter);
			printWriter.println("\n\n");
			fileWriter.flush();
		
		} catch(IOException ioE) {
			System.out.println("Error occured whilst printing error log.\n\n");
			ioE.printStackTrace();
		}
		
	}

	
	
	
	//########################### Zugriff von mehreren Ger�ten ##########################
	
}
