import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WriteData wd = new WriteData();
		
		ArrayList<Double> nums = new ArrayList<>();
		nums.add(1.0);
		nums.add(1.0);
		nums.add(1.0);
		nums.add(2.0);
		nums.add(2.0);

		nums.add(3.0);
		nums.add(4.0);
		nums.add(4.0);
		nums.add(4.0);

		Stats test = new Stats(nums);
		System.out.println(test.mode());

		
		Random rand = new Random();
		
		for(int i = 0; i < 1000; i++) {
			String line = ""; 
			//line = line + i + "," + rand.nextInt(1001);
			//System.out.println(line);
			//wd.outputSingleLine(line + "\n");

		}
		// Code Pushed
		
	}

}
