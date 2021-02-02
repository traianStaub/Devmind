package giveSurprises;

public class GiveSurpriseAndApplause extends AbstractGiveSurprizes {

	public GiveSurpriseAndApplause(String bagType, int waitTime) {
		super(bagType, waitTime);
	}
	
	@Override
	protected void giveWithPassion() {
		System.out.println("Loud applause to you… For it is in giving that we receive.");
		System.out.println();

	}

}
