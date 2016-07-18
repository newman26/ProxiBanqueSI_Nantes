package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comptecourants")
public class CompteCourant extends Compte{


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long IdComptecourant;

	@Column
	private int decouvertAuto;

	@Column
	private String carteCredit;


	@ManyToOne
	@JoinColumn (name="Id_Client", nullable=false)
	private Client client;

	
	public CompteCourant() {
		super();

	}

	public Long getIdComptecourant() {
		return IdComptecourant;
	}


	public void setIdComptecourant(Long idComptecourant) {
		IdComptecourant = idComptecourant;
	}


	public int getDecouvertAuto() {
		return decouvertAuto;
	}


	public void setDecouvertAuto(int decouvertAuto) {
		this.decouvertAuto = decouvertAuto;
	}


	public String getCarteCredit() {
		return carteCredit;
	}

	public void setCarteCredit(String carteCredit) {
		this.carteCredit = carteCredit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	
}


