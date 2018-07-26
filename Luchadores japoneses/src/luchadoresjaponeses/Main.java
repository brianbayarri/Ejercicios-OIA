package luchadoresjaponeses;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		TorneoLuchadores t1 = new TorneoLuchadores("input.txt");
		t1.Resolver();
		t1.imprimir();

	}

}
