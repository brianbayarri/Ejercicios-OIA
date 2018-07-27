package cambioDeManos;
//LA USAMOS PARA GUARDAR CADA ESQUINA QUE TENEMOS Y ASI PODER ARMAR CAMINO
public class Esquina implements Comparable<Esquina>{
	
	private int nro;
	private int dist; 
	
	public Esquina(int nro){
		this.nro = nro;
		dist = Integer.MAX_VALUE;
	}
	public void setNro(int value){
		this.nro = value;
	}
	
	public int getNro(){
		return this.nro;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Esquina nodo) {
		if(this.dist > nodo.dist){
			return 1;
		}
		else if(this.dist < nodo.dist){
			return -1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return "" +(nro);
	}
	
}
