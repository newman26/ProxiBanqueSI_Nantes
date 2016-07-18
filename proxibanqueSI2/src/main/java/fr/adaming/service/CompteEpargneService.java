package fr.adaming.service;

import java.util.List;

import fr.adaming.exception.ExceptionSolde;
import fr.adaming.model.CompteEpargne;

public interface CompteEpargneService {

	public  void add(CompteEpargne compteEpargne);

	public void update(CompteEpargne compteEpargne);

	public void delete(CompteEpargne compteEpargne);

	public List<CompteEpargne> getAll();

	public  void TakeMoney(float solde, Long IdCompteEpargne)
			throws ExceptionSolde;

	public void addMoney(float solde, Long IdCompteEpargne);

}
