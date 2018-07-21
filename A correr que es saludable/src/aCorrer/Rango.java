package aCorrer;

public class Rango {
	private int li;
	private int ls;
	
	public Rango(int li, int ls)
	{
		this.li = li;
		this.ls = ls;
	}

	public int getLi() {
		return li;
	}

	public int getLs() {
		return ls;
	}
	
	public String toString()
	{
		return this.li + " " + this.ls;
	}

}
