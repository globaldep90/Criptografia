package criptografia;

public class CifraDeColunas
{		
	private String chave;
	private int tamanhoChave;
	
	public CifraDeColunas()
	{
		chave   = "";
		this.tamanhoChave = -1;
	}
	
	public CifraDeColunas(String chave) 
	{		
		this.chave   = chave;
		this.tamanhoChave = chave.length();
	}
	
	/**
	 * Método para tranformar chave em vetor de inteiros
	 */
	public int [] transformarChave(String chave)
	{
		int [] novaChave = new int [chave.length()];

		for(int y = 0; y < tamanhoChave; y++)
		{
			novaChave[y] = (int)chave.charAt(y);
		}//end for		

		return novaChave;

	}//end transformarChave()

 	public String cifrar(String palavra)
 	{ 		 		
		int [] novaChave = transformarChave(chave); //transformar chave em um array de inteiros	
		int tamanhoPalavra = palavra.length();
		
		//definir linhas e colunas da matriz
		double l = tamanhoPalavra/tamanhoChave;
		int linhas = 1 + (int)Math.ceil(l);
		int colunas = tamanhoChave;
		
		String novaPalavra = "";		
		char [][] matriz = criarTabela(palavra, linhas, colunas);		
		int posicao = -1;
				
		for(int y = 0; y < this.tamanhoChave; y++) 
		{
			posicao = obterPosicaoComMenorValor(novaChave);
			
			for(int z = 0; z < linhas; z++) 
			{ 
				if((int)matriz[z][posicao] != 0) 
				{
					novaPalavra = novaPalavra + matriz[z][posicao];
				}
			}//end for
			
			novaChave[posicao] = -1; //descartar posicao
			
		}//end for
				
		return novaPalavra;
		
 	}//end cifrar()
 	
 	public void printMatrix(char [][] matriz, int linhas, int colunas) 
 	{
 		for(int y = 0; y < linhas; y++) 
 		{
 			for(int z = 0; z < colunas; z++) 
 			{
 				System.out.print(" " + matriz[y][z]);
 			}
 			
 			System.out.println();
 		}
 	}

 	/**
 	 * Obter menor valor de um vetor, no caso, da chave.
 	 * 
 	 * @param vetor
 	 * @return
 	 */
 	public static int obterPosicaoComMenorValor(int [] vetor) 
 	{ 		
 		int menor = -1;
 		int posicao = -1;
 		
 		for(int y = 0; y < vetor.length; y++) 
 		{
 			if( menor < 0 || (menor >= vetor[y] && vetor[y] >= 0) ) 
 			{
 				menor = vetor[y];
 				posicao = y;
 			}//end if
 			System.out.println("Menor: " + menor);
 		}//end for
 		
 		return posicao;
 		
 	}//end obterPosicaoComMenorValor

 	/**
 	 * Método para criar tabela de caracteres.
 	 * 
 	 * @param {@code}palavra
 	 * @param {@code}linhas
 	 * @param {@code}colunas
 	 * @return
 	 */
	public static char [][] criarTabela(String palavra, int linhas, int colunas)
	{		
		char [][] matrix = new char[linhas][colunas];
		int contador = 0;
		int tamanhoPalavra = palavra.length();
		
		for(int y = 0; y < linhas; y++)
		{	
			for(int z = 0; z < colunas; z++)
			{
				matrix[y][z] = palavra.charAt(contador);
				if(contador+1 < tamanhoPalavra) { contador++; }
				else { z = colunas; y = linhas; }
			}//end for			
			
		}//end for
		
		return matrix;

	}//end criarTabela()

	public String decifrar(String palavra, int chave) 
	{		
		return palavra;
	}
	
	
}//end class