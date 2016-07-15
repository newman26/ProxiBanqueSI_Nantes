package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {

	public  void addClient(Client client);

	public  void updateClient(Client client);

	public  void deleteClient(Client client);

	public  List<Client> selectAllClients();

	public  List<Client> selectClientByIdConseiller(Long idConseiller);

	public  Client findClientById(int id);

	public List<Client> findClientByNomAndPrenom(String nom,String prenom);
}
