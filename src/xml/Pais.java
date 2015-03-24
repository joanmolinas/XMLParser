package xml;

import java.util.List;

public class Pais {

//	private String nom
//	private String codiPais
//	private List<Ciutat> ciutats
//	getters i setters
//	toString
//	constructor amb zero arguments
//	constructor amb els atributs
	private String nom;
	private String codiPais;
	private List<Ciutat> ciutats;
	
	public Pais() {
	}
	
	public Pais(String nom, String codiPais, List<Ciutat> ciutats) {
		this.nom = nom;
		this.codiPais = codiPais;
		this.ciutats = ciutats;
	}

	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCodiPais() {
		return codiPais;
	}
	public void setCodiPais(String codiPais) {
		this.codiPais = codiPais;
	}
	public List<Ciutat> getCiutats() {
		return ciutats;
	}
	public void setCiutats(List<Ciutat> ciutats) {
		this.ciutats = ciutats;
	}
	@Override
	public String toString() {
		return "Pais [\nnom=" + nom + "\ncodiPais=" + codiPais + "\nciutats="
				+ ciutats + "\n]";
	}

	
}
