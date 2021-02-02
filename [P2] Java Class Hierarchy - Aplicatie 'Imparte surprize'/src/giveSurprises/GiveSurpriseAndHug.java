package giveSurprises;

public class GiveSurpriseAndHug extends AbstractGiveSurprizes {

	public GiveSurpriseAndHug(String bagType, int waitTime) {
		super(bagType, waitTime);
	}
	
	@Override
	protected void giveWithPassion() {
		System.out.println("Warm wishes and a big hug!");
		System.out.println();

	}

}
