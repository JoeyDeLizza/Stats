import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Plotter {
	WriteData wd;
	Plotter() {
		
		wd = new WriteData("Points.csv");
	}
	
	public void line(double m, double b, int numPoints) throws IOException {
		for(int x = 0; x < numPoints; x++) {
			String output = "";
			double y = m*x + b;
			output = output + x + "," +y;
			wd.outputSingleLine(output + "\n");
		}
	}
	
	public void log(double m, double b, int numPoints) throws IOException {
		for(int x = 1; x <= numPoints; x++) {
			String output = "";
			double y = Math.log(m*x) + b;
			output = output + x + "," +y;
			wd.outputSingleLine(output + "\n");
		}
	}
	
	/**
	 * Randomly adds or subtracts a number between 0 and the bound for each y-coordinate
	 * Kind of ugly and could be cleaner
	 * @param bound the upper bound non-inclusive
	 * @throws IOException
	 */
	public void salt(int bound) throws IOException {
		Random rand = new Random();
        String line;
        WriteData salt = new WriteData("SaltedPoints.csv");
 
        FileReader fr=null;
        BufferedReader br;
        try
        {
            fr = new FileReader("Points.csv");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
        br = new BufferedReader(fr);
        // read first line in Points
        line = br.readLine();
        // Loop to read entire file
        while (line != null) {
        	// split the line to store points in array
        		String[] str = line.split(",");
        		// Line to be printed in Salted file = x point
        		String newLine = str[0];
        		// get y cord
        		double yNum = Double.parseDouble(str[1]);
        		// number to be added to y
        		int saltedNum = rand.nextInt(bound);
        		// randomized boolean to determine to add or subtract
        		boolean subtract = rand.nextBoolean();
        		if(subtract) {
        			yNum -= saltedNum;
        		} else {
        			yNum += saltedNum;
        		}
        		// append comma and salted yNum
        		newLine += "," + yNum;
        		//System.out.println(newLine);
        		salt.outputSingleLine(newLine + "\n");
        		line = br.readLine();
        }
        fr.close();
        br.close();
	}
	
	/**
	 * Just takes the moving average with a time of t
	 * Just as ugly as the salt function but worse
	 * @param t number points to use for average
	 * @throws IOException
	 */
	public void smooth(int t) throws IOException {
        String line;
        WriteData smooth = new WriteData("SmoothedPoints.csv");

 
        FileReader fr=null;
        BufferedReader br;
        try
        {
            fr = new FileReader("SaltedPoints.csv");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
        br = new BufferedReader(fr);
        
        line = br.readLine();
        String file ="";
        while (line != null) {
        		file += line +',';
        		line = br.readLine();
        }
       // System.out.println(file);
        // Splits points
        String[] points = file.split(",");
        ArrayList<String> yPoints = new ArrayList<>();
        ArrayList<String> xPoints = new ArrayList<>();
        // create list of x points
        for(int i = 0; i < points.length/2; i++) {
        	xPoints.add(""+i);
        }
        // create list of y points
        for(int i = 1; i < points.length; i+=2) {
        	yPoints.add(points[i]);
        }
     
        ArrayList<Double> nNums = new ArrayList<>();
        for(int i = 0; i < t*2; i+=2) {
        	//System.out.println(points[i]);
        	nNums.add(Double.parseDouble(points[i]));
  
        }
      //  System.out.println(nNums.toString());
        smooth.outputSingleLine("" + (t-1) + "," + sum(nNums)/t + "\n");
        
       int pointer = 0;
        for(int i = t; i < xPoints.size(); i++) {
        	nNums.set(pointer, Double.parseDouble(yPoints.get(i)));
        	pointer = (++pointer) % t;
        	System.out.println(nNums.toString());

        	String output = "" + (i) + "," + sum(nNums)/t +"\n";
        	smooth.outputSingleLine(output);
        }
        
        fr.close();
        br.close();
	}
	
	private Double sum(ArrayList<Double> l) {
		Double sum = 0.0;
		for(Double n : l) {
			sum += n;
		}
		return sum;
	}

}
