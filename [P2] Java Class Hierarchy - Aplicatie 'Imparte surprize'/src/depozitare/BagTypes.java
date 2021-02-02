package depozitare;

public enum BagTypes {

	RANDOM("RANDOM"),
	FIFO("FIFO"),
	LIFO("LIFO"),
	DEFAULT("def");
	
	String type;
	
	private BagTypes(String type) {
		this.type = type;
	}
	
	private BagTypes getType(String type) {
		for(BagTypes bag : BagTypes.values()) {
			if(bag.type.equalsIgnoreCase(type))
				return bag;
		}
		
		return RANDOM;
	}
	
	public IBag getBag(String type) {
		BagTypes bagType = getType(type);
		
		switch(bagType) {
		case FIFO:
			return new FifoBag();
		case LIFO:
			return new LifoBag();
		default:
			return new RandomBag();	
		}
	}
}
