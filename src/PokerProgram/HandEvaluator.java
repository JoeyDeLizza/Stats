import java.util.ArrayList;

public class HandEvaluator {
	private Deck deck;
	private ArrayList<Card> hand;
	
	
	HandEvaluator() {
		deck = new Deck();
		hand = new ArrayList<Card>();
		hand = drawFiveCards();


	}
	
	public void sortHand() {
		hand.sort(null);
	}
	
	public String showHand() {
		return hand.toString();
	}
	
	public boolean checkPair() {
		
		for(int i = 0; i < hand.size(); i++) {
			int pointer = i+1;
			for(;pointer < hand.size(); pointer++) {
				//System.out.println(hand.get(i).toString() + " " + hand.get(pointer).toString());
				if(hand.get(i).getNumber() == hand.get(pointer).getNumber())
					return true;
			}
			
			
		}
		return false;
	}
	
	public boolean testCheckPair() {
		HandEvaluator test = new HandEvaluator();
		return test.checkPair();
	}
	
	public void runTestCheckPair(int n) {
		double count = 0;
		for(int i = 0; i < n; i++) {
			if(testCheckPair()) {
				count++;
			}
		}
		System.out.println("Probability of getting a pair: " + (double) (count/n));
	}
	public ArrayList<Card> removePair() {
		ArrayList<Card> pair = new ArrayList<>();
		boolean isPair = false;

		for(int i = 0; i < hand.size(); i++) {
			int pointer = i+1;
			for(;pointer < hand.size(); pointer++) {
				//System.out.println(hand.get(i).toString() + " " + hand.get(pointer).toString());
				if(hand.get(i).getNumber() == hand.get(pointer).getNumber()) {
					pair.add(hand.remove(i));
					pair.add(hand.remove(pointer-1));
					isPair = true;
					break;
				}
	
			}
			if(isPair)
				break;
		}
		return pair;
	}
	
	public boolean checkThree() {
		ArrayList<Card> pair = removePair();
		if(pair.size() == 0) {
			return false;
		}
		int num = pair.get(0).getNumber();
		for(Card c : hand) {
			if (c.getNumber() == num) {
				return true;
			}
		}
		return false;
	}
	
	public boolean testCheckThree() {
		HandEvaluator test = new HandEvaluator();
		return test.checkThree();
	}
	
	public void runTestCheckThree(int n) {
		double count = 0;
		for(int i = 0; i < n; i++) {
			if(testCheckThree()) {
				count++;
			}
		}
		System.out.println("Probability of getting a three of a kind: " + (double) (count/n));
	}
	
	public boolean checkFullHouse() {
		ArrayList<Card> pair = removePair();
		if(pair.size() == 0) {
			return false;
		}
		return checkThree();
	}
	
	public boolean testCheckFullHouse() {
		HandEvaluator test = new HandEvaluator();
		return test.checkFullHouse();
	}
	
	public void runTestCheckFullHouse(int n) {
		double count = 0;
		for(int i = 0; i < n; i++) {
			if(testCheckFullHouse()) {
				count++;
			}
		}
		System.out.println("Probability of getting a Full House: " + (double) (count/n));
	}
	
	public boolean checkFour() {
		ArrayList<Card> pair = removePair();
		ArrayList<Card> pair2 = removePair();
		if(pair2.size() == 0) {
			return false;
		}
		int num = pair.get(0).getNumber();
		int num2 = pair2.get(0).getNumber();
	
		
		if(num == num2)
			return true;
		return false;
	}
	
	public boolean testCheckFour() {
		HandEvaluator test = new HandEvaluator();
		return test.checkFour();
	}
	
	public void runTestCheckFour(int n) {
		double count = 0;
		for(int i = 0; i < n; i++) {
			if(testCheckFour()) {
				count++;
			}
		}
		System.out.println("Probability of getting a Four of a Kind: " + (double) (count/n));
	}
	
	public boolean checkTwoPairs() {
		ArrayList<Card> pair = removePair();
		boolean hasTwoPairs = false;
		if(pair.isEmpty()) {
			hasTwoPairs = false;
		}  
		if(checkPair()) {
			hasTwoPairs = true;
		}
		return hasTwoPairs;
		
	}
	
	public boolean testCheckTwoPairs() {
		HandEvaluator test = new HandEvaluator();
		return test.checkTwoPairs();
	}
	
	public void runTestCheckTwoPairs(int n) {
		double count = 0;
		for(int i = 0; i < n; i++) {
			if(testCheckTwoPairs()) {
				count++;
			}
		}
		System.out.println("Probability of getting two pairs: " + (double) (count/n));
	}
	
	public boolean checkFlush() {
		int prev = 0;
		for(int i = 1; i < hand.size(); i++) {
			if(hand.get(i).getSuite() != hand.get(prev).getSuite())
				return false;
			prev++;
		}
		return true;
	}
	
	public boolean testCheckFlush() {
		HandEvaluator test = new HandEvaluator();
		return test.checkFlush();
	}
	
	public void runTestCheckFlush(int n) {
		double count = 0;
		for(int i = 0; i < n; i++) {
			if(testCheckFlush()) {
				count++;
			}
		}
		System.out.println("Probability of getting a Flush: " + (double) (count/n));
	}
	
	public boolean checkStraight() {
		sortHand();
		int prev = 0;
		for(int i = 1; i < hand.size(); i++) {
			if(hand.get(i).getNumber() != hand.get(prev).getNumber()+1)
				return false;
			prev++;
		}
		return true;
	}
	
	public boolean testCheckStright() {
		HandEvaluator test = new HandEvaluator();
		return test.checkStraight();
	}
	
	public void runTestCheckStright(int n) {
		double count = 0;
		for(int i = 0; i < n; i++) {
			if(testCheckStright()) {
				count++;
			}
		}
		System.out.println("Probability of getting a Straight: " + (double) (count/n));
	}
	
	public boolean checkStraightFlush() {
		if(checkStraight() && checkFlush()) {
			return true;
		}
		return false;
	}
	public void runAllTests(int n) {
		runTestCheckPair(n);
		runTestCheckThree(n);
		runTestCheckFour(n);
		runTestCheckStright(n);
		runTestCheckFlush(n);
		runTestCheckTwoPairs(n);
	}
	
	private ArrayList<Card> drawFiveCards() {
		ArrayList<Card> cards = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			cards.add(deck.drawCard());
		}
		return cards;
	}
}
