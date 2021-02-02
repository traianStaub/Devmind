package gather;

import java.util.ArrayList;
import java.util.Random;

import surprise.ISurprize;
import surprise.SurprizesTypes;

public final class GatherSurprises {
	
	private GatherSurprises() {
		
	}
	
	public static ISurprize gather() {
		Random random = new Random();
		return SurprizesTypes.getSurprize(random.nextInt(SurprizesTypes.values().length));
	}
	
	public static ArrayList<ISurprize> gather(int n) {
		
		ArrayList<ISurprize> surprize = new ArrayList<ISurprize>();
		
		if(n <= 0 )
			return surprize;
		
		for(int i = 0; i < n; i++) {
			surprize.add(gather());
		}
		
		return surprize;
	}
	
}
