package luchadoresjaponeses;

public class Luchador {
	
	private float peso;
    private float altura;
 
    public Luchador(float peso,float altura)
	{
		this.peso=peso;
		this.altura=altura;
	}
	
    public Luchador(){}
	
	public Luchador(Luchador obj)
	{
		this.altura=obj.altura;
		this.peso=obj.peso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(altura);
		result = prime * result + Float.floatToIntBits(peso);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Luchador other = (Luchador) obj;
		if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
			return false;
		return true;
	}

	void MostrarLuchador()
	{
		System.out.println(this.altura+" "+this.peso);
	}
	
	public boolean Domina(Luchador obj)
	{
		
		if(this.peso > obj.peso && this.altura > obj.altura) {
			return true;
		}
		else
		{
			if((this.peso == obj.peso && this.altura > obj.altura) || (this.altura == obj.altura && this.peso > obj.peso)) {
				return true;
			}
		}
		
		return false;
		
		
	}

}

public Boolean domina (Luchador l) {
	if (this.>l.peso && this.altura>l.altura)
		return true;
	if (this.peso.equals(l.peso) && this.altura>l.altura);
		return true;
	if (this.peso>l.peso && this.altura.equals(l.altura))
		return true;
	return false;
}
