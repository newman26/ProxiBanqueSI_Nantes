package fr.adaming.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.CompteCourantDao;
import fr.adaming.exception.ExceptionSolde;
import fr.adaming.model.CompteCourant;
import fr.adaming.service.CompteCourantService;

@Service("compteCourantService")
public class CompteCourantServiceImpl implements CompteCourantService {


	@Autowired
	private CompteCourantDao compteCourantDao;


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteCourantService#add(fr.adaming.model.CompteCourant)
	 */
	public void add(CompteCourant compteCourant) {
		compteCourantDao.create(compteCourant);

	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteCourantService#update(fr.adaming.model.CompteCourant)
	 */
	public void update(CompteCourant compteCourant) {
		compteCourantDao.update(compteCourant);

	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteCourantService#delete(fr.adaming.model.CompteCourant)
	 */
	public void delete(CompteCourant compteCourant) {
		compteCourantDao.delete(compteCourant);

	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteCourantService#getAll()
	 */
	public List<CompteCourant> getAll() {
		System.out.println("------------c'est passé------------");
		return  compteCourantDao.selectAll();

	}
	//**************************modif*******

	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteCourantService#TakeMoney(float, java.lang.Long)
	 */
	public void TakeMoney(float solde, Long IdComptecourant) throws ExceptionSolde{
		CompteCourant cc = compteCourantDao.getById(IdComptecourant);
		float ccSolde=cc.getSolde() ;
		ccSolde= ccSolde-solde;


		if(	ccSolde < cc.getDecouvertAuto()) {
			throw new ExceptionSolde("le solde est trop bas");
		}

		else{
			cc.setSolde(ccSolde);
			compteCourantDao.update(cc);}


	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteCourantService#addMoney(float, java.lang.Long)
	 */
	public void addMoney(float solde, Long idComptecourant) {

		CompteCourant cc = compteCourantDao.getById(idComptecourant);
		float ccSolde=cc.getSolde() ;
		ccSolde= ccSolde+solde;

		cc.setSolde(ccSolde);
		compteCourantDao.update(cc);}
	
	
	//*****************************Modif*************************************
	//******************************************************************************

	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteCourantService#lowBalance()
	 */
	public List<CompteCourant> lowBalance() {
		return compteCourantDao.lowBalance();
	}


	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.CompteCourantService#highBalance()
	 */
	public List<CompteCourant> highBalance() {
		return compteCourantDao.highBalance();
	}
	
	
	
	
	

}
