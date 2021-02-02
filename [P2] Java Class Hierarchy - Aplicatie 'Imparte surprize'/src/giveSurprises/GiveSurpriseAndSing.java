package giveSurprises;

public class GiveSurpriseAndSing extends AbstractGiveSurprizes {

	public GiveSurpriseAndSing(String bagType, int waitTime) {
		super(bagType, waitTime);
	}
	
	@Override
	protected void giveWithPassion() {
		System.out.println("Singing a nice song, full of joy and genuine excitement…");
		System.out.println();

	}

}
