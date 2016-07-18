package fr.adaming.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.Conseiller;
import fr.adaming.service.ConseillerService;

@ManagedBean(name="conseillerBean")
@SessionScoped
@Component
public class ConseillerBean {

	@Autowired
	private ConseillerService conseillerService;
	
	private Conseiller conseiller;
	
	//********************constructeurs***************

	public ConseillerBean(ConseillerService conseillerService,
			Conseiller conseiller) {
		this.conseillerService = conseillerService;
		this.conseiller = conseiller;
	}

	public ConseillerBean() {
		conseiller=new Conseiller();
		}
	//*************getter setter*****************

	public ConseillerService getConseillerService() {
		return conseillerService;
	}

	public void setConseillerService(ConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	//*****************methodes****************************
	public void addConseiller(){
		conseillerService.add(conseiller);
		conseiller = new Conseiller();
		
	}
	
	public void deleteConseiller(){
		conseillerService.delete(conseiller);
		conseiller=new Conseiller();
	}
	
	public void updateConseiller(){
		conseillerService.update(conseiller);
			}
	
	public List<Conseiller> getConseillerList(){
		return conseillerService.getAll();
			}
	
	
}
