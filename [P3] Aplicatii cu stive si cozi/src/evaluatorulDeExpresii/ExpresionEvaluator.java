package evaluatorulDeExpresii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ExpresionEvaluator {
	
	public String[] convert(String input) {
		String expresion = removeWhiteSpace(input);
		
		Deque<OperatorPower> simbols = new ArrayDeque<>();
		ArrayList<String> solution = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < expresion.length(); i++) {
			
			char tokenRead = expresion.charAt(i);
			
			//searches if it is a continuous string of numbers and it appends them to create the number and continues the for loop
			// -- kinda useles pentru ca exresion evaluator nu merge decat cu 1 digit number
			if(Character.isDigit(tokenRead)) {
				sb.append(tokenRead);
				
				//if it's the end or the next char is not a digit it adds the number to the solution array
				if(i == expresion.length() - 1 || !Character.isDigit(expresion.charAt(i + 1))) {
					solution.add(sb.toString());
					sb.delete(0, sb.length());
				}
				continue;
			}
			
			OperatorPower operator = OperatorPower.getSymbol(tokenRead);
			
			//the case for the left parenthesis
			if(operator.getSymbol() == '(') {
				simbols.push(operator);
				continue;
			}
			
			//case for the right parenthesis
			if(operator.getSymbol() == ')') {
				
				while(simbols.peek().getSymbol() != '(') {
					solution.add(Character.toString(simbols.pop().getSymbol()));
				}
				
				if(simbols.peek().getSymbol() == '(')
					simbols.pop();
				continue;
			}
			
			//case for operator
			while(//checks it the stack of simbols is empty
				  !simbols.isEmpty() &&
				  //checks if the simbols top has higher precedence or if equal are left asociated
				  (simbols.peek().getPrecedence() > operator.getPrecedence() ||
					(simbols.peek().getPrecedence() == operator.getPrecedence() && operator.getAssociativity() == 'l')) &&
				  //checks if it is not lef parenthesis
				  simbols.peek().getSymbol() != '(') {
				
				solution.add(Character.toString(simbols.pop().getSymbol()));
			}
			
			simbols.push(operator);

		}
		
		//empties the remaining operators in the stack
		while(!simbols.isEmpty()) {
			solution.add(Character.toString(simbols.pop().getSymbol()));
		}
		
		//turns it in a String[]
		String[] solutionArray = new String[solution.size()];
		
		for(int i = 0; i < solution.size(); i++) {
			solutionArray[i] = solution.get(i);
		}
		
		return solutionArray;
	}
	
	public int evaluate(String[] postfixForm) {
		Deque<Integer> numbers = new ArrayDeque<>();
		
		for(int i = 0; i < postfixForm.length; i++) {
			
			try {
				numbers.push(Integer.valueOf(postfixForm[i]));
			} catch(NumberFormatException e) {
				
				IOperation op;
				switch(postfixForm[i]) {
				case "+":
					op = (int op1, int op2) -> op2 + op1;
					break;
				case "-":
					op = (int op1, int op2) -> op2 - op1;
					break;
				case "*":
					op = (int op1, int op2) -> op2 * op1;
					break;
				case "/":
					op = (int op1, int op2) -> op2 / op1;
					break;
				case "^":
					op = (int op1, int op2) -> (int)Math.pow(op2, op1);
					break;
				default:
					System.out.println("UnknownSymbol" + postfixForm[i]);
					return 0;
				}
				
				if(numbers.size() < 2)
					return 0;
				
				numbers.push(op.operation(numbers.pop(), numbers.pop()));
			}
		}
		
		int solution = numbers.pop();
		
		if(!numbers.isEmpty()) {
			System.out.println("The stack still has values");
			return 0;
		}
		
		return solution;
	}
	
	public int evaluate(String input) {
		return evaluate(convert(input));
	} 
	
	public String removeWhiteSpace(String input) {
		StringBuilder sb = new StringBuilder();
		char c = ' ';
		for(int i = 0, n = input.length(); i < n; i++) {
			c = input.charAt(i);
			if(c != ' ') {
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
	
	private interface IOperation {
		int operation(int op1, int op2);
	}
	
}
