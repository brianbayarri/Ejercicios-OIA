package caosLatas;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Fabrica f1 = new Fabrica ("Latas.txt");
		f1.imprimir();
		f1.resolver();
		
	}

}
