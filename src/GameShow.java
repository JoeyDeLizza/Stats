import java.util.ArrayList;
import java.util.Random;

public class GameShow {
	private ArrayList<Curtain> curts;
	private Curtain picked;
	
	/**
	 * Initializes three curtains randomly assigning one winner
	 * @return The list of curtains
	 */
	private ArrayList<Curtain> setUpCurts() {
		ArrayList<Curtain> newCurts = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			newCurts.add(new Curtain());
		}
		Random rand = new Random();
		newCurts.get(rand.nextInt(newCurts.size())).setPrize(true);
		
		return newCurts;
	}
	/**
	 * Randomly chooses one of the three curtains
	 */
	private void chooseCurtain() {
		Random rand = new Random();
		int num = rand.nextInt(curts.size());
		picked = new Curtain(curts.remove(rand.nextInt(curts.size())));
	}
	
	/**
	 * Changes the players answer to the other curtain
	 */
	private void changeCurtain() {
		for(int i = 0; i < curts.size(); i++) {
			if(!(curts.get(i).isPrize())) {
				curts.remove(i);
			}
			picked = curts.get(0);
		}
	}
	
	/**
	 * Starts one instance of the game
	 * @param keep flag used to determine if the player should keep or change their curtain
	 * @return Returns true if the curtain was correct otherwise false
	 */
	public boolean startGame(boolean keep) {
		curts = new ArrayList<>(setUpCurts());
		chooseCurtain();
		if(keep) {
			return picked.isPrize();
		} else {
			changeCurtain();
			return picked.isPrize();
		}
	}

	/**
	 * 
	 * @return Returns the curtain the player picked
	 */
	public Curtain getPicked() {
		return picked;
	}

	/**
	 * Sets the picked Curtain
	 * @param picked 
	 */
	public void setPicked(Curtain picked) {
		this.picked = picked;
	}
	
	/**
	 * Runs the game if the player keeps their original pick a variable number of times and prints 
	 * the probability of winning
	 * @param num Number of times to run the test
	 */
	public void testKeepCurtain(int num) {
		int wins = 0;
		GameShow game = new GameShow();
		for(int i = 0; i < num; i++) {
			if (game.startGame(true))
				wins++;
		}
		System.out.println("Winning percentage if you change curtain: " + (float) wins/num);
	}
	
	/**
	 * Runs the game if the player changes their pick a variable number of times and prints
	 * the probability of winning.
	 * @param num Number of times to run the test
	 */
	public void testChangeCurtain(int num) {
		int wins = 0;
		GameShow game = new GameShow();
		for(int i = 0; i < num; i++) {
			if (game.startGame(false))
				wins++;
		}
		System.out.println("Winning percentage if you keep curtain: " + (float) wins/num);
	}
	
	/*
	 * Runs both tests
	 */
	public void testGame(int num) {
		testChangeCurtain(num);
		testKeepCurtain(num);
	}
}
