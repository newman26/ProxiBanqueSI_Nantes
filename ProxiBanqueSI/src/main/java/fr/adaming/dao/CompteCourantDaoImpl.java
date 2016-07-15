package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.CompteCourant;

@Repository("compteCourantDao")
@Transactional
public class CompteCourantDaoImpl implements ICompteCourantDao {

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
	public void addCompteCourant(CompteCourant compteCourant) {
		Session session=sessionFactory.openSession();
		session.save(compteCourant);
		session.close();
	}

	@Override
	public void updateCompteCourant(CompteCourant compteCourant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCompteCourant(CompteCourant compteCourant) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CompteCourant> selectAllCompteCourants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteCourant findCompteCourantById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompteCourant> findCompteCourantByIdClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompteCourant> lowBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompteCourant> highBalance() {
		// TODO Auto-generated method stub
		return null;
	}

}
