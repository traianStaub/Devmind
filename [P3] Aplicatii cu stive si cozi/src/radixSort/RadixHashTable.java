package radixSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RadixHashTable {

	private ArrayList<ArrayDeque<Integer>> table;
	private int capacity = 10;
	private String order;
	
	public RadixHashTable(String order) {
		table = new ArrayList<>();
		this.order = order;
		
		for(int i = 0; i < capacity; i++) {
			table.add(new ArrayDeque<Integer>());
		}
		
	}
	
	public RadixHashTable() {
		this("Asc");
	}
	
	
	public void add(Integer value, int base) {
		Deque<Integer> row = table.get((value % base) / (base / 10));
		row.addLast(value);
	}
	
	public ArrayList<Integer> asArrayList(){
		switch(order) {
		case "Desc":
			return asArrayListDescending();
		default:
			return asArrayListAscending();
		}
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

	
	public void printHash() {
		for(int i = 0; i < table.size(); i++) {
			System.out.println(table.get(i));
		}
	}
	
}




