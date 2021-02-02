package radixSort;

import java.util.ArrayList;

public class RadixSort {

	RadixHashTable radixTable;
	
	public RadixSort(String order) {
		radixTable = new RadixHashTable(order);
	}
	
	public RadixSort(){
		radixTable = new RadixHashTable();
	}
	
	public ArrayList<Integer> sort(ArrayList<Integer> input){
		int max = 0;
		ArrayList<Integer> workerList = new ArrayList<>();
		
		//finds the largest number;
		for(int i = 0; i < input.size(); i++) {
			int temp = input.get(i);
			max = max < temp ? temp : max;
			workerList.add(input.get(i));
		}
		
		//finds the number of digits of that number
		int digitCounter = 0;
		while(max % 10 != 0) {
			digitCounter++;
			max = max / 10;
		}
		
		//sorts the arrayList
		int base = 10;
		for(int i = 0; i < digitCounter; i++) {
			for(int arrayIndex = 0; arrayIndex < workerList.size(); arrayIndex++) {
				radixTable.add(workerList.get(arrayIndex), base);
			}
			
			workerList = radixTable.asArrayList();	
			base *= 10;
		}
		
		return workerList;
	}
	
}
