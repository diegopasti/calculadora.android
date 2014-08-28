package calculadora;

import java.util.Random;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import calculadora.Calculadora;
import calculadora.MainActivity;
import calculadora.utils.Recursos;

public class CalculadoraTest extends ActivityInstrumentationTestCase2<MainActivity> {
	protected Activity activity;
	protected Button btNumero; 
	protected Button btFuncao, btResultado, btVirgula;
	protected EditText editTextResultado;
	
	protected Calculadora calculadora;
	
	public CalculadoraTest() {
		super(MainActivity.class);
	}
	
	public CalculadoraTest(Class<MainActivity> activityClass) {
		super(activityClass);
	}
	
	
	public Double digitarNumeroAleatorio(){
		int numDigitos = new Random().nextInt(5)+1;
		String valor="";
		
		// Compondo o primeiro numero aleatorio
		for(int k=0; k<numDigitos; k++){
			btNumero = (Button) activity.findViewById(getIdentificadorBotaoAleatorio());
			valor = valor+btNumero.getText();
			// Pressionando o numero do digito
			btNumero.performClick();
		}
		
		System.out.println("Veja o valor digitado: "+valor);
		return Double.parseDouble(valor);
	}
	
	
	public Double digitarNumero(int num){
		String valor="";
		int id=-1;
	
		switch(num){
		case 0:
			id = Recursos.NUMERO0.getId();
			break;
		case 1:
			id = Recursos.NUMERO1.getId();
			break;
		case 2:
			id = Recursos.NUMERO2.getId();
			break;
		case 3:
			id = Recursos.NUMERO3.getId();
			break;
		case 4:
			id = Recursos.NUMERO4.getId();
			break;
		case 5:
			id = Recursos.NUMERO5.getId();
			break;
		case 6:
			id = Recursos.NUMERO6.getId();
			break;
		case 7:
			id = Recursos.NUMERO7.getId();
			break;
		case 8:
			id = Recursos.NUMERO8.getId();
			break;
		case 9:
			id = Recursos.NUMERO9.getId();
			break;
		default:
			id=0;
			break;
		}
		
		btNumero = (Button) activity.findViewById(id);
		btNumero.performClick();
		valor = valor+btNumero.getText();
		
		System.out.println("Veja o valor digitado: "+valor);
		return Double.parseDouble(valor);
	}
	
	
	public int getIdentificadorBotaoAleatorio(){
		
		// Tinha tentado fazer com reflection, mas
		// n�o consegui acessar o campo e invocar o m�todo
		// n�o � dificil de fazer isso.
		
		int numero = new Random().nextInt(9);
		int id = -1;
		
		switch(numero){
			case 0:
				id = Recursos.NUMERO0.getId();
				break;
			case 1:
				id = Recursos.NUMERO1.getId();
				break;
			case 2:
				id = Recursos.NUMERO2.getId();
				break;
			case 3:
				id = Recursos.NUMERO3.getId();
				break;
			case 4:
				id = Recursos.NUMERO4.getId();
				break;
			case 5:
				id = Recursos.NUMERO5.getId();
				break;
			case 6:
				id = Recursos.NUMERO6.getId();
				break;
			case 7:
				id = Recursos.NUMERO7.getId();
				break;
			case 8:
				id = Recursos.NUMERO8.getId();
				break;
			case 9:
				id = Recursos.NUMERO9.getId();
				break;
			default:
				id = Recursos.NUMERO0.getId();
				break;
		}
		
		return id;
	}
}
