package evaluatorulDeExpresii;

public enum OperatorPower {

	ADD('+', 2, 'l'),
	SUB('-', 2, 'l'),
	DIV('/', 3, 'l'),
	MULT('*', 3, 'l'),
	POW('^', 4, 'r'),
	LPARENT('(', 0, ' '),
	RPARENT(')', 0, ' ');
	
	private char symbol;
	private int precedence;
	private char associativity;
	
	OperatorPower(char symbol, int precedence, char associativity) {
		this.symbol = symbol;
		this.precedence = precedence;
		this.associativity = associativity;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public int getPrecedence() {
		return precedence;
	}
	
	public int getAssociativity() {
		return associativity;
	}
	
	static OperatorPower getSymbol(char simbol) {
		for(OperatorPower op : OperatorPower.values()) {
			if(op.getSymbol() == simbol) {
				return op;
			}
		}
		
		return null;
	}
}
