package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;

@Repository("clientDao")
@Transactional
public class ClientDaoImpl implements IClientDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//Guetters et Setters Pour Spring (Injection des dependances)
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public void addClient(Client client) {
		Session session=sessionFactory.getCurrentSession();
		session.save(client);
		
		
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteClient(Client client) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(client);
	
	}

	@Override
	public List<Client> selectAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> selectClientByIdConseiller(Long idConseiller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findClientById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Client client=(Client) session.get(Client.class, id);
		
		return  client;
	}

	@Override
	public List<Client> findClientByNomAndPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

}
