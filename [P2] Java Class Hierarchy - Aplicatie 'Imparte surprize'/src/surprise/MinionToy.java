package surprise;

public class MinionToy implements ISurprize {

	private MinionToyTypes minion;	
	private static int index = 0;
	
	private MinionToy(String nume) {
		this.minion = MinionToyTypes.searchByName(nume);
	}
	
	private MinionToy(MinionToyTypes minion) {
		this.minion = minion;
	}
	
	public static MinionToy generate() {
		MinionToyTypes minion = MinionToyTypes.getType(index);
		
		if(++index >= MinionToyTypes.values().length)
			index = 0;
		
		return new MinionToy(minion);
	}
	
	@Override
	public void enjoy() {
		System.out.println("You'r minion is " + minion);
	}
	
	@Override
	public String toString() {
		return minion.toString();
	}

}
