package fr.adaming.service;

import java.util.List;

import fr.adaming.model.CompteEpargne;

public interface ICompteEpargneService {
	public  void addCompteEpargne(CompteEpargne compteEpargne);

	public  void updateCompteEpargne(CompteEpargne compteEpargne);

	public  void deleteCompteEpargne(CompteEpargne compteEpargne);

	public  List<CompteEpargne> selectAllCompteEpargnes();

	public  CompteEpargne findCompteEpargneById(Long id);

	public List<CompteEpargne> findCompteEpargneByIdClient(int idClient);

}
