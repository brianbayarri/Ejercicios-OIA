package cer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Conflicto {
	private int [] [] tablero;
	private Reina [] reinas;
	private int dim;
	private int cantReinas;
	private ArrayList<Reina> lista_reinas;
	
	public Conflicto (String path) throws FileNotFoundException
	{

		Scanner sc = new Scanner (new File(path));
		this.dim = sc.nextInt();
		this.cantReinas = sc.nextInt();
		this.tablero = new int [dim][dim];
		this.reinas = new Reina [cantReinas];
		this.lista_reinas = new ArrayList<Reina>();
		
		for(int i=0;i<cantReinas;i++)
		{
			reinas[i]=new Reina(i+1,sc.nextInt(),sc.nextInt());
		}

		sc.close();
		
	}
	
	
	//COMPLEJIDAD COMPUTACIONAL: O(8 N^2)
	public void resolver() throws IOException
	{

		Reina reina_aux=new Reina();
		int i, f, c,cont, rec;
		String linea=null;
		PrintWriter salida = new PrintWriter(new FileWriter("reinas.out"));
		for(i=0;i<cantReinas;i++)
		{

			cont=0;
			f=reinas[i].getFila();
			c=reinas[i].getColumna();
				
			for(rec=0;rec<cantReinas;rec++)
			{
				if(rec!=i && f>reinas[rec].getFila() && f-reinas[rec].getFila()==c-reinas[rec].getColumna() && (reina_aux.getFila()<reinas[rec].getFila() || reina_aux.getNro()==0))
				{
					reina_aux.setNro(rec+1);
					reina_aux.setFila(reinas[rec].getFila());
					reina_aux.setColumna(reinas[rec].getColumna());
				}
					
			}
			
			if(reina_aux.getNro()!=0)
			{
				cont++;
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
						
			for(rec=0;rec<cantReinas;rec++)
			{
				if(rec!=i && f==reinas[rec].getFila() && c>reinas[rec].getColumna() && (reina_aux.getColumna()<reinas[rec].getColumna() || reina_aux.getNro()==0))
				{
					reina_aux.setNro(rec+1);
					reina_aux.setFila(reinas[rec].getFila());
					reina_aux.setColumna(reinas[rec].getColumna());
				}
					
			}
			
			if(reina_aux.getNro()!=0)
			{
				cont++;
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
						
			for(rec=0;rec<cantReinas;rec++)
			{
				if(rec!=i && f<reinas[rec].getFila() && c==reinas[rec].getColumna() && (reina_aux.getFila()>reinas[rec].getFila() || reina_aux.getNro()==0))
				{
					reina_aux.setNro(rec+1);
					reina_aux.setFila(reinas[rec].getFila());
					reina_aux.setColumna(reinas[rec].getColumna());
				}
					
			}
			
			if(reina_aux.getNro()!=0)
			{
				cont++;
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);		
			
			for(rec=0;rec<cantReinas;rec++)
			{
				if(rec!=i && f>reinas[rec].getFila() && c==reinas[rec].getColumna() && (reina_aux.getFila()<reinas[rec].getFila() || reina_aux.getNro()==0))
				{
					reina_aux.setNro(rec+1);
					reina_aux.setFila(reinas[rec].getFila());
					reina_aux.setColumna(reinas[rec].getColumna());
				}
					
			}
			
			if(reina_aux.getNro()!=0)
			{
				cont++;
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
						
			for(rec=0;rec<cantReinas;rec++)
			{
				if(rec!=i && f==reinas[rec].getFila() && c<reinas[rec].getColumna() && (reina_aux.getColumna()>reinas[rec].getColumna() || reina_aux.getNro()==0))
				{
					reina_aux.setNro(rec+1);
					reina_aux.setFila(reinas[rec].getFila());
					reina_aux.setColumna(reinas[rec].getColumna());
				}
					
			}
			
			if(reina_aux.getNro()!=0)
			{
				cont++;
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
						
			for(rec=0;rec<cantReinas;rec++)
			{
				if(rec!=i && f<reinas[rec].getFila() && reinas[rec].getFila()-f==reinas[rec].getColumna()-c && (reina_aux.getFila()>reinas[rec].getFila() || reina_aux.getNro()==0))
				{
					reina_aux.setNro(rec+1);
					reina_aux.setFila(reinas[rec].getFila());
					reina_aux.setColumna(reinas[rec].getColumna());
				}
					
			}
			
			if(reina_aux.getNro()!=0)
			{
				cont++;
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
						
			for(rec=0;rec<cantReinas;rec++)
			{
				if(rec!=i && f>reinas[rec].getFila() && f-reinas[rec].getFila()==reinas[rec].getColumna()-c && (reina_aux.getFila()<reinas[rec].getFila() || reina_aux.getNro()==0))
				{
					reina_aux.setNro(rec+1);
					reina_aux.setFila(reinas[rec].getFila());
					reina_aux.setColumna(reinas[rec].getColumna());
				}
					
			}
			
			if(reina_aux.getNro()!=0)
			{
				cont++;
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
						
			for(rec=0;rec<cantReinas;rec++)
			{
				if(rec!=i && f<reinas[rec].getFila() &&reinas[rec].getFila()-f==c-reinas[rec].getColumna() && (reina_aux.getFila()>reinas[rec].getFila() || reina_aux.getNro()==0))
				{
					reina_aux.setNro(rec+1);
					reina_aux.setFila(reinas[rec].getFila());
					reina_aux.setColumna(reinas[rec].getColumna());
				}
					
			}
			
			if(reina_aux.getNro()!=0)
			{
				cont++;
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);				
			linea=(cont+" ");
			
			if(cont!=0)
			{
				Collections.sort(lista_reinas);
				for(int j=0;j<lista_reinas.size();j++)
				{
					linea+=(lista_reinas.get(j).getNro()+" ");

				}
			}
			salida.println(linea);	
			lista_reinas.clear();
			System.out.println(" ");
				
	}
		salida.close();

	}
}
