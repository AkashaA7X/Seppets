
public class Personajes {

	private String nombre;
	private int vida;
	private int defensa;
	private int ataque;
	private int ataqueEspecial;
	
	public Personajes(String nombre) {
		this.nombre=nombre;
		this.vida=100;
		this.defensa=(int) (Math.random()*100);
		
	}
	public Personajes(String nombre,int defensa,int ataque) {
		this.nombre=nombre;
		this.vida=100;
		this.defensa=defensa;
		this.ataque=ataque;
	}
	
	@Override 
	public boolean equals(Object o) {
		String clave= ((Personajes)o).nombre;
		return clave.equalsIgnoreCase(nombre);
	}
	
	
	@Override
	public String toString() {
		return String.format("Personaje: %s\n VIDA: %d \t DEFENSA: %d \t ATAQUE: %d", nombre,vida,defensa,ataque);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	

}
