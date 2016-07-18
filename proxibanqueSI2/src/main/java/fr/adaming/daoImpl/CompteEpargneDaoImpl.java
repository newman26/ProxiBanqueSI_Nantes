package fr.adaming.daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.CompteEpargneDao;
import fr.adaming.model.CompteEpargne;

@Repository("compteEpargneDao")
@Transactional
public class CompteEpargneDaoImpl implements CompteEpargneDao{

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
}
	

	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteEpargneDao#create(fr.adaming.model.CompteEpargne)
	 */
	public void create(CompteEpargne compteEpargne)  {
		compteEpargne.setDateCreation(new Date());
		getSession().save(compteEpargne);
				
		
	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteEpargneDao#update(fr.adaming.model.CompteEpargne)
	 */
	public void update(CompteEpargne compteEpargne)  {
		getSession().update(compteEpargne);
		
	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteEpargneDao#delete(fr.adaming.model.CompteEpargne)
	 */
	public void delete(CompteEpargne compteEpargne)  {
		getSession().delete(compteEpargne);
		
	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteEpargneDao#selectAll()
	 */
	public List<CompteEpargne> selectAll() {
		return getSession().createQuery("from CompteEpargne").list();
		
	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteEpargneDao#getById(java.lang.Long)
	 */
	public CompteEpargne getById(Long id) {
		CompteEpargne ce = (CompteEpargne) getSession().get(CompteEpargne.class, id);
		return ce;
	}
	
	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteEpargneDao#selectByIdClient(int)
	 */
	public List<CompteEpargne> selectByIdClient(int idClient) {
		return getSession().createQuery("SELECT ce FROM CompteEpargne ce  WHERE ce.Id_Client=?").setParameter(0,idClient).list();
	}
}
