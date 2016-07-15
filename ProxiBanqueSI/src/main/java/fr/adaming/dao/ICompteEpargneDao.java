package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.CompteEpargne;

public interface ICompteEpargneDao {

	public  void addCompteEpargne(CompteEpargne compteEpargne);

	public  void updateCompteEpargne(CompteEpargne compteEpargne);

	public  void deleteCompteEpargne(CompteEpargne compteEpargne);

	public  List<CompteEpargne> selectAllCompteEpargnes();

	public  CompteEpargne findCompteEpargneById(Long id);

	public List<CompteEpargne> findCompteEpargneByIdClient(int idClient);
}
