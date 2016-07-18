package fr.adaming.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="clients")
public class Client extends Personne{


	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String adresse;
	
	@Column
	private int codePostal;
	
	@Column
	private String ville;
	
	@Column
	private String telephone;
	
	@OneToMany(mappedBy="client", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private Set<CompteCourant> compteCourants= new HashSet<CompteCourant>();
	
	
	@OneToMany(mappedBy="client",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private Set<CompteEpargne> compteEpargnes= new HashSet<CompteEpargne>();
	
	@ManyToOne
	@JoinColumn (name="Id_Conseiller", nullable=false)
	private Conseiller conseiller;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Set<CompteCourant> getCompteCourants() {
		return compteCourants;
	}
	public void setCompteCourants(Set<CompteCourant> compteCourants) {
		this.compteCourants = compteCourants;
	}
	public Set<CompteEpargne> getCompteEpargnes() {
		return compteEpargnes;
	}
	public void setCompteEpargnes(Set<CompteEpargne> compteEpargnes) {
		this.compteEpargnes = compteEpargnes;
	}
	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", ville=" + ville + ", telephone=" + telephone
				+ ", compteCourants=" + compteCourants + ", compteEpargnes="
				+ compteEpargnes + "]";
	}
	
}
