package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface ConseillerDao {

	public void create(Conseiller conseiller);

	public  void update(Conseiller conseiller);

	public void delete(Conseiller conseiller);

	public  List<Conseiller> selectAll();

	public Conseiller getById(Long id);

}