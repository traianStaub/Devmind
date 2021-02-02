package guest;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class GuestList {

	private ArrayList<Guest> participantList;
	private ArrayList<Guest> waitingList = new ArrayList<Guest>();
	private int noMaxParticipants;
	private srchCrit search = srchCrit.NAME;
	
	
	//constructor
	public GuestList(int locuriDisponibile) {
		participantList = new ArrayList<Guest>(locuriDisponibile);
		noMaxParticipants = locuriDisponibile;
	}
	
	//metode
	public int add(Guest guest) {
		
		if(searchParticipationListForAdd(guest) != -1)
			return -1;
		
		int searchingWaiting = searchWaitingListForAdd(guest);
		if(searchingWaiting != -1)
			return searchingWaiting + 1;
		
		if(participantList.size() == noMaxParticipants) {
			waitingList.add(guest);
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " + waitingList.size() + ". Te vom notifica daca un loc devine disponibil");
		} else {
			participantList.add(guest);
			System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");			
		}

		
		return 0;
	}
	
	public boolean searchParticipant(Guest participant, srchCrit search) {
		
		this.search = search;
		int pIndex = searchParticipationList(participant);
		if(pIndex != -1)
			return true;
		pIndex = searchWaitingList(participant);
		if(pIndex != -1)
			return true;
		
		return false;
	}
	
	public boolean searchParticipantShowParticipant(Guest participant, srchCrit search) {
		
		this.search = search;
		int pIndex = searchParticipationList(participant);
		
		if(pIndex != -1) {
			System.out.println(participantList.get(pIndex));
			return true;
		}
		
		pIndex = searchWaitingList(participant);
		if(pIndex != -1) {
			System.out.println(waitingList.get(pIndex));
			return true;
		} 
		
		return false;
	}
	
	public boolean remove(Guest participant, srchCrit search) {
		
		this.search = search;
		int pIndex = searchParticipationList(participant);
		
		if(pIndex == -1) 
			return false;
		else {
			participantList.remove(pIndex);
			
			if(waitingList.size() > 0) {
				participantList.add(waitingList.get(0));
				waitingList.remove(0);
			}
			
			return true;
		}
	}
	
	public boolean update(Guest participant, String update, srchCrit search, srchCrit toUpdate) {
		
		this.search = search;
		
		if(update == null) {
			System.out.println("Can't update with null string");
			return false;
		}
			
		//searching and updating participant list
		int pIndex = searchParticipationList(participant);
		if(pIndex != -1) {
			searchUpdate(participantList, pIndex, update, toUpdate);
			return true;
		}
		
		//searching and updating participant list
		pIndex = searchWaitingList(participant);
		if(pIndex != -1) {
			searchUpdate(waitingList, pIndex, update, toUpdate);
			return true;
		}
		
		return false;
	}
	
	//this method searches and updates according to the toUpdate parameter
	public void searchUpdate(ArrayList<Guest> list, int pIndex, String update, srchCrit toUpdate) {
		switch(toUpdate) {
		case FIRSTNAME:
			list.get(pIndex).setFirstName(update);
			break;
		case LASTNAME:
			list.get(pIndex).setLastName(update);
			break;
		case PHONE:
			list.get(pIndex).setPhoneNumber(update);
			break;
		case EMAIL:
			list.get(pIndex).setEmail(update);
			break;
		default:
		}
	}
	
	public void participantsList() {
		for(int i = 0; i < participantList.size(); i++) {
			System.out.println((i + 1) + ". " + participantList.get(i));
		}
	}
	
	public void waitingList() {
		for(int i = 0; i < waitingList.size(); i++) {
			System.out.println((i + 1) + ". " + waitingList.get(i));
		}
	}
	
	public int getNoFreeSlots() {
		return noMaxParticipants - participantList.size();
	}
	
	public int getNoParticipants() {
		return participantList.size();
	}
	
	public int getNoWaitingList() {
		return waitingList.size();
	}
	
	public int getNoTotal() {
		return getNoParticipants() + getNoWaitingList();
	}
	
	public ArrayList<Guest> partialSearch(String sequence) {
		
		//each guest saved here is followed by a guest that has empty STring in all fields 
		//except for the one where the sequence was found that has "X"
		ArrayList<Guest> foundParticipants = new ArrayList<Guest>(); 
		
		//participant List
		for(int i = 0; i < participantList.size(); i++) {
			compareEachField(sequence.trim(), participantList.get(i), foundParticipants);
		}
		
		//waiting List
		for(int i = 0; i < waitingList.size(); i++) {
			compareEachField(sequence.trim(), waitingList.get(i), foundParticipants);
		}
		
		return foundParticipants;
	}
	
	//compares a sequance to a String ad return true if the sequence is in the String
	private boolean equalsSequence(String s, String compareTo) {
		
		int sizeS = s.length();
		int sizeCompTo = compareTo.length();
		
		//if the sequnce is bigger then the word returns false
		if(sizeS > sizeCompTo)
			return false;
		
		//compoares the first letter of the sequence with each one from the compareTo String
		for(int i = 0; i < sizeCompTo; i++) {
			
			//it tries to compare bigger and bigger sizes if the firs one is a match
			//if they dont fit the first loop continues
			for(int j = 0; j < sizeS; j++) {	
				
				if(Character.toLowerCase(s.charAt(j)) != Character.toLowerCase(compareTo.charAt(i + j)))
					break;
				else if(j == sizeS - 1)
					return true;
			}
		}
		
		return false;
	}
	
	//uses the above function to compare with every field from guest and if they match place it in storageList
	private boolean compareEachField(String s, Guest toCompare, ArrayList<Guest> storageList) {
		
		if(equalsSequence(s, toCompare.getLastName())) {
			storageList.add(toCompare);
			storageList.add(new Guest("X", "", "", ""));
			return true;
		} else if(equalsSequence(s, toCompare.getFirstName())) {
			storageList.add(toCompare);
			storageList.add(new Guest("", "X", "", ""));
			return true;
		} else if(equalsSequence(s, toCompare.getEmail())) {
			storageList.add(toCompare);
			storageList.add(new Guest("", "", "X", ""));
			return true;
		} else if(equalsSequence(s, toCompare.getPhoneNumber())) {
			storageList.add(toCompare);
			storageList.add(new Guest("", "", "", "X"));
			return true;
		}
			
			 
		
		return false;
	}

	//------------------------
	//my experiment
	//updates the max number of participants by the new number
	// returns true if it can be done
	//false if the new number is smaller or the same
	public boolean updateNoSlots(int newMaxNumber) {
		
		if(noMaxParticipants == newMaxNumber || newMaxNumber <= 0)
			return false;
		else if(noMaxParticipants < newMaxNumber) {
			
			while(participantList.size() < newMaxNumber) {
			
				if(waitingList.size() > 0) {
					participantList.add(waitingList.get(0));
					waitingList.remove(0);
				} else {
					break;
				}
			}
			
		} else if(noMaxParticipants > newMaxNumber){
			
			while(newMaxNumber < participantList.size()) {
					
				waitingList.add(0, participantList.get(participantList.size() - 1));
				participantList.remove(participantList.size() - 1);
			}
			
				
		}
		
		noMaxParticipants = newMaxNumber;
		return true;
	}

	
	//-----------------------------------------------
	//private methods
	//if the guest is on the list return the index
	//if it is NOT on the list returns -1
	private int searchParticipationList(Guest participant) {
		
		for(int i = 0; i < participantList.size(); i++) {
			if(searchingfuntion(participantList.get(i), participant))
				return i;
		}
		
		return -1;
	}
	
	//if the guest is on the list return the index
	//if it is NOT on the list returns -1
	private int searchWaitingList(Guest participant) {
		
		for(int i = 0; i < waitingList.size(); i++) {
			if(searchingfuntion(waitingList.get(i), participant))
				return i;
		}
		
		return -1;
	}
	
	//search for the add method
	private int searchParticipationListForAdd(Guest participant) {
		
		for(int i = 0; i < participantList.size(); i++) {
			
			if(participantList.get(i).equalsName(participant))
				return i;
			
			if(participantList.get(i).equalsPhone(participant))
				return i;
			
			if(participantList.get(i).equalsEmail(participant))
				return i;
		}
		
		return -1;
	}
	
	private int searchWaitingListForAdd(Guest participant) {
		
		for(int i = 0; i < waitingList.size(); i++) {
			
			if(waitingList.get(i).equalsName(participant))
				return i;
			
			if(waitingList.get(i).equalsPhone(participant))
				return i;
			
			if(waitingList.get(i).equalsEmail(participant))
				return i;
		}
		
		return -1;
	}
	
	//witch method is used to search the guestList Array
	//it can be:
	//search by Email - equalsEmail
	//search by Phone - equalsPhone
	// search by Name - equalsName
	private boolean searchingfuntion(Guest fromList, Guest toSearch) {
		
		switch(search) {
			case EMAIL:
				return fromList.equalsEmail(toSearch);
			case PHONE:
				return fromList.equalsPhone(toSearch);
			case NAME:
				return fromList.equalsName(toSearch);
			default:
				return fromList.equals(toSearch);
		}
		
	}
	
	//forTesting
	public void showWaiting() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < waitingList.size(); i++) {
			sb.append(waitingList.get(i).nameString() + ", ");
		}
		
		System.out.println(sb.toString());
	}
	
	public void showParticipationList() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < participantList.size(); i++) {
			sb.append(participantList.get(i).nameString() + ", ");
		}
		
		System.out.println(sb.toString());
	}
	
	public void showCase() {
		
		System.out.print("partici list: ");
		showParticipationList();
		System.out.println();
		System.out.print("waiting list: ");
		showWaiting();
	}
	
}