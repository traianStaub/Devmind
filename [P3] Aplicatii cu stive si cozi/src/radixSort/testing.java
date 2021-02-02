package radixSort;

import java.util.ArrayList;

public class testing {

	public static void main(String[] args) {
		int[] testing = {1000, 4, 4, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713};
		ArrayList<Integer> arrayTest = new ArrayList<>();
		
		for(int i = 0; i < testing.length; i++) {
			arrayTest.add(testing[i]);
		}
		
		System.out.println(arrayTest);
		System.out.println(" ");
		
		RadixSort radixAsc = new RadixSort();
		RadixSort radixDesc = new RadixSort("Desc");
		
		System.out.println("----Ascending----");
		System.out.println(radixAsc.sort(arrayTest));
		System.out.println("----Descending----");                  
		System.out.println(radixDesc.sort(arrayTest));

	}
	
	public static void testingHashTableType() {
		RadixHashTable test = new RadixHashTable("Desc");

		int[] testing = {1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713};
		ArrayList<Integer> temp = new ArrayList<>();
		
		for(int i = 0; i < testing.length; i++) {
			test.add(testing[i], 10);
		}
		test.printHash();
		temp = test.asArrayList();
		System.out.println(temp);
		System.out.println("-------");
		
		for(int i = 0; i < temp.size(); i++) {
			test.add(temp.get(i), 100);
		}
		test.printHash();
		temp = test.asArrayList();
		System.out.println(temp);
		System.out.println("-------");
		for(int i = 0; i < temp.size(); i++) {
			test.add(temp.get(i), 1000);
		}
		test.printHash();
		temp = test.asArrayList();
		System.out.println(temp);
		System.out.println("-------");
		for(int i = 0; i < temp.size(); i++) {
			test.add(temp.get(i), 10000);
		}
		test.printHash();
		temp = test.asArrayList();
		System.out.println(temp);
	}

}
