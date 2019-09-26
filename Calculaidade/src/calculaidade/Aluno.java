package calculaidade;

import java.util.Scanner;

public class Aluno {
	
	private int idade, anonascimento;
	private String nome;
	
	Scanner LerTeclado = new Scanner(System.in);
	
	public Aluno(){
		System.out.println("Este programa calcula sua Idade!!");
	}	
	
	public void LerNome(){
		
		System.out.println("Digite seu nome: ");
		nome = LerTeclado.nextLine(); 	
	}
	
	public void LerAno(){
		
	System.out.println("Digite seu ano de nascimento: ");
	anonascimento = LerTeclado.nextInt();
	
	idade = 2018 - anonascimento; 
	System.out.println(nome + " você tem " + idade + " anos");
	if (idade >= 18){		
		System.out.println(" Você é maior de idade");
	}
	else{		
		System.out.println(" Você é menor de idade");		
	}
	
	}

}
