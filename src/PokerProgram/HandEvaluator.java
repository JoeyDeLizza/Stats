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
				System.out.println(hand.get(i).toString() + " " + hand.get(pointer).toString());
				if(hand.get(i).getNumber() == hand.get(pointer).getNumber())
					return true;
			}
			
			
		}
		return false;
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
	
	public boolean checkFullHouse() {
		ArrayList<Card> pair = removePair();
		if(pair.size() == 0) {
			return false;
		}
		return checkThree();
	}
	
	public boolean checkFour() {
		ArrayList<Card> pair = removePair();
		System.out.println(showHand());
		ArrayList<Card> pair2 = removePair();
		if(pair2.size() == 0) {
			return false;
		}
		System.out.println(showHand());
		int num = pair.get(0).getNumber();
		int num2 = pair2.get(0).getNumber();
	
		
		if(num == num2)
			return true;
		return false;
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
	
	public boolean checkFlush() {
		int prev = 0;
		for(int i = 1; i < hand.size(); i++) {
			if(hand.get(i).getSuite() != hand.get(prev).getSuite())
				return false;
			prev++;
		}
		return true;
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
	
	public boolean checkStraightFlush() {
		if(checkStraight() && checkFlush()) {
			return true;
		}
		return false;
	}
	
	private ArrayList<Card> drawFiveCards() {
		ArrayList<Card> cards = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			cards.add(deck.drawCard());
		}
		return cards;
	}
}
