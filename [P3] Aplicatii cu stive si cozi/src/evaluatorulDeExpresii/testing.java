package evaluatorulDeExpresii;

import java.util.ArrayList;

public class testing {

	public static void main(String[] args) {
		ExpresionEvaluator calculator = new ExpresionEvaluator();
		String input = "33+(2+1)*2^3^2-8/(5-1*2/2)";
		String[] inputConverted = calculator.convert(input);
		System.out.println(calculator.evaluate(inputConverted));
		
		
	}
	
	public static String[] makeStringArray(String s) {
		ArrayList<String> sol = new ArrayList<>();
		StringBuilder stringBuild = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {

			if(s.charAt(i) == ' ') {
				sol.add(stringBuild.toString());
				stringBuild.delete(0, stringBuild.length());
			} else {
				stringBuild.append(s.charAt(i));
			}
		}
		
		sol.add(stringBuild.toString());
		
		String[] solution = new String[sol.size()];
		for(int i = 0; i < solution.length; i++) {
			solution[i] = sol.get(i);
		}
		return solution;
	}

}
