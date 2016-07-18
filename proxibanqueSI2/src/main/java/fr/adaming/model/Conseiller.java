package fr.adaming.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conseillers")
public class Conseiller extends Personne{

	@Id@GeneratedValue
	private Long idConseiller;
	@Column
	private String nomAgence;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="conseiller")
	private Set<Client> clients= new HashSet<Client>();

	public Conseiller(Long idConseiller, String nomAgence) {
		super();
		this.idConseiller = idConseiller;
		this.nomAgence = nomAgence;
	}


	public Conseiller() {
		super();
	}
	
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
