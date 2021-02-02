package bagFactory;

import depozitare.BagTypes;
import depozitare.IBag;

public class BagFactory implements IBagFactory {

	BagTypes bagType = BagTypes.DEFAULT;
	
	@Override
	public IBag makeBag(String type) {
		return bagType.getBag(type);
	}

}
