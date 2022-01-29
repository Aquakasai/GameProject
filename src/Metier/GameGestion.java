package Metier;

import java.util.ArrayList;

import Controleur.Controleur;
import IHM.ThrDessin;

public class GameGestion {
	

	private Controleur ctrl;
	private Personnage[] perso;
	private ThrDessin des;
	private int persoAttack;
	private int estAttaque;
	private int index;
	private boolean change;
	private ArrayList<Integer> turnGes;
	
	public GameGestion(Personnage[] p, Controleur ctrl) {
		this.ctrl = ctrl;
		this.perso = p;
		this.persoAttack = 0;
		this.estAttaque = 0;
		this.createTurnGestion();
	}
	
	private void createTurnGestion() {
		this.index = 0;
		this.turnGes = new ArrayList<Integer>();
		this.turnGes.add(0);
		this.turnGes.add(1);
		this.turnGes.add(2);
		this.turnGes.add(3);
	}

	public void reset()
	{
		//Gestion des dégat  
		this.ctrl.action(0);
		this.index++;
		if(this.index >= this.turnGes.size()) {
			this.index = 0;
		}
		this.persoAttack = this.turnGes.get(this.index);
		this.ctrl.changeValueBar();
		this.ctrl.setPersoAttack(this.persoAttack);
	}
	
	public void finAttack() {
		this.ctrl.action(0);
		if(this.perso[this.estAttaque].estMort()) {
			if(this.perso[this.estAttaque].canRevive()) {
				this.perso[this.estAttaque].ResetFrame();
				this.ctrl.action(4);
			} else {
				this.ctrl.death();
			}
		} else {
			this.ctrl.reset(true);
		}
	}
	
	
	public void verifVictoire() {
		if(perso[0].estMort() && perso[2].estMort() ) {
			this.ctrl.finDePartie();
		} else {
			if(perso[1].estMort() && perso[3].estMort() ) {
				this.ctrl.finDePartie();
			} else {
				this.turnGes.remove(this.estAttaque);
			}
		}
	}
	
	public Personnage getPersoTour() {
		return this.perso[this.persoAttack];
	}
	
	public void setPersoEstAttaquer(int i) {
		this.estAttaque = i;
	}
}
