package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;


@Repository("conseillerDao")
@Transactional
public class ConseillerDaoImpl implements IConseillerDao {

	
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
	public void addConseiller(Conseiller conseiller) {
		Session session=sessionFactory.openSession();
		session.save(conseiller);
		session.close();

	}

	@Override
	public void updateConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Conseiller> selectAllConseillers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conseiller findConseillerById(Long id) {
		Session session=sessionFactory.getCurrentSession();
		Conseiller conseiller=(Conseiller) session.get(Conseiller.class, id);
		return conseiller;
	}

}
