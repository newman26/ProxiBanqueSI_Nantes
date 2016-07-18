package fr.adaming.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ConseillerDao;
import fr.adaming.model.Conseiller;
import fr.adaming.service.ConseillerService;

@Service
public class ConseillerServiceImpl implements ConseillerService{
	
	@Autowired
	private ConseillerDao conseillerDao;


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ConseillerService#add(fr.adaming.model.Conseiller)
	 */
	public void add(Conseiller conseiller) {
	conseillerDao.create(conseiller);
		
	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ConseillerService#update(fr.adaming.model.Conseiller)
	 */
	public void update(Conseiller conseiller) {
		conseillerDao.update(conseiller);
		
	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ConseillerService#delete(fr.adaming.model.Conseiller)
	 */
	public void delete(Conseiller conseiller) {
		conseillerDao.delete(conseiller);
		
	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ConseillerService#getAll()
	 */
	public List<Conseiller> getAll() {
		return conseillerDao.selectAll();
	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.ConseillerService#getById(java.lang.Long)
	 */
	public Conseiller getById(Long Id) {
		return conseillerDao.getById(Id);
	}
	
	

}
