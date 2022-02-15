import java.util.ArrayList;

public class BirthdayProgram {
	private ArrayList<Person> people;
	
	public void setup(int n) { 
		people = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			people.add(new Person());
		}
	}
	
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
	
	public boolean test(int n) {
		setup(n);
		return birthdayCheck();
	}
	
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
