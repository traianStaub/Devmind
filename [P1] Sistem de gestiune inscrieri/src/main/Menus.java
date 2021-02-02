package main;

public enum Menus {

	FALSEINPUT(-1),
	HELP(0),
	ADD(1),
	CHECK(2),
	REMOVE(3),
	UPDATE(4),
	GUESTS(5),
	WAITLIST(6),
	AVAILABLE(7),
	GUEST_NO(8),
	WAITLIST_NO(9),
	SUBSCRIBE_NO(10),
	SEARCH(11),
	UPDATESIZE(12),
	ADDDEFAULT(13),
	SHOWALL(14);

	
	int number;
	int inputNumbers = 11;
	
	private Menus(int number) {
		this.number = number;
	}
	
	public static Menus getMenu(int input) {
		for(Menus m : Menus.values()) {
			if(m.number == input)
				return m;
		}
		
		return FALSEINPUT;
	}
}
