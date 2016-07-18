package fr.adaming.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.exception.ExceptionNombreClients;
import fr.adaming.exception.ExceptionSolde;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.Conseiller;
import fr.adaming.service.ClientService;
import fr.adaming.service.CompteCourantService;
import fr.adaming.service.CompteEpargneService;
import fr.adaming.service.ConseillerService;

@ManagedBean(name="clientBean")
@SessionScoped
@Component
public class ClientBean {

	@Autowired
	private ClientService clientService;
	@Autowired
	private CompteCourantService compteCourantService; 
	@Autowired
	private CompteEpargneService compteEpargneService; 
	@Autowired
	private ConseillerService conseillerService;

	private Client client;
	private CompteCourant compteCourant;
	private Conseiller conseiller;
	private CompteEpargne compteEpargne;
	
	private List<Client> list =null;
	private Client clientmod =null;

	private boolean addCompteEpargne;
	private  boolean addCompteCourant;
	
	private Long idConseiller;
	private float solde;
	private Long idCompteEpargne1;
	private Long idComptecourant1;
	private Long idCompteEpargne2;
	private Long idComptecourant2;
	private float sommeTotale;

	private int idClient;
	private String nomClient;
	private String prenomClient;
	private boolean isFortune;
	private boolean editMode=false;
	
	//*******************constructeur**********************************
	
	public ClientBean() {
		client=new Client();
		compteCourant = new CompteCourant();
		compteEpargne = new CompteEpargne();
		conseiller = new Conseiller();
	}


	//**********************************GETTER SETTER*****************************************



	public boolean isEditMode() {
		return editMode;
	}


	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}


	public int getIdClient() {
		return idClient;
	}


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getPrenomClient() {
		return prenomClient;
	}


	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public Long getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(Long idConseiller) {
		this.idConseiller = idConseiller;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public CompteCourantService getCompteCourantService() {
		return compteCourantService;
	}



	public void setCompteCourantService(CompteCourantService compteCourantService) {
		this.compteCourantService = compteCourantService;
	}



	public Long getIdComptecourant1() {
		return idComptecourant1;
	}


	public void setIdComptecourant1(Long idComptecourant1) {
		this.idComptecourant1 = idComptecourant1;
	}


	public Long getIdComptecourant2() {
		return idComptecourant2;
	}


	public void setIdComptecourant2(Long idComptecourant2) {
		this.idComptecourant2 = idComptecourant2;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargneService getCompteEpargneService() {
		return compteEpargneService;
	}


	public void setCompteEpargneService(CompteEpargneService compteEpargneService) {
		this.compteEpargneService = compteEpargneService;
	}


	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}


	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}



	public Conseiller getConseiller() {
		return conseiller;
	}


	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public ConseillerService getConseillerService() {
		return conseillerService;
	}


	public void setConseillerService(ConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}


	public float getSolde() {
		return solde;
	}


	public void setSolde(float solde) {
		this.solde = solde;
	}



	//**********************************************************************************************


	public boolean isAddCompteEpargne() {
		return addCompteEpargne;
	}


	public void setAddCompteEpargne(boolean addCompteEpargne) {
		this.addCompteEpargne = addCompteEpargne;
	}


	public boolean isAddCompteCourant() {
		return addCompteCourant;
	}


	public void setAddCompteCourant(boolean addCompteCourant) {
		this.addCompteCourant = addCompteCourant;
	}
	public List<Client> getClientList(){
		return clientService.getAll();
	}

	public List<CompteCourant> getCompteCourantList(){
		return compteCourantService.getAll();
	}

	public List<CompteEpargne> getCompteEpargneList(){
		return compteEpargneService.getAll();
	}

	public float getSommeTotale() {
		return sommeTotale;
	}


	public void setSommeTotale(float sommeTotale) {
		this.sommeTotale = sommeTotale;
	}


	public boolean isFortune() {
		return isFortune;
	}


	public void setFortune(boolean isFortune) {
		this.isFortune = isFortune;
	}


	public List<Client> getList() {
		return list;
	}


	public void setList(List<Client> list) {
		this.list = list;
	}


	public Client getClientmod() {
		return clientmod;
	}
	public Long getIdCompteEpargne1() {
		return idCompteEpargne1;
	}


	public void setIdCompteEpargne1(Long idCompteEpargne1) {
		this.idCompteEpargne1 = idCompteEpargne1;
	}


	public Long getIdCompteEpargne2() {
		return idCompteEpargne2;
	}


	public void setIdCompteEpargne2(Long idCompteEpargne2) {
		this.idCompteEpargne2 = idCompteEpargne2;
	}

	public void setClientmod(Client clientmod) {
		this.clientmod = clientmod;
	}

//******************Methodes********************************
	public void addClient() throws ExceptionNombreClients{
		if(editMode==false)
		{
			if (addCompteCourant !=true){
				compteCourant=null;	
			}

			if (addCompteEpargne !=true){
				compteEpargne=null;	
			}

			clientService.add(idConseiller,client,compteCourant,compteEpargne);
			list = clientService.getClientByIdConseiller(conseiller.getIdConseiller());
			client=new Client();
			compteCourant=new CompteCourant();
			compteEpargne=new CompteEpargne();
			conseiller = new Conseiller();
		}	else	
		{
			clientService.update(client);
			list = clientService.getClientByIdConseiller(conseiller.getIdConseiller());
			editMode=false;
			client=new Client();
		}
	}


	public void getClientById() {
		clientmod = clientService.getClientById(client.getId());
	}

	public List<Client> getClientByNomAndPrenom() {

		return clientService.findClientByNomAndPrenom(nomClient, prenomClient);
	}

	public void addComptesToClient() {

		if (addCompteCourant !=true){
			compteCourant=null;	
		}

		if (addCompteEpargne !=true){
			compteEpargne=null;	
		}

		clientService.addComptesToClient(client.getId(),compteCourant,compteEpargne);

		client=new Client();
		compteCourant=new CompteCourant();
		compteEpargne=new CompteEpargne();
		conseiller = new Conseiller();
	}


	public void getClientByIdConseiller() {

		list = clientService.getClientByIdConseiller(conseiller.getIdConseiller());
	}



	public void deleteClient(){
		clientService.delete(client);
		list = clientService.getClientByIdConseiller(conseiller.getIdConseiller());
		client=new Client();
		
	}

	public void updateClient(){
		editMode=true;
		System.out.println("--------1------------------");
		clientService.update(client);
	}
	public void updateCourant(){
		editMode=true;
		compteCourantService.update(compteCourant);;
	}

	public void updateEpargne(){
		editMode=true;
		compteEpargneService.update(compteEpargne);
	}


	public void getClientByIdConseiller(Long idConseiller){
		this.list= clientService.getClientByIdConseiller(idConseiller);
	}



	public List<CompteCourant> lowBalance(){
		return compteCourantService.lowBalance();

	}
	public List<CompteCourant> highBalance(){
		return compteCourantService.highBalance();

	}

	public void takeMoneyOut() throws ExceptionSolde{

		compteCourantService.TakeMoney(solde, idComptecourant1);

	}
	public void addMoney() {

		compteCourantService.addMoney(solde, idComptecourant1);

	}
	public void addMoneyEpargne() {

		compteEpargneService.addMoney(solde, idCompteEpargne2);

	}


	public void virement() throws ExceptionSolde{

		clientService.virement(solde, idComptecourant1, idCompteEpargne1, idComptecourant2, idComptecourant2);

	}


	public void checkByIdClientFortune(){
		sommeTotale = clientService.checkByIdClientFortune(idClient);

		if (sommeTotale> 500000){
			setFortune(true);
		}
		else{ setFortune(false);
		}
	}


}
