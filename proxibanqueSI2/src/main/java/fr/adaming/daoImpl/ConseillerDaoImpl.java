package fr.adaming.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ConseillerDao;
import fr.adaming.model.Conseiller;

@Repository("ConseillerDao")
@Transactional
public class ConseillerDaoImpl implements ConseillerDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}



	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ConseillerDao#create(fr.adaming.model.Conseiller)
	 */
	public void create(Conseiller conseiller) {
		getSession().save(conseiller);

	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ConseillerDao#update(fr.adaming.model.Conseiller)
	 */
	public void update(Conseiller conseiller) {
		getSession().update(conseiller);

	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ConseillerDao#delete(fr.adaming.model.Conseiller)
	 */
	public void delete(Conseiller conseiller) {
		getSession().delete(conseiller);

	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ConseillerDao#selectAll()
	 */
	public List<Conseiller> selectAll() {
		return getSession().createQuery("from Conseiller").list();
	}



	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ConseillerDao#getById(java.lang.Long)
	 */
	public Conseiller getById(Long id) {
		
		Conseiller c = (Conseiller) getSession().get(Conseiller.class, id);
		return c;
	}
	

}
