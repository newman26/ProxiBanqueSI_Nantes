package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface ConseillerService {

	public  void add(Conseiller conseiller);

	public void update(Conseiller conseiller);

	public void delete(Conseiller conseiller);

	public  List<Conseiller> getAll();

	public  Conseiller getById(Long Id);

}