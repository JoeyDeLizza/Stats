
public class PokerHandTester {
	public static void main(String[] args) {

		HandEvaluator hand = new HandEvaluator();
		// The check pair function returns true if the hand has at least a pair
		// ie. it includes three and four of kinds, kinda skews the stat
		hand.runAllTests(10000);
		
	}
}
