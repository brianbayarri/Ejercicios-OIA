package aCorrer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Competencia {
	
	private Corredor [] vecCor;
	private Rango [] rangoF;
	private Rango [] rangoM;
	private int [] ganadores;
	int cantCor;
	int catF;
	int catM;
	int cantL;
	
	public Competencia (String path) throws FileNotFoundException
	{
		int i,edad,rango=0,j;
		String sexo;
		Scanner sc = new Scanner(new File (path));
		this.cantCor = sc.nextInt();
		this.catF = sc.nextInt();
		this.catM = sc.nextInt();
		this.cantL = sc.nextInt();
		this.vecCor = new Corredor [cantCor];
		this.rangoF = new Rango [catF];
		this.rangoM = new Rango [catM];
		this.ganadores = new int [cantL];
		for (i=0;i<catF;i++)
		{
			rangoF[i] = new Rango (sc.nextInt(),sc.nextInt());
		}
		for(i=0;i<catM;i++)
		{
			rangoM[i] = new Rango (sc.nextInt(),sc.nextInt());
		}
		for (i=0;i<cantCor;i++)
		{
			
			edad = sc.nextInt();
			sexo= sc.next();
			if (sexo.equals("F"))
			{
				for(j=0;j<catF;j++)
				{
					if(edad >= rangoF[j].getLi() && edad <= rangoF[j].getLs())
					{
						rango=j+1;
					}
				}
			}
			else
			{
				for(j=0;j<catM;j++)
				{
					if(edad >= rangoM[j].getLi() && edad <= rangoM[j].getLs())
					{
						rango=j+1;
					}
				}
			}
			vecCor[i] = new Corredor (sexo,rango,i+1);
		}
		for (i=0;i<cantL;i++)
		{
			ganadores[i] = sc.nextInt();
		}
		
		sc.close();
	}
	
	public void resolver(String s) throws IOException
	{
		int i,j,c=1,cont=0;
		String salida;
		PrintWriter out = new PrintWriter(new FileWriter(s));
		while (c <= catF)
		{
			salida="" + c;
			for(i=0;i<cantL;i++)
			{
					for(j=0;j<cantCor;j++)
					{
						if(vecCor[j].getSexo().equals("F") && vecCor[j].getRango()==c)
						{
							if(ganadores[i]==vecCor[j].getNum())
							{
								if (cont<3)
								{
									salida=salida + " " + ganadores[i];
									cont++;
								}
							}
						}
					}
			}
			if (cont==0)
			{
				salida=salida + " " + 0 + " " + 0 + " " + 0; 
			}
			else
			{
				if(cont==1)
				{
					salida=salida + " " + 0 + " " + 0;
				}
				else
				{
					if (cont==2)
					{
						salida=salida + " " + 0;
					}
				}
			}
			out.println(salida);
			c++;
			cont=0;
		}
		c=1;
		while (c <= catM)
		{
			salida="" + c;
			for(i=0;i<cantL;i++)
			{
					for(j=0;j<cantCor;j++)
					{
						if(vecCor[j].getSexo().equals("M") && vecCor[j].getRango()==c)
						{
							if(ganadores[i]==vecCor[j].getNum())
							{
								if (cont<3)
								{
									salida=salida + " " + ganadores[i];
									cont++;
								}
								
						}
					}
				}
			}
			if (cont==0)
			{
				salida=salida + " " + 0 + " " + 0 + " " + 0; 
			}
			else
			{
				if(cont==1)
				{
					salida=salida + " " + 0 + " " + 0;
				}
				else
				{
					if (cont==2)
					{
						salida=salida + " " + 0;
					}
				}
			}
			out.println(salida);
			c++;
			cont=0;
		}
		
		out.close();
	}
	

}
