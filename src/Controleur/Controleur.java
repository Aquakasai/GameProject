package Controleur;
import IHM.JFrmMenu;
import Metier.GameGestion;
import Metier.Personnage;

public class Controleur {

	private JFrmMenu fr;
	private GameGestion gestion;
	public Controleur() {
		this.fr = new JFrmMenu(this);
	}
	
	public void lancerGame(Personnage[] p) {
		this.gestion = new GameGestion(p, this);
		this.fr.lancerGame(p);
	}
	
	
	public void reset(boolean b) {
		this.fr.reset(b);
		this.gestion.reset();
	}
	
	public void finAttack() {
		this.gestion.finAttack();
	}
	
	public void action(int action) {
		this.fr.action(action);
	}
	
	public void setPersoAttack(int persoAttack) {
		this.fr.setPersoAttack(persoAttack);
	}
	
	public void setPersoEstAttaquer(int i) {
		this.gestion.setPersoEstAttaquer(i);
	}
	
	public void attaquer() {
		this.fr.attaquer();
	}
	
	public void special() {
		this.fr.special();
	}
	
	public void trans() {
		this.fr.trans();
	}
	
	public void death() {
		this.fr.death();
	}
	
	public Personnage getPersoTour() {
		return this.gestion.getPersoTour();
	}
	
	public void verifVictoire() {
		this.gestion.verifVictoire();
	}
	
	public void changeValueBar() {
		this.fr.changeValueBar();
	}
	
	public void finDePartie() {
		this.fr.finDePartie();
	}
	
	
	public static void main(String[] args) {
		new Controleur();
	}
	
}
