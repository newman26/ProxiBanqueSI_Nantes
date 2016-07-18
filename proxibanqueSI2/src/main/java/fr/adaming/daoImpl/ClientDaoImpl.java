package fr.adaming.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ClientDao;
import fr.adaming.model.Client;


@Repository("ClientDao")
@Transactional
public class ClientDaoImpl implements ClientDao{
	// LOGGER
	//private static final Logger log = Logger.getLogger(ClientDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ClientDao#create(fr.adaming.model.Client)
	 */
	public void create(Client client) {
		getSession().save(client);

	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ClientDao#update(fr.adaming.model.Client)
	 */
	public void  update(Client client) {
		System.out.println("--------3-----------------");
		getSession().update(client);
	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ClientDao#delete(fr.adaming.model.Client)
	 */
	public void delete(Client client) {
		getSession().delete(client);

	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ClientDao#selectAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Client> selectAll() {
		
		List<Client> liste=	getSession().createQuery("from Client").list();
		//log.info("insert::" + liste.size());
		return liste;
	}


	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ClientDao#selectByIdConseiller(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	public List<Client> selectByIdConseiller(Long idConseiller) {
		return getSession().createQuery("SELECT c FROM Client c WHERE c.conseiller.idConseiller=?").setParameter(0, idConseiller).list();
	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ClientDao#findClientById(int)
	 */
	public Client findClientById(int id) {
		Client client=(Client) getSession().get(Client.class, id);

		return  client;
	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.daoImpl.ClientDao#findClientByNomAndPrenom(java.lang.String, java.lang.String)
	 */
	public List<Client> findClientByNomAndPrenom(String nom,String prenom) {
		String hql = "from Client c where c.nom = ? and c.prenom = ? ";
		List<Client> result=getSession().createQuery(hql).setParameter(0, nom).setParameter(1, prenom).list();

		for(Client arr : result){
//
//			System.out.println("\n=======================================================");
//			System.out.println(arr.toString());
		}

		//query.setMaxResults(1); return list.get(0);
		return null;


	}

}

