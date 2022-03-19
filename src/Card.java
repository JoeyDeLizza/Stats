
public class Card implements Comparable<Card>{
	private String suite;
	private int number;
	
	Card(String s, int n) {
		this.suite = s;
		this.number = n;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String toString() {
		return suite + " " +number;
	}
	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return Integer.compare(number, o.getNumber());
	}
	
}
