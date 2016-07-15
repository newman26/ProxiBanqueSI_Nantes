package fr.adaming.ClassMain;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;





import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;


public class ClassTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/application-context.xml");
		
		IClientDao clientDao = (IClientDao) ctx.getBean("clientDao");
		IConseillerDao conseillerDao=(IConseillerDao) ctx.getBean("conseillerDao");

		Conseiller conseiller1=new Conseiller("Duboit", "Jean", "Cachan");
		conseillerDao.addConseiller(conseiller1);
		
		
		
		Client cl1=new Client("BOULMERDJ","Nomane","VilleJuif", 94800, "VilleJuif", "00000000");
		cl1.setConseiller(conseiller1);
		clientDao.addClient(cl1);

	}

}
