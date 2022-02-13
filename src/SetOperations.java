import java.util.ArrayList;

public class SetOperations {

	public ArrayList<Integer> union(ArrayList<Integer> x, ArrayList<Integer> y) {
		ArrayList<Integer> xy = new ArrayList<Integer>(x);
		xy.addAll(y);
		xy.sort(null);
		
		ArrayList<Integer> set = new ArrayList<>();
		set.add(xy.get(0));
		
		int prev = xy.get(0);
		for(int i = 1; i < xy.size(); i++) {
			if (prev != xy.get(i) ) {
				set.add(xy.get(i));
			} 
			prev = xy.get(i);
		}
		
		return set;
		
	}
	
	public ArrayList<Integer> intersect(ArrayList<Integer> x, ArrayList<Integer> y) {
		ArrayList<Integer> set = new ArrayList<>();
		x = new ArrayList<>(reduce(x));
		y = new ArrayList<>(reduce(y));
		System.out.println(x);
		System.out.println(y);

		for(int i = 0; i < x.size(); i++) {
			for(int j = 0; j < y.size(); j++) {
				if (x.get(i) == y.get(j))
						set.add(x.get(i));
			}
		}
		
		set.sort(null);
		//reduce(set);
		return set;
	
	}
	
	public ArrayList<Integer> compliment(ArrayList<Integer> a, ArrayList<Integer> x) {
		ArrayList<Integer> set = new ArrayList<>(a);
		
		for(int i = 0; i < x.size(); i++) {
			set.remove(x.get(i));
		}
		return set;
	}
	
	private ArrayList<Integer> reduce(ArrayList<Integer> s) {
		System.out.println(s);
		s.sort(null);
		System.out.println(s + " sorted" );


		ArrayList<Integer> set = new ArrayList<>();
		int prev = s.get(0);
		set.add(prev);
		for (int i = 1; i < s.size(); i++) {
			if (prev != s.get(i))
				set.add(s.get(i));
			prev = s.get(i);
		}
		System.out.println("reduced " + set);
		return set;
		
	}
	
}