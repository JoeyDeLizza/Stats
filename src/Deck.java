import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	Deck() {
		cards = new ArrayList<>();
		ArrayListbuildDeck();
	}
	
	public Card drawCard() {
		Random gen = new Random();
		Card drawn = cards.remove(gen.nextInt(cards.size()));
		return drawn;
	}
	
	private void ArrayListbuildDeck() {
		String[] suites = new String[] {"Clubs", "Spades", "Hearts", "Diamonds"};
		for(int j = 0; j < suites.length; j++) {
		for(int i = 1; i <= 13; i++) {
			cards.add(new Card(suites[j], i));
		}
		}
	}
}
