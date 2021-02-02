package radixSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RadixHashLambdaIII {

	private ArrayList<ArrayDeque<Integer>> table;
	private int capacity = 10;

	private IAsArrayList asArrayFunction;
	
	public RadixHashLambdaIII(String order) {
		table = new ArrayList<>();
		
		for(int i = 0; i < capacity; i++) {
			table.add(new ArrayDeque<Integer>());
		}
		
		switch(order) {
		case "Desc":
			asArrayFunction = () -> asArrayListDescending();
			break;
		default:
			asArrayFunction = () -> asArrayListAscending();
		}
		
	}
	
	public RadixHashLambdaIII() {
		this("Asc");
	}
	
	public void add(Integer value, int base) {
		Deque<Integer> row = table.get((value % base) / (base / 10));
		row.addLast(value);
	}
	
	public ArrayList<Integer> asArrayListLambda(){
		return(asArrayFunction.asArray());
	}
	
	private ArrayList<Integer> asArrayListAscending(){
		ArrayList<Integer> solution = new ArrayList<>();
		
		for(int i = 0; i < table.size(); i++) {
			Deque<Integer> temp = table.get(i);
			while(!temp.isEmpty()) {
				solution.add(temp.removeFirst());
			}
		}
		return solution;
	}
		
	private ArrayList<Integer> asArrayListDescending(){
		ArrayList<Integer> solution = new ArrayList<>();
		
		for(int i = table.size() - 1; i >= 0; i--) {
			Deque<Integer> temp = table.get(i);
			while(!temp.isEmpty()) {
				solution.add(temp.removeFirst());
			}
		}
		return solution;
	}

	interface IAsArrayList{
		public ArrayList<Integer> asArray();
	}
	
	public void printHash() {
		for(int i = 0; i < table.size(); i++) {
			System.out.println(table.get(i));
		}
	}
	
}




