package main;
import guest.GuestList;
import guest.Guest;
import guest.srchCrit;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
	
	Menus menu;
	GuestList list;
	Scanner sc;
	static int defNumar = 1;
	
	final static String[] validInputs = {"help", "add", "check", "remove", "update", "guests", "waitlist", "available", 
			"guests_no", "waitlist_no", "subscribe_no", "search", "update_no", "add_def", "show_all"};
	
	
	public UserInterface(GuestList list, Scanner sc) {
		this.list = list;
		this.sc = sc;
	}
	
	//methods
	//returns and sets the curent menu
	public Menus inputValidation(String input) {
		int menuIndex = -1;
		
		if(input.equalsIgnoreCase("quit")) {
			System.exit(0);
		}
		
		for(int i = 0; i < validInputs.length; i++) {
			if(validInputs[i].equalsIgnoreCase(input))
			{
				menuIndex = i;
				break;
			}
		}
		
		this.menu = Menus.getMenu(menuIndex);
		return this.menu;
	}
	
	//calls a method accordin to the current menu
	public void changeMenu() {
		
		switch(this.menu) {
			case HELP:
				helpMenu();
				break;
			case ADD:
				addMenu();
				break;
			case CHECK:
				checkMenu();
				break;
			case REMOVE:
				removeMenu();
				break;
			case UPDATE:
				updateMenu();
				break;
			case GUESTS:
				guestMenu();
				break;
			case WAITLIST:
				waitingListMenu();
				break;
			case AVAILABLE:
				availableMenu();
				break;
			case GUEST_NO:
				guestNoMenu();
				break;
			case WAITLIST_NO:
				waitListNoMenu();
				break;
			case SUBSCRIBE_NO:
				subscribeNoMenu();
				break;
			case SEARCH:
				searchMenu();
				break;
			case UPDATESIZE:
				updateSizeMenu();
				break;
			case ADDDEFAULT:
				addDefMenu();
				break;
			case SHOWALL:
				showAllMenu();
				break;
			default:
				System.out.println("WeirdMenu");
		}
	}
	
	//show the fucntions you have
	private void helpMenu() {
		System.out.println("1. help         - Afiseaza aceasta lista de comenzi");
		System.out.println("2. add          - Adauga o noua persoana (inscriere)");
		System.out.println("3. check        - Verifica daca o persoana este inscrisa la eveniment");
		System.out.println("4. remove       - Sterge o persoana existenta din lista");
		System.out.println("5. update       - Actualizeaza detaliile unei persoane");
		System.out.println("6. guests       - Lista de persoane care participa la eveniment");
		System.out.println("7. waitlist     - Persoanele din lista de asteptare");
		System.out.println("8. available    - Numarul de locuri libere");
		System.out.println("9. guests_no    - Numarul de persoane care participa la eveniment");
		System.out.println("10.waitlist_no  - Numarul de persoane din lista de asteptare");
		System.out.println("11.subscribe_no - Numarul total de persoane inscrise");
		System.out.println("12.search       - Cauta toti invitatii conform sirului de caractere introdus");
		System.out.println("13.update_no    - Update the number of available places");
		System.out.println("14.add_def      - adds a default participant -- FOR TESTING");
		System.out.println("15.show_all     - show all paticipants (both lists) --FOR TESTING");
		System.out.println("16.quit         - Inchide aplicatia");
		System.out.println();
	}
	
	//user input
	//calls the ad method
	private void addMenu() {
		String[] person = new String[4];
		int catIndex = 0;
		
		System.out.println("Se adauga o noua persoana…");
		System.out.println("Introduceti numele de familie:");
		person[catIndex++] = sc.nextLine();
		System.out.println("Introduceti prenumele:");
		person[catIndex++] = sc.nextLine();
		System.out.println("Introduceti email:");
		person[catIndex++] = sc.nextLine();
		System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
		person[catIndex++] = sc.nextLine();
		
		Guest newGuest = new Guest(person[0],person[1],person[2],person[3]);
		list.add(newGuest);
		System.out.println();

	}
	
	//---------------------------
	//searhc - update - remove auciliary
	//output for the user that is reused
	private void modIdentificare() {
		System.out.println("Alege modul de autentificare, tastand:");
		System.out.println("\"1\" - Nume si prenume");
		System.out.println("\"2\" - Email");
		System.out.println("\"3\" - Numar de telefon (format \"+40733386463\"));");
	}
	
	//returns the searchin criteria and saves the users input in a string array,
	//each pozition form the string array is a field of the Guest class
	private srchCrit idCases(String inputNumber, String[] participant) {
		
		srchCrit searchCrit = srchCrit.FULL;
		
		switch(inputNumber) {
		
		case "1":
			searchCrit = srchCrit.NAME;
			System.out.println("Introduceti numele de familie:");
			participant[0] = sc.nextLine();
			System.out.println("Introduceti prenumele:");
			participant[1] = sc.nextLine();
			break;
		case "2":
			searchCrit = srchCrit.EMAIL;
			System.out.println("Introduceti email:");
			participant[2] = sc.nextLine();
			break;
		case "3":
			searchCrit = srchCrit.PHONE;
			System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
			participant[3] = sc.nextLine();
			break;
		default:
			System.out.println("Invalid Input --- searches for all fields");
		}
		
		return  searchCrit;
	}
	
	//searches the respective person, return true if it finds it
	private void checkMenu() {
		String inputNumber;
		srchCrit searchCrit;
		String[] participant = {"", "", "", ""};
		
		//prints the search by outpt
		System.out.println("Se cauta o persoana…");
		modIdentificare();
		
		inputNumber = sc.nextLine();
		
		//changes the participant array
		//saves the search by criteria
		searchCrit = idCases(inputNumber, participant);
		
		//creates aa guest to search by from the participnat stringarray
		//only with the neccesary fields
		//other fiels are empty strings
		Guest searchingParticipant = new Guest(participant[0],participant[1],participant[2],participant[3]);
		
		//calls the GuestsList methods and outputs the result
		if(list.searchParticipantShowParticipant(searchingParticipant, searchCrit)) {
			System.out.println("Participantul este pe lista!");
		} else
			System.out.println("Participantul nu este pe lista!");
		
		System.out.println();
			
	}
	
	private void removeMenu() {
		String inputNumber;
		srchCrit search;
		String[] participant = {"", "", "", ""};
	
		//prints the search by outpt
		System.out.println("Se sterge o persoana existenta din lista…");
		modIdentificare();
		
		inputNumber = sc.nextLine();
		
		//changes the participant array
		//saves the search by criteria
		search = idCases(inputNumber, participant);
		
		//creates aa guest to search by from the participnat stringarray
		//only with the neccesary fields
		//other fiels are empty strings
		Guest searchingParticipant = new Guest(participant[0],participant[1],participant[2],participant[3]);
		
		//calls the GuestsList methods and outputs the result
		if(list.remove(searchingParticipant, search))
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
		else
			System.out.println("Nu a fost gasita persoana dupa acele criterii");
		
		
		System.out.println();
	}
	
	private void updateMenu() {

		String inputNumber;
		srchCrit serchCrit, fieldCrit = srchCrit.LASTNAME;
		String[] participant = {"", "", "", ""};
		
		//prints the search by outpt
		System.out.println("Se actualizeaza detaliile unei persoane…");
		modIdentificare();
		
		inputNumber = sc.nextLine();
		
		//changes the participant array
		//saves the search by criteria		
		serchCrit = idCases(inputNumber, participant);
		
		//creates aa guest to search by from the participnat stringarray
		//only with the neccesary fields
		//other fiels are empty strings		
		Guest searchingParticipant = new Guest(participant[0],participant[1],participant[2],participant[3]);
		
		
		//if the person is not in the lsit it ends now to not ask for the update info
		if(!list.searchParticipant(searchingParticipant, serchCrit)) {
			System.out.println("Persoana nu exista in liste");
			return;
		}
		
		//outp to ask for update info
		System.out.println("Alege campul de actualizat, tastand:");
		System.out.println("\"1\" - Nume");
		System.out.println("\"2\" - Prenume");
		System.out.println("\"3\" - Email");
		System.out.println("\"4\" - Numar de telefon (format \"+40733386463\")");
		
		inputNumber = sc.nextLine();
		String update;
		
		//chosses criteria for update field
		//outp messages
		switch(inputNumber) {
		case "1":
			fieldCrit = srchCrit.LASTNAME;
			System.out.println("Introduceti numele de familie:");
			break;
		case "2":
			fieldCrit = srchCrit.FIRSTNAME;
			System.out.println("Introduceti prenumele:");
			break;
		case "3":
			fieldCrit = srchCrit.EMAIL;
			System.out.println("Introduceti email:");
			break;
		case "4":
			fieldCrit = srchCrit.PHONE;
			System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
			break;
		default:
			System.out.println("Invalid Input -- will update last name");	
		}
		
		//update String
		update = sc.nextLine();
		
		//calls the GuestsList methods and outputs the result
		if(list.update(searchingParticipant, update, serchCrit, fieldCrit))
			System.out.println("Actualizarea a fost realizata cu succes");
		else
			System.out.println("Actualizarea NU a fost realizata cu succes");
		
		System.out.println();
	}
	
	private void guestMenu() {
		System.out.println("Participant List: ");
		list.participantsList();
	}
	
	private void waitingListMenu() {
		System.out.println("Waiting List: ");
		list.waitingList();
	}
	
	private void availableMenu() {
		System.out.println("Numarul de locuri ramase: " + list.getNoFreeSlots());
	}
	
	private void guestNoMenu() {
		System.out.println("Numarul de participanti: " + list.getNoParticipants());
	}
	
	private void waitListNoMenu() {
		System.out.println("Numarul total de persoane pe lista de asteptare: " + list.getNoWaitingList());
	}
	
	private void subscribeNoMenu() {
		System.out.println("Numarul total de persoane: " + list.getNoTotal());
	}
	
	private void searchMenu() {
		System.out.println("Introdu sirul de caractere dupa care sa cautam:");
		String sequence = sc.nextLine();
		
		ArrayList<Guest> foundGuests = list.partialSearch(sequence);
		
		if(foundGuests.size() == 0)
			System.out.println("Nu am gasit pe nimeni dupa acele cautari");
		
		for(int i = 0; i < foundGuests.size(); i += 2) {
			System.out.print((i + 2) / 2 + ". ");
			fieldCat(foundGuests.get(i + 1), foundGuests.get(i));
			
			System.out.println(foundGuests.get(i));
		}
	}
	
	//helper method for search menu
	private void fieldCat(Guest guest, Guest guestInfo) {
		
		String onField = "X";
		
		if(guest.getLastName().equals(onField)) {
			System.out.print("In campul nume de familie: ");
			System.out.println(guestInfo.getLastName());
		} else if(guest.getFirstName().equals(onField)) {
			System.out.print("In campul prenume: ");
			System.out.println(guestInfo.getFirstName());
		} else if(guest.getEmail().equals(onField)) {
			System.out.print("In campul email: ");
			System.out.println(guestInfo.getEmail());
		}else if(guest.getPhoneNumber().equals(onField)) {
			System.out.print("In campul nume de familie: ");
			System.out.println(guestInfo.getPhoneNumber());
		}
		
	}

	private void updateSizeMenu() {
		System.out.println("Introduceti numarul de locuri disponibile: ");
		int newNumber = sc.nextInt();
		sc.nextLine();
		list.updateNoSlots(newNumber);
		System.out.println("Schimbarea numarului de participanti realizat cu succes");
		System.out.println();
	}
	
	private void addDefMenu(){
		
		Guest guest = new Guest("nume" + defNumar, "prenume" + defNumar, "mail@email" + defNumar, "0755555555" + defNumar);
		defNumar = defNumar + 1;
		
		list.add(guest);
		System.out.println("Added " + (defNumar - 1) + " default participant");
		System.out.println();
		
	}
	
	private void showAllMenu() {
		guestMenu();
		waitingListMenu();
	}
}

