package fr.adaming.classMain;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.dao.ClientDao;
import fr.adaming.model.Client;

public class ClassMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
		
		ClientDao ccDao = (ClientDao) ctx.getBean("ClientDao");
List<Client> clients= new ArrayList<Client>();

				// Get All comptes courants + affichage console
				clients = ccDao.selectAll();
				for (Client cc : clients) {
				System.out.println(cc.getId() +"  "+ cc.getNom()+"  "+
				cc.getPrenom());
				 }

	}

}
