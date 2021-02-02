package giveSurprises;

import java.util.concurrent.TimeUnit;

import bagFactory.BagFactory;
import depozitare.IBag;
import surprise.ISurprize;

public abstract class AbstractGiveSurprizes {

	protected IBag bag;
	protected int waitTime;
	protected static BagFactory bagFactory = new BagFactory();
	
	protected AbstractGiveSurprizes(String bagType, int waitTime) {
		this.bag = bagFactory.makeBag(bagType);
		this.waitTime = waitTime;
	}
	
	public void put(ISurprize newSurprise) {
		bag.put(newSurprise);
	}
	
	public void put(IBag surprizesBag) {
		bag.put(surprizesBag);
	}
	
	public void give() {
		bag.takeOut().enjoy();
		giveWithPassion();
	}
	
	public void giveAll() {
		try {
			while(!bag.isEmpty()) {
				bag.takeOut().enjoy();
				giveWithPassion();
				TimeUnit.SECONDS.sleep(waitTime); // number of seconds to sleep
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isEmpty() {
		return bag.isEmpty();
	}
	
	@Override
	public String toString() {
		return bag.toString();
	}
	
	protected abstract void giveWithPassion();
}
