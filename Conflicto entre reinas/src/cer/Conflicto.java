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
//		int i,f,c;
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
//		for(i=0;i<dim;i++)
//		{
//			for(j=0;j<dim;j++)
//			{
//				tablero[i][j]=0;
//			}
//		}
//		i=1;
//		while(i<=cantReinas)
//		{
//			f=sc.nextInt()-1;
//			c=sc.nextInt()-1;
//			tablero[f][c]=i;
//			reinas[i-1] = new Reina (i,f,c);
//			i++;
//		}
		sc.close();
		
	}
	
	
	//COMPLEJIDAD COMPUTACIONAL: O(8 N^2)
	public void resolver() throws IOException
	{
//		int i,f,c,auxf,auxc, cont,,auxf,auxc;
		Reina reina_aux=new Reina();
		int i, f, c,cont, rec;
		String linea=null;
		PrintWriter salida = new PrintWriter(new FileWriter("reinas.out"));
		for(i=0;i<cantReinas;i++)
		{
			//conflictos="0";
//			System.out.print("Reina: "+(i+1)+" ");
			cont=0;
			f=reinas[i].getFila();
			c=reinas[i].getColumna();
			
			//ARRIBA-IZQUIERDA
			
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
//				System.out.print("ARR-I: "+reinas[reina_aux.getNro()-1].getNro()+" ");
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
			
//			auxf=f;
//			auxc=c;
//			while(auxf>-1 || auxc>-1)
//			{
//				auxc--;
//				auxf--;
//				if(auxf==-1 || auxc==-1)
//					break;
//				if(tablero[auxf][auxc]!=0)
//				{
//					cont++;
//					lista_reinas.add(reinas[tablero[auxf][auxc]-1]);
////					if(conflictos.equals("0"))
////						conflictos=String.valueOf(tablero[auxf][auxc]) + " ";
////					else
////						conflictos+=tablero[auxf][auxc] + " ";
//					break;
//				}
//			}
//			
			//IZQUIERDA
			
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
//				System.out.print("I: "+reinas[reina_aux.getNro()-1].getNro()+" ");
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
			
//			auxf=f;
//			auxc=c;
//			while(auxc>-1)
//			{
//				auxc--;
//				if(auxc==-1)
//					break;
//				if(tablero[f][auxc]!=0)
//				{
//					cont++;
//					lista_reinas.add(reinas[tablero[f][auxc]-1]);
////					if(conflictos.equals("0"))
////						conflictos=String.valueOf(tablero[f][auxc]) + " ";
////					else
////						conflictos+=tablero[f][auxc] + " ";
//					break;
//				}
//
//			}
			
			//ABAJO
			
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
//				System.out.print("AB: "+reinas[reina_aux.getNro()-1].getNro()+" ");
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);		
			
//			auxf=f;
//			auxc=c;
//			while(auxf<dim)
//			{
//				auxf++;
//				if(auxf==dim)
//					break;
//				if(tablero[auxf][c]!=0)
//				{
//					cont++;
//					lista_reinas.add(reinas[tablero[auxf][c]-1]);
////					if(conflictos.equals("0"))
////						conflictos=String.valueOf(tablero[auxf][c]) + " ";
////					else
////						conflictos+=tablero[auxf][c]+ " ";
//					break;
//				}
//
//			}
//			
			//ARRIBA
			
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
//				System.out.print("ARR: "+reinas[reina_aux.getNro()-1].getNro()+" ");
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
			
//			auxf=f;
//			auxc=c;
//			while(auxf>-1)
//			{
//				auxf--;
//				if(auxf==-1)
//					break;
//				if(tablero[auxf][c]!=0)
//				{
//					cont++;
//					lista_reinas.add(reinas[tablero[auxf][c]-1]);
////					if(conflictos.equals("0"))
////						conflictos=String.valueOf(tablero[auxf][c]) + " ";
////					else
////						conflictos+=tablero[auxf][c] + " ";
//					break;
//				}
//
//			}
			
			//DERECHA
			
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
//				System.out.print("D: "+reinas[reina_aux.getNro()-1].getNro()+" ");
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
			
				
			
//			auxf=f;
//			auxc=c;
//			while(auxc<dim)
//			{
//				auxc++;
//				if(auxc==dim)
//					break;
//				if(tablero[f][auxc]!=0)
//				{
//					cont++;
//					lista_reinas.add(reinas[tablero[f][auxc]-1]);
////					if(conflictos.equals("0"))
////						conflictos=String.valueOf(tablero[f][auxc]) + " ";
////					else
////						conflictos+=tablero[f][auxc] + " ";
//					break;
//				}
//
//			}
			
			//ABAJO-DERECHA
			
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
//				System.out.print("AB-D: "+reinas[reina_aux.getNro()-1].getNro()+" ");
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
			
//			auxf=f;
//			auxc=c;
//			while(auxf<dim || auxc<dim)
//			{
//				auxc++;
//				auxf++;
//				if(auxc==dim || auxf==dim)
//					break;
//				if(tablero[auxf][auxc]!=0)
//				{
//					cont++;
//					lista_reinas.add(reinas[tablero[auxf][auxc]-1]);
////					if(conflictos.equals("0"))
////						conflictos=String.valueOf(tablero[auxf][auxc]) + " ";
////					else
////						conflictos+=tablero[auxf][auxc] + " ";
//					break;
//				}
//			}
			
			//ARRIBA-DERECHA
			
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
//				System.out.print("ARR-D: "+reinas[reina_aux.getNro()-1].getNro()+" ");
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);
			
//			auxf=f;
//			auxc=c;
//			while(auxc<dim || auxf>-1)
//			{
//				auxc++;
//				auxf--;
//				if(auxf==-1 || auxc==dim)
//					break;
//				if(tablero[auxf][auxc]!=0)
//				{
//					cont++;
//					lista_reinas.add(reinas[tablero[auxf][auxc]-1]);
////					if(conflictos.equals("0"))
////						conflictos=String.valueOf(tablero[auxf][auxc]) + " ";
////					else
////						conflictos+=tablero[auxf][auxc] + " ";
//					break;
//				}
//			}
			
			//ABAJO-IZQUIERDA
			
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
//				System.out.print("AB-I: "+reinas[reina_aux.getNro()-1].getNro()+" ");
				lista_reinas.add(reinas[reina_aux.getNro()-1]);
			}
			
			reina_aux.setNro(0);			
			
//			auxf=f;
//			auxc=c;
//			while(auxf<dim || auxc>-1)
//			{
//				auxc--;
//				auxf++;
//				if(auxf==dim || auxc==-1)
//					break;
//				if(tablero[auxf][auxc]!=0)
//				{
//					cont++;
//					lista_reinas.add(reinas[tablero[auxf][auxc]-1]);
////					if(conflictos.equals("0"))
////						conflictos=String.valueOf(tablero[auxf][auxc]) + " ";
////					else
////						conflictos+=tablero[auxf][auxc] + " ";
//					break;
//				}
		//	}
			
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
