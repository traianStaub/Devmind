package depozitare;

import java.util.Random;

import surprise.ISurprize;

public class RandomBag extends Bag implements IBag{

	@Override
	public ISurprize takeOut() {
		if(super.surprizes.size() == 0)
			return null;
		
		Random random = new Random();
		int surprizeIndex = random.nextInt(surprizes.size());
		
		ISurprize newSurprize = surprizes.get(surprizeIndex);
		surprizes.remove(surprizeIndex);
		
		return newSurprize;
	}
	
}
