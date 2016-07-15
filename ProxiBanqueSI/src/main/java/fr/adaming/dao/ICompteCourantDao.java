package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.CompteCourant;

public interface ICompteCourantDao {

	public void addCompteCourant(CompteCourant compteCourant);

	public void updateCompteCourant(CompteCourant compteCourant);

	public void deleteCompteCourant(CompteCourant compteCourant);

	public  List<CompteCourant> selectAllCompteCourants();

	public CompteCourant findCompteCourantById(Long id);

	public  List<CompteCourant> findCompteCourantByIdClient(int idClient);
	

	public  List<CompteCourant> lowBalance();

	public List<CompteCourant> highBalance();
}
