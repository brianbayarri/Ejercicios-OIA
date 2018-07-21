package cer;

public class Reina implements Comparable<Reina>{
	private int nro;
	private int fila;
	private int columna;
	
	public Reina(int nro, int fila, int columna) {
		this.nro=nro;
		this.fila = fila;
		this.columna = columna;
	}
	
	public Reina()
	{
		
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
	
	public int getNro() {
		return nro;
	}
	
	@Override
	public int compareTo(Reina r) {
        if (nro < r.nro) {
            return -1;
        }
        if (nro > r.nro) {
            return 1;
        }
        return 0;
    }
	
	public void setNro(int n)
	{
		this.nro=n;
	}
	
	public void setFila(int f)
	{
		this.fila=f;
	}
	public void setColumna(int c)
	{
		this.columna=c;
	}

	
	
	

}
