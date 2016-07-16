package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Conseiller;

@Service("conseillerService")
public class ConseillerServiceImpl implements IConseillerService {

	@Autowired
	IConseillerDao conseillerDao;

	
	public IConseillerDao getConseillerDao() {
		return conseillerDao;
	}

	public void setConseillerDao(IConseillerDao conseillerDao) {
		this.conseillerDao = conseillerDao;
	}

	@Override
	public void addConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub

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
		return conseillerDao.findConseillerById(id);
	}

}
