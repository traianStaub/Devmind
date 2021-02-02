package main;
import guest.*;
import java.util.Scanner;

public class Simulare {

	public static void main(String[] args) {
		
		Guest andrei = new Guest("andrei", "andrei", "andrei@gmail.com", "0712345nedl6781");
		Guest mihai = new Guest("mihai", "mihai", "mihanedli@gmail.com", "07123456782");
		Guest alexandru = new Guest("alexandru", "alexandru", "alexandru@gmail.com", "07123456783");
		Guest vlad = new Guest("vlanedld", "vlad", "vlad@gmail.com", "07123456784");
		Guest maria = new Guest("maria", "maria", "maria@gmail.com", "07123456785");
		Guest mihnea = new Guest("mihnea", "mihnea", "mihnea@gmail.com", "0712345676");
		Guest a = new Guest("a", "a", "anedl", "a");
		Guest b = new Guest("b", "bnedl", "b", "b");
		
		GuestList list = new GuestList(4);
		
		list.add(andrei);
		list.add(mihai);
		list.add(a);
		list.add(alexandru);
		list.add(vlad);
		list.add(maria);
		list.add(b);
		list.add(mihnea);
		
		list.showCase();
		Scanner scanner = new Scanner(System.in);
		scanner.close();
	}
}
