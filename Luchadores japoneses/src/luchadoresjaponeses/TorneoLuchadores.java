package luchadoresjaponeses;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class TorneoLuchadores {

	private Luchador [] luchadores;
	private int [] domina;
	private int cantLuchadores;
	
	public TorneoLuchadores(String s) throws FileNotFoundException {
		String miPath = s;
		Scanner sc = new Scanner(new File(miPath));
		sc.useLocale(Locale.ENGLISH); // define el punto como separador decimal
		
		this.cantLuchadores= sc.nextInt();
		this.luchadores = new Luchador [cantLuchadores];
		this.domina = new int [cantLuchadores];
		
		for (int i = 0; i < luchadores.length ; i++) {
			luchadores[i] = new Luchador(sc.nextInt(),sc.nextInt()) ;			
		}
		
		sc.close();
		
	}
	
	public void Resolver() {
		
		int cant=0;
		
		for(int i=0; i< luchadores.length ; i++) {
			
			for(int j=0; j< luchadores.length ; j++ ) {
				
				if(luchadores[i].Domina(luchadores[j]) && i!=j)
					cant++;
			}
			
			domina[i]= cant;
			cant=0;
		}		
		
	}
	
	public void imprimir() throws IOException{
		
		String miPath = "Resultado.txt";
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		
		for(int i=0; i< domina.length; i++) {
			salida.println(domina[i]);			
		}
		
		salida.close();
	}
	
	//Foreach
	public void mostrarResultaados()
	{
		for (Integer cadaUno: this.dominados) {
			System.out.println(cadaUno);
		}
	}
	
	public void imprimirResultados (String s) throws IOException
	{
		PrintWriter salida = new PrintWriter (new FileWriter(s));
		
	}
	
	
	
	
        
        
        
}
