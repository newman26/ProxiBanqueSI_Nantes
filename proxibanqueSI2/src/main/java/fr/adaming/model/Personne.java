package fr.adaming.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Personne {


	private String nom;
	
	private String prenom;
	
	
	public Personne() {
		
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

	
	
}

