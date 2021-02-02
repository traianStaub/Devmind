package depozitare;

import java.util.ArrayList;

import surprise.ISurprize;

public abstract class Bag implements IBag {

	//super class that implements the similar methods put, isEmpty and size;
	protected ArrayList<ISurprize> surprizes;
	
	public Bag() {
		this.surprizes = new ArrayList<ISurprize>();
	}
	
	@Override
	public void put(ISurprize newSurprize) {
		this.surprizes.add(newSurprize);

	}

	@Override
	public void put(IBag bagOfSurprizes) {
		while(!bagOfSurprizes.isEmpty()) {
			this.surprizes.add(bagOfSurprizes.takeOut());
		}

	}

	@Override
	public boolean isEmpty() {
		if(this.surprizes.size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return this.surprizes.size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < surprizes.size(); i++) {
			sb.append(surprizes.get(i).toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
