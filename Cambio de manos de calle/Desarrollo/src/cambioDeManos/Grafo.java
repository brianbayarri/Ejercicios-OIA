package cambioDeManos;
//LO USAMOS PARA SABER LA RELACION ENTRE LOS NODOS, EL GRAFO BASICAMENTE XD
public class Grafo{
	private int[][] aristas;
	private Esquina[] nodos;
	private int infinito;
	
	//Complejidad: O(N^2)
	public Grafo(final int cant_nodos,final int infinito) {
		aristas = new int[cant_nodos][cant_nodos];
		nodos = new Esquina[cant_nodos];
		this.infinito = infinito;
		for (int i = 0; i < aristas.length; i++) {
			for(int j=0; j<  aristas[0].length; j++)
			{
				aristas[i][j]=infinito;
			}
		}
	}
	
	public Calle getArista(Esquina nodoInicial, Esquina nodoFinal) {
		int distancia = aristas[nodoInicial.getNro()][nodoFinal.getNro()];
		if(distancia == infinito)
			return null;
		else
			return new Calle(nodoInicial,nodoFinal,distancia);
	}
	
	public void addNodo(Esquina n){
		nodos[n.getNro()] = n;
	}
	
	public void addArista(Calle a){
		aristas[a.getNodo1().getNro()][ a.getNodo2().getNro()] =a.getCosto();
		aristas[ a.getNodo2().getNro() ][a.getNodo1().getNro()] =a.getCosto();
	}
	
	public int getCantNodos() {
		return nodos.length;
	}

	public Esquina[] getNodos() {
		return nodos;
	}
	
}
