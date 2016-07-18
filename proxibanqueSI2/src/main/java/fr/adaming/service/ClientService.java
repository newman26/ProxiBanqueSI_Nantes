package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.ClientDao;
import fr.adaming.exception.ExceptionNombreClients;
import fr.adaming.exception.ExceptionSolde;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;


public interface ClientService {

	public ClientDao getClientDao();

	public  void setClientDao(ClientDao clientDao);

	public  void add(Long idConseiller, Client client,
			CompteCourant compteCourant, CompteEpargne compteEpargne)
			throws ExceptionNombreClients;

	public Client getClientById(int idClient);

	public List<Client> findClientByNomAndPrenom(String nom,
			String prenom);

	public  void addComptesToClient(int idClient,
			CompteCourant compteCourant, CompteEpargne compteEpargne);

	//****************************************************************************************************************************************
	//*****************************************************************************************************************************************

	public  void update(Client client);

	public  void delete(Client client);

	public List<Client> getAll();

	public  List<Client> getClientByIdConseiller(Long idConseiller);

	public  float checkByIdClientFortune(int idClient);

	public void virement(float solde, Long idComptecourant1,
			Long idCompteEpargne1, Long idComptecourant2, Long idCompteEpargne2)
			throws ExceptionSolde;

}