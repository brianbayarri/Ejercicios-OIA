package juego;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Palabra {
	
	private char [][] tablero;
	private int tam;
	private int cantPal;
	private String [] palabras;
	
	public Palabra(String path) throws FileNotFoundException
	{
		int i,j;
		String cadena;
		Scanner sc = new Scanner (new File(path));
		this.tam = sc.nextInt();
		this.cantPal = sc.nextInt();
		this.tablero = new char [tam] [tam];
		this.palabras = new String [cantPal];
		for(i=0;i<tam;i++)
		{
			cadena=sc.next();
			for(j=0;j<tam;j++)
			{
				tablero[i][j] = cadena.charAt(j);
			}
		}
		for(i=0;i<cantPal;i++)
		{
			palabras[i]=sc.next();
		}
		sc.close();
		
	}
	
	public void imprimir()
	{
		for(int i=0;i<tam;i++)
		{
			for(int j=0;j<tam;j++)
			{
				System.out.print(tablero[i][j]);
			}
			System.out.println("");
			
		}
		for (int k=0;k<cantPal;k++)
		{
			System.out.println(palabras[k]);
		}
	}
	
	public void resolver() throws IOException
	{
		int i,j,k,c,aux, f, col, apa;
		char letra;
		String word;
		String miPath = "palabra.out";
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		for(k=0;k<cantPal;k++)
		{
			apa=0;
			word=palabras[k];
			for(i=0;i<tam;i++)
			{
				for(j=0;j<tam;j++)
				{
					
						c=0;
						letra=word.charAt(c);
						if(letra==tablero[i][j])
						{
							aux=c;
							c++;
							letra=word.charAt(c);
							f=i;
							while( f < tam && c<word.length() )
							{
								f++;
								if(f<tam && letra==tablero[f][j])
								{
									c++;
									if(c<word.length())
									letra=word.charAt(c);
								}
									
								else
									break;
							}
							if(c==word.length())
							{
								salida.println( (k+1) + " " + "S");
								apa=1;
							}
							
							if(apa==0)
							{
							c=aux+1;
							f=i;
							while( f > 0 && c<word.length() )
							{
								f--;
								if(letra==tablero[f][j])
								{
									c++;
									if(c<word.length())
									letra=word.charAt(c);
								}
								else
									break;
							}
							if(c==word.length())
							{
								apa=1;
								salida.println((k+1) + " " + "N");
							}
							}
							
							if(apa==0)
							{
							c=aux+1;
							col=j;
							while( col < tam && c<word.length() )
							{
								col++;
								if(col< tam && letra==tablero[i][col])
								{
									c++;
									if(c<word.length())
									letra=word.charAt(c);
								}
								else
									break;
							}
							if(c==word.length())
							{
								apa=1;
								salida.println((k+1) + " " + "O");
							}
							}
							
							if(apa==0)
							{
							c=aux+1;
							col=j;
							while( col > 0 && c<word.length() )
							{
								col--;
								if(letra==tablero[i][col])
								{
									c++;
									if(c<word.length())
										letra=word.charAt(c);
								}
								else
									break;
							}
							if(c==word.length())
							{
								apa=1;
								salida.println((k+1) + " " + "E");
							}
							}
							
							
							
						}
					
				}
				
			}
		}
		salida.close();
	}

}
