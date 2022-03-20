
public class StatsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stats test = new Stats();
		test.testBiDist(10, 9, .3, .7);
		test.testGeoDist(7, .5, .5);
		test.testHyperGeoDist(5, 5, 20, 10);
		test.testPoisDist(0, 1);
	}

}
