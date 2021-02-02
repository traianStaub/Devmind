package depozitare;

import surprise.ISurprize;

public class FifoBag extends Bag implements IBag {

	@Override
	public ISurprize takeOut() {
		if(super.surprizes.size() == 0)
			return null;
		
		ISurprize newSurprize = surprizes.get(0);
		surprizes.remove(0);
		
		return newSurprize;
	}

}
