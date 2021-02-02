package main;
import guest.GuestList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//RealStart
		Scanner scanner = new Scanner(System.in);
		String input;
		int locuriDiscponibile = inpuListSize(scanner);
		
		
	 	GuestList list = new GuestList(locuriDiscponibile);
	 	UserInterface ui = new UserInterface(list, scanner);
	 	

		while(true) {
			
			System.out.println("----------------------------------------------------");
			System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			
			input = scanner.nextLine();
			
			if(ui.inputValidation(input) == Menus.FALSEINPUT) {
				System.out.println("Invalid Command");
				continue;
			} else {
				ui.changeMenu();
			}
			
		}
	}
	//askes the user for the input for the size of the list
	//if it s not a int it keeps asking until it gets an int
	public static int inpuListSize(Scanner scanner) {
		boolean inputNumber;
		String input;
		
		do {
			inputNumber = true;
			System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
			input = scanner.nextLine();
			
			char number = ' ';
			
			for(int i = 0; i < input.length(); i++) {
				number = input.charAt(i);
				
				if(number < '0' || number > '9') {
					inputNumber = false;
					break;
				}
			}
			
		}while(!inputNumber);
		
		return Integer.parseInt(input);
	}
	

}
