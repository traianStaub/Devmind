package surprise;

public enum SurprizesTypes {

	FORTUNECOOKIE,
	CANDIES,
	MINIONTOY;
	
	public static ISurprize getSurprize(int n) {
		int index = 0;
		SurprizesTypes value = CANDIES;
		
		for(SurprizesTypes surprise : SurprizesTypes.values()) {
			if(index == n) {
				value = surprise;
				break;
			}
			else 
				index++;
		}
	
		switch(value) {
		case FORTUNECOOKIE:
			return FortuneCookie.generate();
		case CANDIES:
			return Candies.generate();
		case MINIONTOY:
			return MinionToy.generate();
		}
		
		return Candies.generate();
	}
}
