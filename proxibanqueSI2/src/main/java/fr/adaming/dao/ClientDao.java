package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface ClientDao {
	public  void create(Client client);

	public  void update(Client client);

	public  void delete(Client client);

	public  List<Client> selectAll();

	public  List<Client> selectByIdConseiller(Long idConseiller);

	public  Client findClientById(int id);

	public List<Client> findClientByNomAndPrenom(String nom,
			String prenom);
}
