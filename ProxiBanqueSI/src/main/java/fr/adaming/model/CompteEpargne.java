package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compteepargnes")
public class CompteEpargne extends Compte{


	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long IdCompteEpargne;

	@Column
	private  float tauxRemuneration;

	@ManyToOne
	@JoinColumn (name="Id_Client", nullable=false)
	private Client client;
	
	
	//Constructeurs
	public CompteEpargne() {
		super();
	}


	public CompteEpargne(String numCompte, float solde, Date dateCreation,
			float tauxRemuneration) {
		super(numCompte, solde, dateCreation);
		this.tauxRemuneration = tauxRemuneration;
	}


	public CompteEpargne(String numCompte, float solde, Date dateCreation,
			Long idCompteEpargne, float tauxRemuneration) {
		super(numCompte, solde, dateCreation);
		IdCompteEpargne = idCompteEpargne;
		this.tauxRemuneration = tauxRemuneration;
	}

	
	//Getters et Setters 
	public Long getIdCompteEpargne() {
		return IdCompteEpargne;
	}

	public void setIdCompteEpargne(Long idCompte) {
		IdCompteEpargne = idCompte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	public float getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(float tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}


	@Override
	public String toString() {
		return "CompteEpargne [IdCompteEpargne=" + IdCompteEpargne
				+ ", tauxRemuneration=" + tauxRemuneration  + "]";
	}



}



