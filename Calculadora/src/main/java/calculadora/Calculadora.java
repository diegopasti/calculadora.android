package calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import calculadora.utils.ReportLog;

public class Calculadora {
	
	private List<String> operadores;
	private List<String> numeros;
	private ReportLog log;
		
	public Calculadora(){
		log = new ReportLog();
		adicionarOperadores();
		adicionarNumeros();
	}
	
	public Double calcular(String exp){
		return analisarExpressao(exp); 
	}
	
	private Double analisarExpressao(String exp){
		log.print("expressao: "+exp);
		
		if(exp.contains("*")) {
			exp = resolverMultiplicacao(exp);
			log.print("Multiplicada:  "+exp);
		}
		
		if(exp.contains("/")) {
			exp = resolverDivisao(exp);
			log.print("Dividida:      "+exp);
		}
	    
		if(exp.contains("+")) {
			exp = resolverSoma(exp);
			log.print("Somada:        "+exp);
		}
		
		if(exp.contains("-")) {
			exp = resolverSubracao(exp);
			log.print("Subtraida:     "+exp);	
		}
	    
		Double resultado;
		
		if(!exp.equals("ERRO")){
			resultado = Double.parseDouble(exp);	
		} else{
			resultado = null;
		}
		 
		return resultado;
	}
	
	private String analisarToken(String group){
		String[] tokens = group.split("\\*|/|\\+|-");
		Double v1 = Double.parseDouble(tokens[0]);
		Double v2 = Double.parseDouble(tokens[1]);
		
		String resultado = "";
		if(group.contains("*")){
			resultado = ""+(v1*v2);
		} else if(group.contains("/")){
			if(v2!=0){
				resultado = ""+(v1/v2);	
			} else{
				resultado = "ERRO";
			}			
		}
		
		else if(group.contains("+")){
			resultado = ""+(v1+v2);
		} else if(group.contains("-")){
			resultado = ""+(v1-v2);
		}
		
		return resultado;
	}
	
	private void adicionarOperadores(){
		operadores = new ArrayList<String>();
		operadores.add("+");
		operadores.add("-");
		operadores.add("*");
		operadores.add("/");
	}
	
	private void adicionarNumeros(){
		numeros = new ArrayList<String>();
		numeros.add("0");
		numeros.add("1");
		numeros.add("2");
		numeros.add("3");
		numeros.add("4");
		numeros.add("5");
		numeros.add("6");
		numeros.add("7");
		numeros.add("8");
		numeros.add("9");
	}
	
	private String resolverMultiplicacao(String exp){
		return resolver(exp,"\\d+\\*\\d+");
	}
	
	private String resolverDivisao(String exp){
		return resolver(exp,"\\d+/\\d+");
	}
	
	private String resolverSoma(String exp){
		return resolver(exp,"\\d+\\+\\d+");
	}
	
	private String resolverSubracao(String exp){
		return resolver(exp,"\\d+\\-\\d+");
	}
	
	private String resolver(String exp, String regexp){
		Pattern padrao = Pattern.compile(regexp);  
		Matcher matcher = padrao.matcher(exp); 
		
	    int pos = 0;  
	    while (matcher.find(pos)){  
	    	String token =  matcher.group();
	    	
	    	if(token.contains("ERRO")){
	    		exp = "ERRO";
	    		break;
	    	}
	    	
	    	String resultado = analisarToken(token);
	    	String resto = resultado.substring(resultado.lastIndexOf("."));
	    		    	
	    	if(resto.equals(".0")){
	    		resultado = resultado.replace(resto, "");
	    	
	    	} else{
	    		log.print("Ve a parte fracionaria: "+resto);
	    	}
	    	
	    	exp = exp.replace(token, resultado);	
	    	pos = matcher.end();    
	    }
	    return exp;
	}
}
