package xml;

public class Ciutat {
//	private String nom
//	private int poblacio
//	getters i setters
//	toString
//	constructor amb zero arguments
//	constructor amb els atributs
	
	private String nom;
	private int poblacio;
	
	public Ciutat() {
		
	}
	public Ciutat(String nom, int poblacio) {
		this.nom = nom;
		this.poblacio = poblacio;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(int poblacio) {
		this.poblacio = poblacio;
	}
	
	public String toString() {
		return "Nom: " + nom  + ", Poblacio: " + poblacio;
	}

	
}
