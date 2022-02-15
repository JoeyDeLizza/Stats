import java.util.ArrayList;
import java.util.Collections;

public class Stats {

	private ArrayList<Double> nums;
	
	Stats(ArrayList<Double> nums) {
		this.nums = new ArrayList<>(nums);
		nums.sort(null);
	}
	
	Stats(Double... n) {
		this.nums = new ArrayList<>();
		for(Double x : n) {
			nums.add(x);
		}
	}
	
	public ArrayList<Double> getNums() {
		return nums;
	}

	public void setNums(ArrayList<Double> nums) {
		this.nums = nums;
	}
	
	public double mean() {
		return sum() / nums.size();
	}
	
	public double sum() {
		return sum(this.nums);
	}
	
	
	public double variance() {
		ArrayList<Double> list = new ArrayList<>(this.nums);
		for(int i = 0; i < list.size(); i++) {
			list.set(i, Math.pow(list.get(i) - mean(), 2));
		}
		
		return sum(list) / (list.size() - 1);
		
		
	}
	
	public double standardDeviation() {
		return Math.sqrt(variance());
	}
	
	private double sum(ArrayList<Double> n) {
		double sum = 0;
		for(Double num : n) {
			sum+= num;
		}
		return sum;
	}
	
	public double median() {
		return median(this.nums);
	}
	
	public ArrayList<Double> mode() {
		return mode(this.nums);
	}
	
	public ArrayList<Double> mode(ArrayList<Double> n) {
		int most = 0;
		ArrayList<Double> mode = new ArrayList<>();
		for(int i = 1; i < n.size(); i++)	 {
			int freq = Collections.frequency(n, n.get(i));
			if (freq > most && (n.get(i) != n.get(i-1))) {
				most = freq;
				mode = new ArrayList<>();
				mode.add(n.get(i));
			} else if(freq == most ) {
				mode.add(n.get(i));
			}
		}
		return reduce(mode);
			
	}
	
	private double median(ArrayList<Double> n) {
		ArrayList<Double> list = new ArrayList<>(n);
		if (list.size() == 2)
			return (sum(list)) / 2;
		else if(list.size() == 1)
			return list.get(0);
		
		list = new ArrayList<>(list.subList(1, list.size()-1));
		return median(list);
	}
	
	private ArrayList<Double> reduce(ArrayList<Double> s) {
		s.sort(null);

		ArrayList<Double> set = new ArrayList<>();
		Double prev = s.get(0);
		set.add(prev);
		for (int i = 1; i < s.size(); i++) {
			if (Double.compare(prev, s.get(i)) != 0)
				set.add(s.get(i));
			prev = s.get(i);
		}
		return set;
		
	}
	
	public void runAll() {
		System.out.println("Mean: " + mean());
		System.out.println("Median: " + median());
		System.out.println("Mode: " + mode());
		System.out.println("Standard Deviation: " + standardDeviation());
		System.out.println("Variance: " + variance());
	}
	
}
