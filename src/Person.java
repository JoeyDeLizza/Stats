import java.util.Random;

public class Person {
	private int birthday;
	
	Person() {
		Random rand = new Random();
		birthday = rand.nextInt(356);
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

}
