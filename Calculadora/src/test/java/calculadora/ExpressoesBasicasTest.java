package calculadora;

import calculadora.Calculadora;
import calculadora.MainActivity;
import android.widget.Button;
import android.widget.EditText;
import empresa.exemplos.calculadora.R;

public class ExpressoesBasicasTest extends CalculadoraTest {
	
	public ExpressoesBasicasTest() {
		super(MainActivity.class);
	}

	public ExpressoesBasicasTest(Class<MainActivity> activityClass) {
		super(activityClass);
	}
	
	@Override
    protected void setUp() throws Exception {
		activity = getActivity();		
		calculadora = new Calculadora();
		editTextResultado = (EditText) activity.findViewById(R.id.editTextResultado);
		btResultado = (Button) activity.findViewById(R.id.buttonFuncaoIgual);
	}
	
	public void testSomaNumerosInteirosPositivos(){
		
		getActivity().runOnUiThread(
			new Runnable() {
				public void run() {
					String resultado = "";
					btFuncao = (Button) activity.findViewById(R.id.buttonFuncaoSomar);
					Double valor = digitarNumeroAleatorio();
					btFuncao.performClick();
					valor = valor + digitarNumeroAleatorio();
					btResultado.performClick();
					resultado = valor.toString();
					if(resultado.contains(".0")){
						resultado = resultado.replace(".0", "");
					}
					
					assertEquals(resultado,editTextResultado.getText().toString());
			    }
			}
		);
	}
	
	public void testSubtrairNumerosInteirosPositivos(){
		
		getActivity().runOnUiThread(
			new Runnable() {
				public void run() {
					String resultado = "";
					btFuncao = (Button) activity.findViewById(R.id.buttonFuncaoSubtrair);
					Double valor = digitarNumeroAleatorio();
					btFuncao.performClick();
					valor = valor - digitarNumeroAleatorio();
					btResultado.performClick();
					resultado = valor.toString();
					if(resultado.contains(".0")){
						resultado = resultado.replace(".0", "");
					}
					
					assertEquals(resultado,editTextResultado.getText().toString());
			    }
			}
		);
	}
	
	public void testMultiplicarNumerosInteirosPositivos(){
		
		getActivity().runOnUiThread(
			new Runnable() {
				public void run() {
					String resultado = "";
					btFuncao = (Button) activity.findViewById(R.id.buttonFuncaoMultiplicar);
					Double valor = digitarNumeroAleatorio();
					btFuncao.performClick();
					valor = valor * digitarNumeroAleatorio();
					btResultado.performClick();
					resultado = valor.toString();
					if(resultado.contains(".0")){
						resultado = resultado.replace(".0", "");
					}
					
					assertEquals(resultado,editTextResultado.getText().toString());
			    }
			}
		);
	}
	
	public void testDividirNumerosInteirosPositivos(){
		
		getActivity().runOnUiThread(
			new Runnable() {
				public void run() {
					String resultado = "";
					Double denominador;
					btFuncao = (Button) activity.findViewById(R.id.buttonFuncaoDividir);
					Double valor = digitarNumeroAleatorio();
					btFuncao.performClick();
					
					denominador = digitarNumeroAleatorio();
					if(denominador!=0.0){
						valor = valor /denominador;	
					}
					else{
						denominador = 1.0;
					}
					 
					btResultado.performClick();
					resultado = valor.toString();
					if(resultado.contains(".0")){
						resultado = resultado.replace(".0", "");
					}
					
					assertEquals(resultado,editTextResultado.getText().toString());
			    }
			}
		);
	}
	

}
