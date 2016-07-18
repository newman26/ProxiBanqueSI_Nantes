package fr.adaming.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ClientDao;
import fr.adaming.dao.CompteCourantDao;
import fr.adaming.dao.CompteEpargneDao;
import fr.adaming.dao.ConseillerDao;
import fr.adaming.exception.ExceptionNombreClients;
import fr.adaming.exception.ExceptionSolde;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.Conseiller;
import fr.adaming.service.ClientService;
import fr.adaming.service.CompteCourantService;
import fr.adaming.service.CompteEpargneService;


@Service
public class ClientServiceImpl implements ClientService{


	@Autowired
	private ClientDao clientDao;
	@Autowired
	private CompteCourantDao compteCourantDao;

	@Autowired
	private CompteEpargneDao compteEpargneDao;
	@Autowired
	private CompteCourantService compteCourantService;
	@Autowired
	private CompteEpargneService compteEpargneService;

	//***************************Modif**********************************
	//*********************************************************************
	@Autowired
	private ConseillerDao conseillerDao;

	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#getClientDao()
	 */
	public ClientDao getClientDao() {
		return clientDao;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#setClientDao(fr.adaming.dao.ClientDao)
	 */
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}



	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#add(java.lang.Long, fr.adaming.model.Client, fr.adaming.model.CompteCourant, fr.adaming.model.CompteEpargne)
	 */
	public void add(Long idConseiller,Client client,CompteCourant compteCourant, CompteEpargne compteEpargne) throws ExceptionNombreClients{

		Conseiller conseiller= conseillerDao.getById(idConseiller);
		Set<Client> clients=conseiller.getClients();


		if(	clients.size()>9) {
			throw new ExceptionNombreClients("le Nombre de Clients est superieur à 10");
		}else{
			client.setConseiller(conseiller);
			clients.add(client);
			conseiller.setClients(clients);

			if (compteCourant!=null){
				Set<CompteCourant> compteCourants=client.getCompteCourants();
				compteCourants.add(compteCourant);
				client.setCompteCourants(compteCourants);
				compteCourant.setClient(client);
			}

			if (compteEpargne!=null){
				Set<CompteEpargne> compteEpargnes=client.getCompteEpargnes();
				compteEpargnes.add(compteEpargne);

				client.setCompteEpargnes(compteEpargnes);
				compteEpargne.setClient(client);

			}


			conseillerDao.update(conseiller);
			clientDao.create(client);
			if (compteCourant!=null){
				compteCourantDao.create(compteCourant);
			}

			if (compteEpargne!=null){
				compteEpargneDao.create(compteEpargne);
			}

		}


	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#getClientById(int)
	 */
	public Client getClientById(int idClient) {
		return clientDao.findClientById(idClient);
	}




	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#findClientByNomAndPrenom(java.lang.String, java.lang.String)
	 */
	public List<Client> findClientByNomAndPrenom(String nom, String prenom) {
		return clientDao.findClientByNomAndPrenom(nom, prenom);
	}



	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#addComptesToClient(int, fr.adaming.model.CompteCourant, fr.adaming.model.CompteEpargne)
	 */
	public void addComptesToClient(int idClient,CompteCourant compteCourant, CompteEpargne compteEpargne){
		Client client=clientDao.findClientById(idClient);

		if (compteCourant!=null){
			Set<CompteCourant> compteCourants=client.getCompteCourants();
			compteCourants.add(compteCourant);
			client.setCompteCourants(compteCourants);
			compteCourant.setClient(client);
		}

		if (compteEpargne!=null){
			Set<CompteEpargne> compteEpargnes=client.getCompteEpargnes();
			compteEpargnes.add(compteEpargne);

			client.setCompteEpargnes(compteEpargnes);
			compteEpargne.setClient(client);

		}


		clientDao.update(client);
		if (compteCourant!=null){
			compteCourantDao.create(compteCourant);
		}

		if (compteEpargne!=null){
			compteEpargneDao.create(compteEpargne);
		}
	}
	//****************************************************************************************************************************************
	//*****************************************************************************************************************************************


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#update(fr.adaming.model.Client)
	 */
	public void update(Client client) {
		System.out.println("--------2-----------------");
		clientDao.update(client);

	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#delete(fr.adaming.model.Client)
	 */
	public void delete(Client client) {
		clientDao.delete(client);

	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#getAll()
	 */
	public List<Client> getAll() {

		return clientDao.selectAll();
	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#getClientByIdConseiller(java.lang.Long)
	 */
	public List<Client> getClientByIdConseiller(Long idConseiller) {
		return clientDao.selectByIdConseiller(idConseiller);
	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#checkByIdClientFortune(int)
	 */
	public float checkByIdClientFortune(int idClient) {
		Client client=clientDao.findClientById(idClient);

		Set<CompteCourant>	cc=client.getCompteCourants();
		Set<CompteEpargne> ce=client.getCompteEpargnes();

		float sommeCE = 0;
		float sommeCC = 0;
		float sommeTotale;
		for (CompteEpargne compteEpargne : ce) {
			sommeCE+=compteEpargne.getSolde();
		}
		for (CompteCourant compteCourant : cc) {
			sommeCC+=compteCourant.getSolde();
		}
		sommeTotale=sommeCE+sommeCC;


		return sommeTotale;
	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ClientService#virement(float, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long)
	 */
	public void virement(float solde, Long idComptecourant1,
			Long idCompteEpargne1, Long idComptecourant2,
			Long idCompteEpargne2) throws ExceptionSolde {

		if (idComptecourant1 != 0 && idCompteEpargne1 ==0 ){ 

			compteCourantService.TakeMoney(solde, idComptecourant1);

			if (idComptecourant2 != 0 ){ 
				compteCourantService.addMoney(solde, idComptecourant2);
			}
			else { 

				compteEpargneService.addMoney(solde, idCompteEpargne2);
			}
		}
		else {

			compteEpargneService.TakeMoney(solde, idCompteEpargne1);

			if (idComptecourant2 != 0 ){ 

				compteCourantService.addMoney(solde, idComptecourant2);

			}
			else { 

				compteEpargneService.addMoney(solde, idCompteEpargne2);
			}

		}
	}




}





