package calculadora;

import java.util.Scanner;

public class Calculadora {

private float n1, n2, resultado; //variaveis == privadas para essa classe
Scanner LerNumero = new Scanner(System.in); //cria��o de objetos para leitura de dados 

/*private void EntradaDados() {
	
	System.out.println("Digite o primeiro n�mero: ");
	nm1 = LerNumero.nextFloat(); 
	System.out.println("Digite o segundo n�mero: ");
	nm2 = LerNumero.nextFloat();
	
}*/

public float Somar(float n1,float n2) { //algo publico = pode ser compartilhado com outras classes
	
	/*System.out.println("Digite o primeiro n�mero: ");
	nm1 = LerNumero.nextFloat(); 
	System.out.println("Digite o segundo n�mero: ");
	nm2 = LerNumero.nextFloat();*/	
	
	//EntradaDados();	
	resultado=n1+n2;
	return resultado;
	//System.out.println("O resultado �: " +resultado);
	
}
public float Subtrair(float n1,float m2){
	//EntradaDados();	
	resultado=n1-n2;
	//System.out.println("O resultado �: " +resultado);	
	return resultado;
	
}
public float Multiplicar(float n1,float n2){
	//EntradaDados();
	resultado=n1*n2;
	//System.out.println("O resultado �: " +resultado);	
	return resultado;
	
}
public float Dividir(float n1,float n2){
	//EntradaDados();
	resultado=n1/n2;
	//System.out.println("O resultado �: " +resultado);	
	return resultado;
	
}
}
