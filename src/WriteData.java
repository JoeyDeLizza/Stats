import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
	
	public void outputSingleLine(String userInput) throws IOException {
		br = new BufferedWriter(fw);
		try {
			br.write(userInput);
			System.out.println("write");
		} catch (Exception e) {
			System.out.println("Write out Error: " + e.toString());
		}
		br.flush();
		
	}
	
}
