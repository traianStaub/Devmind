package depozitare;

import surprise.ISurprize;

public interface IBag {

	//adds a surprize
	void put(ISurprize newSurprize); 
	
	
	//adds all the surprizes from a bag
	//bag of surprizes will be empty
	void put(IBag bagOfSurprizes);
	
	//removes a surprize from the bag
	ISurprize takeOut();
	
	//Checks if the bag is empty or not
	boolean isEmpty();
	
	//returns the number of surprises in the bag
	int size();
}
