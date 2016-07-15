package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.CompteEpargne;


@Repository("compteEpargneDao")
@Transactional
public class CompteEpargneDaoImpl implements ICompteEpargneDao {

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
	public void addCompteEpargne(CompteEpargne compteEpargne) {
		Session session=sessionFactory.openSession();
		session.save(compteEpargne);
		session.close();
	}

	@Override
	public void updateCompteEpargne(CompteEpargne compteEpargne) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCompteEpargne(CompteEpargne compteEpargne) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CompteEpargne> selectAllCompteEpargnes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteEpargne findCompteEpargneById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompteEpargne> findCompteEpargneByIdClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

}
