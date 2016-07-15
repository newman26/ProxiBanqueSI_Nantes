package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface IConseillerService {
	public void addConseiller(Conseiller conseiller);

	public  void updateConseiller(Conseiller conseiller);

	public void deleteConseiller(Conseiller conseiller);

	public  List<Conseiller> selectAllConseillers();

	public Conseiller findConseillerById(Long id);
}
