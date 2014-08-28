package calculadora;

import android.widget.Button;
import android.widget.EditText;
import calculadora.Calculadora;
import calculadora.MainActivity;
import empresa.exemplos.calculadora.R;

public class ExpressoesInvalidasTest extends CalculadoraTest{

	public ExpressoesInvalidasTest() {
		super(MainActivity.class);
	}

	public ExpressoesInvalidasTest(Class<MainActivity> activityClass) {
		super(activityClass);
	}
	
	@Override
    protected void setUp() throws Exception {
		activity = getActivity();		
		calculadora = new Calculadora();
		editTextResultado = (EditText) activity.findViewById(R.id.editTextResultado);
		btResultado = (Button) activity.findViewById(R.id.buttonFuncaoIgual);
	}
	
	public void testDividirNumerosInteirosPorZero(){
		
		getActivity().runOnUiThread(
			new Runnable() {
				public void run() {
					String resultado = "";
					btFuncao = (Button) activity.findViewById(R.id.buttonFuncaoDividir);
					digitarNumeroAleatorio();
					btFuncao.performClick();
					digitarNumero(0);
					
					btResultado.performClick();
					resultado = "ERRO";
									
					assertEquals(resultado,editTextResultado.getText().toString());
			    }
			}
		);
	}
	
}
