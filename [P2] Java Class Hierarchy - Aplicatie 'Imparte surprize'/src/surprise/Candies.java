package surprise;

import java.util.Random;

public class Candies implements ISurprize{

	private int numar;
	private CandiesTypes tip;	
	
	private Candies(int numarBomboane, CandiesTypes tipBomboane) {
		this.numar = numarBomboane;
		this.tip = tipBomboane;
	}
	
	public static Candies generate() {
		Random random = new Random();
		
		CandiesTypes value = CandiesTypes.getType(random.nextInt(CandiesTypes.values().length - 1));

		return new Candies(random.nextInt(101), value);
	}
	
	@Override
	public void enjoy() {
		System.out.println("You have " + this.numar + " " + this.tip.toString() + " candies");
	}
	
	@Override
	public String toString() {
		return "You have " + this.numar + " " + this.tip.toString() + " candies";
	}
}
