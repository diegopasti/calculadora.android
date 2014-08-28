package calculadora;

import java.util.ArrayList;
import java.util.List;
import empresa.exemplos.calculadora.R;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
//import android.app.ActionBar;
//import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.app_config) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		
		private Calculadora calculadora;
		
		private View rootView;
		
		private Button btNumero1, btNumero2, btNumero3, btNumero4, btNumero5, btNumero6, btNumero7, btNumero8, btNumero9, btNumero0; 
		private Button btFuncaoSomar, btFuncaoSubtrair, btFuncaoMultiplicar, btFuncaoDividir, btFuncaoIgual;
		//private Button btFuncaoVirgula;
		private EditText editTextResultado;
		
		public PlaceholderFragment() {
			calculadora = new Calculadora();
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			rootView = inflater.inflate(R.layout.fragment_main, container,	false);
			editTextResultado = (EditText) rootView.findViewById(R.id.editTextResultado);
			editTextResultado.setEnabled(false);
			
			construirBotoes();
			
			configurarBotoes();
			
			return rootView;
		}
		
		private void construirBotoes(){
			btNumero0 = (Button) rootView.findViewById(R.id.buttonNumero0);						
			btNumero1 = (Button) rootView.findViewById(R.id.buttonNumero1);
			btNumero2 = (Button) rootView.findViewById(R.id.buttonNumero2);
			btNumero3 = (Button) rootView.findViewById(R.id.buttonNumero3);
			btNumero4 = (Button) rootView.findViewById(R.id.buttonNumero4);
			btNumero5 = (Button) rootView.findViewById(R.id.buttonNumero5);
			btNumero6 = (Button) rootView.findViewById(R.id.buttonNumero6);
			btNumero7 = (Button) rootView.findViewById(R.id.buttonNumero7);
			btNumero8 = (Button) rootView.findViewById(R.id.buttonNumero8);
			btNumero9 = (Button) rootView.findViewById(R.id.buttonNumero9);
			
			btFuncaoSomar = (Button) rootView.findViewById(R.id.buttonFuncaoSomar);
			btFuncaoSubtrair = (Button) rootView.findViewById(R.id.buttonFuncaoSubtrair);
			btFuncaoMultiplicar = (Button) rootView.findViewById(R.id.buttonFuncaoMultiplicar);
			btFuncaoDividir = (Button) rootView.findViewById(R.id.buttonFuncaoDividir);
			
			btFuncaoIgual = (Button) rootView.findViewById(R.id.buttonFuncaoIgual);
		}
		
		private void configurarBotoes(){
			configurarNumeros();
			configurarOperadores();
			configurarResultado();
		}
		
		private void configurarNumeros(){
			List<Button> botoesNumeros = new ArrayList<Button>();
			botoesNumeros.add(btNumero0);
			botoesNumeros.add(btNumero1);
			botoesNumeros.add(btNumero2);
			botoesNumeros.add(btNumero3);
			botoesNumeros.add(btNumero4);
			botoesNumeros.add(btNumero5);
			botoesNumeros.add(btNumero6);
			botoesNumeros.add(btNumero7);
			botoesNumeros.add(btNumero8);
			botoesNumeros.add(btNumero9);
			
			for(final Button botao: botoesNumeros){
				botao.setOnClickListener( new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						editTextResultado.setText(editTextResultado.getText()+""+botao.getText());	
					}
				});
			}
		}
		
		private void configurarOperadores(){
			List<Button> botoesOperadores = new ArrayList<Button>();
			botoesOperadores.add(btFuncaoSomar);
			botoesOperadores.add(btFuncaoSubtrair);
			botoesOperadores.add(btFuncaoMultiplicar);
			botoesOperadores.add(btFuncaoDividir);
			
			for(final Button botao: botoesOperadores){
				botao.setOnClickListener( new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						if(!editTextResultado.getText().equals("")){
							editTextResultado.setText(editTextResultado.getText()+""+botao.getText());	
						}							
					}
				});
			}
		}
		
		private void configurarResultado(){
			btFuncaoIgual.setOnClickListener( new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(!editTextResultado.getText().equals("")){
						Double valor = calculadora.calcular(editTextResultado.getText().toString());
						String resultado = null;
						if(valor!=null){
							resultado = valor.toString();	
						}
						
						if(resultado!=null){
							if(resultado.contains(".0")){ // E QUANDO TIVE 1.05.. tem que validar se termina com .0
								resultado = resultado.replace(".0", "");
							}
							
							editTextResultado.setText(resultado.toString());	
						}
						else{
							editTextResultado.setText("ERRO");
						}	
					}							
				}
			});
		}
	}
}
