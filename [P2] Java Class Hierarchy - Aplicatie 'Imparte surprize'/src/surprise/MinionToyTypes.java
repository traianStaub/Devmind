package surprise;

public enum MinionToyTypes {
	
	DAVE(0, "Dave", "verde", "fericit"),
	CARL(1, "Carl", "albastru", "morocanos"),
	KEVIN(2, "Kevin", "albastru", "fericit"),
	STUART(3, "Stuart", "portocaliu", "obosit"),
	JERRY(4, "Jerry", "verde", "obosit"),
	TIM(5, "Tim", "mov", "somnoros");
	
	String nume;
	String culoare;
	String stare;
	int indexMinion;
	
	private MinionToyTypes(int index, String nume, String culoare, String stare) {
		this.nume = nume;
		this.culoare = culoare;
		this.stare = stare;
		this.indexMinion = index;
	}
	
	public static MinionToyTypes getType(int index) {
		
		for(MinionToyTypes minion : MinionToyTypes.values()) {
			if(minion.indexMinion == index)
				return minion;
		}
		
		return DAVE;
	}
	
	public static MinionToyTypes searchByName(String name) {
		for(MinionToyTypes minion : MinionToyTypes.values()) {
			if(minion.nume.equals(name))
				return minion;
		}
		
		return DAVE;
	}
	
	@Override
	public String toString() {
		return this.nume + ", he is " + this.culoare + " and is felling " + this.stare;
	}
}
