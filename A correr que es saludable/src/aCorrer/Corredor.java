package aCorrer;

public class Corredor {
	//private int edad;
	private String sexo;
	private int rango;
	private int num;
	
	public Corredor(String sexo,int rango,int num) {
		//this.edad = edad;
		this.sexo = sexo;
		this.rango = rango;
		this.num = num;
	}

	//public int getEdad() {
		//return edad;
	//}

	public String getSexo() {
		return sexo;
	}

	public int getRango() {
		return rango;
	}

	public int getNum() {
		return num;
	}
	
	public String toString()
	{
		return this.sexo + " " + this.rango + " " + this.num;
	}
	
	
	
}
