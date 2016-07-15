package fr.adaming.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Personne {


	private String nom;
	
	private String prenom;
	
	
	public Personne() {
		
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}






	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}

	
	
}

