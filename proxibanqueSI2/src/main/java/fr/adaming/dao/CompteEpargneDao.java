package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.CompteEpargne;

public interface CompteEpargneDao {

	public  void create(CompteEpargne compteEpargne);

	public  void update(CompteEpargne compteEpargne);

	public  void delete(CompteEpargne compteEpargne);

	public  List<CompteEpargne> selectAll();

	public  CompteEpargne getById(Long id);

	public List<CompteEpargne> selectByIdClient(int idClient);

}