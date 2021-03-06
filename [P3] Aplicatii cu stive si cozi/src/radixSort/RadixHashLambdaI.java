package radixSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RadixHashLambdaI {

	private ArrayList<ArrayDeque<Integer>> table;
	private int capacity = 10;
	private String order;
	
	public RadixHashLambdaI(String order) {
		table = new ArrayList<>();
		this.order = order;
		
		for(int i = 0; i < capacity; i++) {
			table.add(new ArrayDeque<Integer>());
		}	
	}
	
	public RadixHashLambdaI() {
		this("Asc");
	}
	
	
	public void add(Integer value, int base) {
		Deque<Integer> row = table.get((value % base) / (base / 10));
		row.addLast(value);
	}

	
	public ArrayList<Integer> asArrayListLambda(){
		int start;
		ICompare compareFunction;
		IChange changeFunction;
		
		switch(order) {
		case "Desc":
			start = table.size() - 1;
			compareFunction = (int i) -> i >= 0;
			changeFunction = (int i) -> i - 1;
			break;
		default:
			start = 0;
			compareFunction = (int i) -> i < table.size();
			changeFunction = (int i) -> i + 1;	
		}
		
		return asArrayListIrelevantOrder(compareFunction, changeFunction, start);
	}
	
	private ArrayList<Integer> asArrayListIrelevantOrder(ICompare compareFunction, IChange changeFunction, int start){
		ArrayList<Integer> solution = new ArrayList<>();
		
		for(int i = start; compareFunction.compare(i); i = changeFunction.change(i)) {
			Deque<Integer> temp = table.get(i);
			while(!temp.isEmpty()) {
				solution.add(temp.removeFirst());
			}
		}
		return solution;
	}
	
	interface ICompare {
		public boolean compare(int i);
	}
	
	interface IChange {
		public int change(int i);
	}
	
	public void printHash() {
		for(int i = 0; i < table.size(); i++) {
			System.out.println(table.get(i));
		}
	}
	
}




