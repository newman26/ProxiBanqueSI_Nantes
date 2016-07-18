package fr.adaming.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.CompteEpargneDao;
import fr.adaming.exception.ExceptionSolde;
import fr.adaming.model.CompteEpargne;
import fr.adaming.service.CompteEpargneService;

@Service("compteEpargneService")
public class CompteEpargneServiceImpl implements CompteEpargneService {

	@Autowired
	private CompteEpargneDao compteEpargneDao;


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteEpargneService#add(fr.adaming.model.CompteEpargne)
	 */
	public void add(CompteEpargne compteEpargne) {
		compteEpargneDao.create(compteEpargne);

	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteEpargneService#update(fr.adaming.model.CompteEpargne)
	 */
	public void update(CompteEpargne compteEpargne) {
		compteEpargneDao.update(compteEpargne);

	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteEpargneService#delete(fr.adaming.model.CompteEpargne)
	 */
	public void delete(CompteEpargne compteEpargne) {
		compteEpargneDao.delete(compteEpargne);

	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteEpargneService#getAll()
	 */
	public List<CompteEpargne> getAll() {
		return  compteEpargneDao.selectAll();

	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteEpargneService#TakeMoney(float, java.lang.Long)
	 */
	public void TakeMoney(float solde, Long IdCompteEpargne) throws ExceptionSolde{
		CompteEpargne ce= compteEpargneDao.getById(IdCompteEpargne);
		float ccSolde=ce.getSolde() ;
		ccSolde= ccSolde-solde;


		if(	ccSolde < 0) {
			throw new ExceptionSolde("retrait interdit");
		}

		else{
			ce.setSolde(ccSolde);
			compteEpargneDao.update(ce);}


	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteEpargneService#addMoney(float, java.lang.Long)
	 */
	public void addMoney(float solde, Long IdCompteEpargne) {

		CompteEpargne ce= compteEpargneDao.getById(IdCompteEpargne);
		float ccSolde=ce.getSolde() ;
		ccSolde= ccSolde+solde;

		ce.setSolde(ccSolde);
		compteEpargneDao.update(ce);}

}


