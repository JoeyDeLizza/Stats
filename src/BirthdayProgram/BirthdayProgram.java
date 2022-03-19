import java.util.ArrayList;

public class BirthdayProgram {
	private ArrayList<Person> people;
	
	/**
	 * Creates a list of n people with random birthdays
	 * @param n Number of people
	 */
	public void setup(int n) { 
		people = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			people.add(new Person());
		}
	}
	/**
	 * Checks whether anyone in the list share the same birthday
	 * @return returns true if any two people share the same birthday otherwise false
	 */
	public boolean birthdayCheck() {
		ArrayList<Person> list = new ArrayList<>(people);
		for(int i = 0; i < list.size();) {
			
			Person p1 = list.remove(i);

			for (int j = 0; j <= list.size()-1; j++) {
				if (p1.getBirthday() == list.get(j).getBirthday()) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Test to see if any two people within set of n people share the same birthday
	 * @param n number of people
	 * @return Returns result of birthdayCheck()
	 */
	public boolean test(int n) {
		setup(n);
		return birthdayCheck();
	}
	/**
	 * Runs the test multiple times and returns the percentage that two people do share the same birthday
	 * @param n Number of people 
	 * @param t Number of times to run the tests
	 * @return
	 */
	public double runTests(int n, int t) {
		int matchCount = 0;
		for(int i = 0; i < t; i++) {
			if(test(n)) {
				matchCount++;
			}
		}
		

		return((double) matchCount / t);
	}

}
