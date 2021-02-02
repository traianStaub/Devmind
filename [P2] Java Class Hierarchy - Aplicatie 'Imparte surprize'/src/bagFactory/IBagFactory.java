package bagFactory;

import depozitare.IBag;

public interface IBagFactory {

	//create a new container, accordint to the specified type
	IBag makeBag(String type);
}
