package cambioDeManos;
//ACA GUARDAMOS LAS CALLES QUE NOS VIENEN EN EL IN
public class Calle {
	private Esquina nodo1;
	private Esquina nodo2;
	private int costo;
	
	public Calle(Esquina nodo1, Esquina nodo2, int costo) {
		super();
		this.nodo1 = nodo1;
		this.nodo2 = nodo2;
		this.costo = costo;
	}
	
	public Esquina getNodo1() {
		return nodo1;
	}
	public void setNodo1(Esquina nodo1) {
		this.nodo1 = nodo1;
	}
	public Esquina getNodo2() {
		return nodo2;
	}
	public void setNodo2(Esquina nodo2) {
		this.nodo2 = nodo2;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calle other = (Calle) obj;
		if (nodo2 == null) {
			if (other.nodo2 != null)
				return false;
		} else if (nodo2.getNro() !=  other.nodo2.getNro())
			return false;
		if (nodo1 == null) {
			if (other.nodo1 != null)
				return false;
		} else if (nodo1.getNro() != (other.nodo1.getNro()))
			return false;
		return true;
	}

}