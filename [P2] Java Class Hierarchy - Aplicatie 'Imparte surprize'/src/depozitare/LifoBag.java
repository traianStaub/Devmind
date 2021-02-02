package depozitare;

import surprise.ISurprize;

public class LifoBag extends Bag implements IBag {

	@Override
	public ISurprize takeOut() {
		if(super.surprizes.size() == 0)
			return null;
		
		int surprizeIndex = surprizes.size() - 1;
		
		ISurprize newSurprize = surprizes.get(surprizeIndex);
		surprizes.remove(surprizeIndex);
		
		return newSurprize;
	}

}
