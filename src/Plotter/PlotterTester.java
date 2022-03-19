import java.io.IOException;

public class PlotterTester {
	
	public static void main(String[] args) throws IOException {
		
		Plotter plot = new Plotter();
		plot.line(1, 0.0, 100);
		plot.salt(11);
		plot.smooth(10);
	}

}
