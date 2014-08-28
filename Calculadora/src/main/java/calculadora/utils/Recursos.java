package calculadora.utils;

import empresa.exemplos.calculadora.R;

public enum Recursos {
	NUMERO0(R.id.buttonNumero0),
	NUMERO1(R.id.buttonNumero1), 
	NUMERO2(R.id.buttonNumero2), 
	NUMERO3(R.id.buttonNumero3), 
	NUMERO4(R.id.buttonNumero4), 
	NUMERO5(R.id.buttonNumero5), 
	NUMERO6(R.id.buttonNumero6), 
	NUMERO7(R.id.buttonNumero7), 
	NUMERO8(R.id.buttonNumero8),
	NUMERO9(R.id.buttonNumero9);
	
	
	private int path;
	
	Recursos(int path){
		this.path = path; 
	}
	
	public int getId(){
		return path;
	}

}
