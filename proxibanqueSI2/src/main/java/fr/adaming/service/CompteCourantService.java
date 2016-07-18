package fr.adaming.service;

import java.util.List;

import fr.adaming.exception.ExceptionSolde;
import fr.adaming.model.CompteCourant;

public interface CompteCourantService {

	public  void add(CompteCourant compteCourant);

	public  void update(CompteCourant compteCourant);

	public  void delete(CompteCourant compteCourant);

	public List<CompteCourant> getAll();

	//**************************modif*******

	public  void TakeMoney(float solde, Long IdComptecourant)
			throws ExceptionSolde;

	public  void addMoney(float solde, Long idComptecourant);

	public  List<CompteCourant> lowBalance();

	public  List<CompteCourant> highBalance();

}
