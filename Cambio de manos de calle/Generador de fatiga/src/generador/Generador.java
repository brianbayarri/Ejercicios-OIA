package generador;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Generador {

	public Generador(String path) throws IOException
	{
		PrintWriter salida = new PrintWriter (new FileWriter(path));
		salida.println("8000 1 8000");
		salida.println("23994");
		for (int i=1 ; i<=8000 ; i++)
		{
			for(int j=i+1 ; j<=i+3 ; j++)
			{
				if(j>8000)
					break;
				
				salida.println(""+i+" "+j+" "+30);
			}
		}
		salida.close();
	}
	public static void main(String[] args) throws IOException {
		Generador g1 = new Generador("fatiga.in");

	}

}
