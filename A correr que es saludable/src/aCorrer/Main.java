package aCorrer;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Competencia c1 = new Competencia ("carrera.in");
		c1.resolver("carrera.out");
	}

}
