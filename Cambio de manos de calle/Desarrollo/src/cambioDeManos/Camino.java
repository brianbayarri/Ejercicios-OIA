package cambioDeManos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
//ACA RESOLVEMOS TODO EL DIJKSTRA
public class Camino{

	private int cant_esquinas;
	private int cant_calles;
	private Esquina esquina_inicio;
	private Esquina esquina_fin;
	private Grafo mapa;
	private int[] distancia;
	private int[] herencia;
	private ArrayList<Calle> calles;
	private ArrayList<Integer> calles_invertidas;
	private int distancia_escuela;
	
	//Complejidad: O(n)
	public Camino(String path) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(path));
		this.cant_esquinas = sc.nextInt(); //CANTIDAD DE ESQUINAS
		this.esquina_inicio = new Esquina(sc.nextInt()-1); //NODO SALIDA
		this.esquina_fin = new Esquina(sc.nextInt()-1); //NODO DESTINO
		sc.nextLine();
		this.cant_calles = sc.nextInt(); //CANTIDAD DE CALLES
		calles = new ArrayList<Calle>(); //LAS VAMOS GUARDANDO EN UNA LISTA DE LA CLASE CALLE
		mapa = new Grafo(cant_esquinas,Integer.MAX_VALUE); //CREAMOS UN MAPA, ES DECIR EL GRAFO
		for(int i=1; i<=cant_calles; i++)
		{
			Calle c= new Calle(new Esquina(sc.nextInt()-1),new Esquina(sc.nextInt()-1),sc.nextInt()); //GUARDAMOS LA CALLE Y EL COSTO
			calles.add(c); //LA AGREGAMOS A LA LISTA DE CALLES
			mapa.addArista(c);  //LA AGREGAMOS A NUESTRO GRAFO PARA QUE LO LLEVE EN LA MATRIZ DE ADYACENCIA
		}
		sc.close();
	}
	
//Complejidad: O(n*log n) DIJKSTRA CON COLA DE PRIORIDAD
	public void resolver() throws Exception{
		
		PriorityQueue<Esquina> cola = new PriorityQueue<>();  //CREAMOS LA COLA
		distancia  = new int[this.mapa.getCantNodos()];  //ACA GUARDAREMOS LA DISTANCIA DE UN NODO A OTRO
		boolean[] visitado  = new boolean[this.mapa.getCantNodos()];  //ACA PARA SABER SU UN NODO YA FUE VISITADO O NO
		herencia = new int[this.mapa.getCantNodos()]; //SABER RELACION ENTRE LOS NODOS
		
		//INICIALIZAMOS ESOS TRES VECTORES
		for(int i=0; i<this.mapa.getCantNodos(); i++)
		{
			distancia[i] = Integer.MAX_VALUE;
			visitado[i] = false;
			herencia[i] = -1;
		}
	
		distancia[esquina_inicio.getNro()] = 0;  //TOMAMOS EL NODO ORIGEN
		esquina_inicio.setDist(0);  //LO SETEAMOS

		cola.add(esquina_inicio);  //LO AGREGAMOS A LA COLA
		while(!cola.isEmpty()){
			Esquina nodo_actual = cola.poll();  //LO SACAMOS DE LA COLA Y LO GUARDAMOS EN NODO ACTUAL
			visitado[nodo_actual.getNro()] = true;  //LO MARCAMOS COMO VISITADO
			for(int i = 0; i < this.mapa.getCantNodos(); i++){
				if(nodo_actual.getNro() != i) {
					Calle c = this.mapa.getArista(nodo_actual, new Esquina(i)); //VEMOS SI EXISTE CALLE ENTRE NODO ACTUAL Y ESQUINA
					if(c != null){
						int dist = c.getCosto()+nodo_actual.getDist(); //TOMO LA DISTANCIA ENTRE ESOS
						if(!visitado[i] && dist <distancia[i]) { //SI NO FUE VISITADO Y LA DISTANCIA ES MENOR A LA QUE TENIAMOS
							distancia[i] = dist;
							Esquina nueva_esquina = new Esquina(i);
							nueva_esquina.setDist(dist);
							if(cola.contains(nueva_esquina))
								cola.remove(nueva_esquina);
							herencia[i] = nodo_actual.getNro();
							cola.add(nueva_esquina);
						}
					}
				}
			}
		}

		distancia_escuela = this.distancia[this.esquina_fin.getNro()];   //CALCULO LA DISTANCIA FINAL OBTENIDA, QUE SERIA LA TOTAL
		this.calles_invertidas = new ArrayList<Integer>();  //LISTA PARA SABER AQUELLAS CALLES QUE INVERTIMOS
		int calle = this.esquina_fin.getNro();
		//ACA ME PERDI
		while(calle != this.esquina_inicio.getNro())
		{
			Calle c = new Calle(new Esquina(this.herencia[calle]),new Esquina(calle),0);
			if(!this.calles.contains(c))
				this.calles_invertidas.add(this.calles.indexOf(new Calle(new Esquina(calle),new Esquina(this.herencia[calle]),0))+1);
			calle = this.herencia[calle];
		}
		
	}

	public void imprimir() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("cambio.out");
		pw.println(distancia_escuela);
		for(Integer i : calles_invertidas){
			pw.print(i+" ");
		}
		pw.close();
	}

}

