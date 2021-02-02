package surprise;

public enum CandiesTypes {

	CHOCOLATE("chocolate"),
	JELLY("jelly"),
	FRUITS("fruits"),
	VANILLA("vanilla"),
	VEGETABLE("vegetable");
	
	String madeOf;
	
	private CandiesTypes(String madeOf) {
		this.madeOf = madeOf;
	}
	
	public static CandiesTypes getType(int index) {
		
		int indexCandie = 0;
		
		for(CandiesTypes candie: CandiesTypes.values()) {
			if(indexCandie == index) {
				return candie;
			}
			else
				indexCandie++;
		}
		
		return VEGETABLE;
	}
	
	@Override
	public String toString() {
		return madeOf;
	}
}
