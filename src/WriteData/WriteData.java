import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteData {
	
	private FileWriter fw;
	private BufferedWriter br;
	
	public WriteData() {
		
		
		try {
			fw = new FileWriter("ExampleOutput.csv");
		} catch(Exception e) {
			System.out.println("Error occured: " + e.toString());
		}
	}
	
	public WriteData(String File) {
		
		
		try {
			fw = new FileWriter(File);
		} catch(Exception e) {
			System.out.println("Error occured: " + e.toString());
		}
	}
	/**
	 * Writes a string to file
	 * @param userInput
	 * @throws IOException
	 */
	public void outputSingleLine(String userInput) throws IOException {
		br = new BufferedWriter(fw);
		try {
			br.write(userInput);
		} catch (Exception e) {
			System.out.println("Write out Error: " + e.toString());
		}
		br.flush();
		
	}
	/**
	 * Writes a list of random Integers [0-1000] to a file
	 * @throws IOException
	 */
	public void outputRandomNums() throws IOException {
		Random rand = new Random();
		
		for(int i = 0; i < 1000; i++) {
			String line = ""; 
			line = line + i + "," + rand.nextInt(1001);
			outputSingleLine(line + "\n");

		}
	}
	
}
