package calculadora;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	  Calculadora calc = new Calculadora();
	  //Calculadora calc1 = new Calculadora();
	  
	  float n1,n2, resultado;
	  
	  Scanner LerNumero = new Scanner(System.in);
	  System.out.println("Digite o primeiro n�mero: ");
	  n1 = LerNumero.nextFloat(); 
	  System.out.println("Digite o segundo n�mero: ");
	  n2 = LerNumero.nextFloat();
	  
	  resultado=calc.Somar(n1,n2);
	  System.out.println("O resultado �: " +resultado);
	  //System.out.println("O resultado �: "+calc.Somar(n1, n2));
	  
	  resultado=calc.Subtrair(n1,n2);
	  System.out.println("O resultado �: " +resultado);
	  
	  resultado=calc.Multiplicar(n1,n2);
	  System.out.println("O resultado �: " +resultado);
	  
	  resultado=calc.Dividir(n1,n2);
	  System.out.println("O resultado �: " +resultado);

	}

}
