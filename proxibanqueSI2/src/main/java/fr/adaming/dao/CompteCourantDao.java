package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.CompteCourant;

public interface CompteCourantDao {

	public void create(CompteCourant compteCourant);

	public void update(CompteCourant compteCourant);

	public void delete(CompteCourant compteCourant);

	public  List<CompteCourant> selectAll();

	public CompteCourant getById(Long id);

	public  List<CompteCourant> lowBalance();

	public List<CompteCourant> highBalance();

	public  List<CompteCourant> selectByIdClient(int idClient);

}