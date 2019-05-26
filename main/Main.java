package main;

import criptografia.*;

public class Main 
{
	public static void main(String[] args) 
	{		

		String palavra = "fimdesemana";
		String chave  = "caro";
		
		CifraDeColunas cdc = new CifraDeColunas(chave);
		
		String cifra = cdc.cifrar(palavra);
		
		System.out.println("Cifrado: " + cifra); 
						
	}

}
