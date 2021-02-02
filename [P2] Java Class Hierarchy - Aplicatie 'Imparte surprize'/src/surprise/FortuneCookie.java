package surprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FortuneCookie implements ISurprize{

	private String fortune;
	
	private static String zicala1 = "Daca suntem in directia buna, trebuie doar sa mergem inainte. — Proverbe budiste";
	private static String zicala2 = "Daca vantul nu sufla în panze, vasleste! — Proverbe latine";
	private static String zicala3 = "Prostia si ingamfarea sunt doua surori care foarte rar se despart. — Proverbe arabe";
	private static String zicala4 = "Daca nu inveti cat esti tanar, iti vei petrece restul zilelor plangandu-te de esecuri. — Proverbe chinezesti";
	private static String zicala5 = "Pe leul mort si iepurii il insulta. — Proverbe latine";
	private static String zicala6 = "O viata fara dragoste este asemenea unui an fara primavara. — Proverbe suedeze";
	private static String zicala7 = "Secretul succesului: cazi de sapte ori, te ridici de opt. — Proverbe chinezesti";
	private static String zicala8 = "Cel care zambeste in loc sa se infurie va fi intotdeauna mai puternic. — Proverbe japoneze";
	private static String zicala9 = "Prost sa fii, noroc sa ai. — Proverbe romanesti";
	private static String zicala10 = "Decat sa injuri intunericul, mai bine aprinde o lumanare. — Proverbe chinezesti";
	private static String zicala11 = "Perlele nu se afla pe malul oceanului. Daca vrei una, trebuie sa te scufunzi dupa ea. — Proverbe chinezesti";
	private static String zicala12 = "Daca tot a luat foc casa, macar sa ne incalzim. — Proverbe italiene";
	private static String zicala13 = "In tara orbilor, cel cu un ochi este imparat. — Proverbe romanesti";
	private static String zicala14 = "Vointa inimii da aripi picioarelor. — Proverbe romanesti";
	private static String zicala15 = "Doamne, apara-ma de prieteni, ca de dusmani ma feresc singur. — Proverbe romanesti";
	private static String[] zicaleVector = {zicala1, zicala2, zicala3, zicala4, zicala5, zicala6, zicala7, zicala8, zicala9, zicala10, zicala11, zicala12, zicala13, zicala14, zicala15};
	private static ArrayList<String> zicale = new ArrayList<String>(Arrays.asList(zicaleVector));
	
	private FortuneCookie(String fortune) {
		this.fortune = fortune;
	}
	
	public static FortuneCookie generate() {
		Random random = new Random();
		return new FortuneCookie(zicale.get(random.nextInt(zicale.size())));
	}
	
	public static void addZicala(String zicala) {
		zicale.add(zicala);
	}
	
	@Override
	public void enjoy() {
		System.out.println(fortune);
	}
	
	@Override
	public String toString() {
		return fortune;
	}
}
