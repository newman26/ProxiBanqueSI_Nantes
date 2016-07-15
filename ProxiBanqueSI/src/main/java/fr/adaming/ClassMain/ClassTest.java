package fr.adaming.ClassMain;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;










import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ICompteCourantDao;
import fr.adaming.dao.ICompteEpargneDao;
import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.Conseiller;


public class ClassTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/application-context.xml");
		
		IClientDao clientDao = (IClientDao) ctx.getBean("clientDao");
		IConseillerDao conseillerDao=(IConseillerDao) ctx.getBean("conseillerDao");
		ICompteCourantDao ccDao=(ICompteCourantDao) ctx.getBean("compteCourantDao");
		ICompteEpargneDao ceDao=(ICompteEpargneDao) ctx.getBean("compteEpargneDao");
		
		
		Conseiller conseiller1=new Conseiller("Duboit", "Jean", "Cachan");
		conseillerDao.addConseiller(conseiller1);
		
		
		
		Client cl1=new Client("BOULMERDJ","Nomane","VilleJuif", 94800, "VilleJuif", "00000000");
		cl1.setConseiller(conseiller1);
		clientDao.addClient(cl1);
		
		CompteCourant cc1=new CompteCourant("123344", 1234, new Date(),100, "carteCredit");
		
		cc1.setClient(cl1);
		
		ccDao.addCompteCourant(cc1);
		
		CompteEpargne ce1=new CompteEpargne("12345", 1234,new Date(),0.4f);
		ce1.setClient(cl1);
		
		ceDao.addCompteEpargne(ce1);	
		
		Client cl2=clientDao.findClientById(2);
		System.out.println(cl2.getConseiller());
		clientDao.deleteClient(cl2);
		

	}

}
