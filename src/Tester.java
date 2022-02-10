import java.io.IOException;
import java.util.Random;

public class Tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WriteData wd = new WriteData();

		
		Random rand = new Random();
		
		for(int i = 0; i < 1000; i++) {
			String line = ""; 
			line = line + i + "," + rand.nextInt(1001);
			System.out.println(line);
			wd.outputSingleLine(line + "\n");

		}
		
	}

}
