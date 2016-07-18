package fr.adaming.daoImplTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import fr.adaming.dao.ClientDao;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ClientDaoImplTest {

	@Autowired
	ClientDao clientDao;
	
	
	@Test
	public void testSelectAll(){
		assertEquals(2, clientDao.selectAll().size());
		
	}

}
