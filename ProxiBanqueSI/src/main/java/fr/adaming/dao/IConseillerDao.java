package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface IConseillerDao {

	public void addConseiller(Conseiller conseiller);

	public  void updateConseiller(Conseiller conseiller);

	public void deleteConseiller(Conseiller conseiller);

	public  List<Conseiller> selectAllConseillers();

	public Conseiller findConseillerById(Long id);
	
}
