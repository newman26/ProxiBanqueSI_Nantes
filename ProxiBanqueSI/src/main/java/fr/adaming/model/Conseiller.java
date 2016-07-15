package fr.adaming.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conseillers")
public class Conseiller extends Personne{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConseiller;
	@Column
	private String nomAgence;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="conseiller")
	private Set<Client> clients= new HashSet<Client>();

	
	
//Constructeurs 
	public Conseiller() {
	}
	
	public Conseiller(String nom, String prenom, String nomAgence) {
	super(nom, prenom);
	this.nomAgence = nomAgence;
}

	public Conseiller(String nom, String prenom, Long idConseiller,
			String nomAgence) {
		super(nom, prenom);
		this.idConseiller = idConseiller;
		this.nomAgence = nomAgence;
	}


//Getters et Setters 
	public Long getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(Long idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}
	


	public Set<Client> getClients() {
		return clients;
	}


	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}


	@Override
	public String toString() {
		return "Conseiller [idConseiller=" + idConseiller + ", nomAgence="
				+ nomAgence + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + "]";
	}
	
	
	
}
