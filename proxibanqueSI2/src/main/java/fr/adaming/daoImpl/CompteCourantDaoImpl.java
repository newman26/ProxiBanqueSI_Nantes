package fr.adaming.daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.CompteCourantDao;
import fr.adaming.model.CompteCourant;

@Repository("compteCourantDao")
@Transactional
public class CompteCourantDaoImpl implements CompteCourantDao{

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
}
	

	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteCourantDao#create(fr.adaming.model.CompteCourant)
	 */
	public void create(CompteCourant compteCourant) {
		compteCourant.setDateCreation(new Date());
		getSession().save(compteCourant);
				
		
	}

	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteCourantDao#update(fr.adaming.model.CompteCourant)
	 */
	public void update(CompteCourant compteCourant) {

		getSession().update(compteCourant);
		
	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteCourantDao#delete(fr.adaming.model.CompteCourant)
	 */
	public void delete(CompteCourant compteCourant) {
		getSession().delete(compteCourant);
		
	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteCourantDao#selectAll()
	 */
	public List<CompteCourant> selectAll() {
		return getSession().createQuery("from CompteCourant").list();
		
	}
	

	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteCourantDao#getById(java.lang.Long)
	 */
	public CompteCourant getById(Long id) {
		
		CompteCourant cc = (CompteCourant) getSession().get(CompteCourant.class, id);
		return cc;
	}
	
	
	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteCourantDao#lowBalance()
	 */
	public List<CompteCourant> lowBalance() {
		
		return getSession().createQuery("SELECT cc FROM CompteCourant cc  WHERE cc.solde < 0").list();
	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteCourantDao#highBalance()
	 */
	public List<CompteCourant> highBalance() {
		return getSession().createQuery("SELECT cc FROM CompteCourant cc  WHERE cc.solde > 500000 ").list();
	}
	

	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.CompteCourantDao#selectByIdClient(int)
	 */
	public List<CompteCourant> selectByIdClient(int idClient) {
		return getSession().createQuery("SELECT cc FROM CompteCourant cc  WHERE cc.Id_Client=?").setParameter(0,idClient).list();
	}

}
