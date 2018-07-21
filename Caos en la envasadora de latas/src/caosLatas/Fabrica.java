package caosLatas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Fabrica {
	
	private String [] Latas;
	private int cantLatas;
	
	public Fabrica(String path) throws FileNotFoundException
	{
		int i = 0;
		cantLatas=0;
		Scanner sc = new Scanner (new File (path));
		this.Latas = new String [5000];
		Latas [i] = sc.next();
		while (!Latas [i].equals("F"))
		{
			i++;
			cantLatas++;
			Latas [i] = sc.next();
		}
		
		sc.close();
		
	}
	
	public void imprimir()
	{
		for (int i=0;i<cantLatas;i++)
		{
			System.out.println(Latas[i]);
		}
		
	}
	
	public void resolver() throws IOException
	{
		int i,cont=0,max=0,max2=0,b=0,d1=0,d2=0,d;
		for (i=0;i<=cantLatas;i++)
		{
				if (Latas[i].equals("G"))
				{
					cont++;
				}
				else
				{
					if (cont>max && b==0)
					{
						max=cont;
						d1=i;
						b=1;
					}
					else
					{
						if (cont>max && b==1)
						{
							max2=max;
							max=cont;
							d2=d1;
							d1=i;
						}
						else
						{
							if (cont>max2)
							{
								max2=cont;
								d2=i;
							}
						}
					}
					
					cont=0;
				}
			
		}
		if (d1 > d2)
			d1-=max;
		else
			d2-=max2;
		d=d1-d2;
		if (d<0)
			d=d*(-1);
		
		PrintWriter salida = new PrintWriter (new FileWriter ("Latas.out"));
		salida.println("Cantidad de latas: " + cantLatas);
		salida.println("Maxima secuencia: " + max);
		salida.println("Maxima secuencia secundaria: " + max2);
		salida.println("Distancia entre ellos:" + d);
		salida.close();
		
	}
	
	

}
