package calculadora.utils;

import android.util.Log;

public class ReportLog {
	
	private Boolean visibilidade=true;
	
	public void print(String msg){
		if(getVisibilidade()){
			Log. d("PROJETO", msg);
		}
	}
	
	public void setVisibilidade(Boolean valor){
		visibilidade = valor;
	}
	
	public Boolean getVisibilidade(){
		return visibilidade;
	}
	

}
