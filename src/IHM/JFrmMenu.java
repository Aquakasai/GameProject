package IHM;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Metier.Personnage;

public class JFrmMenu extends JFrame {
	private JPnlCombat combat;
	private JPnlButton button;
	private ChampSelect select;
	private JPanel     inter;
	private Controleur ctrl;
	public JFrmMenu(Controleur ctrl) {
		this.ctrl = ctrl;
		this.select = new ChampSelect(ctrl);
		this.add(this.select);
	
		//this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDefaultLookAndFeelDecorated(true);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	public void lancerGame(Personnage[] p) {
		inter = new JPanel();
		inter.setLayout(new BorderLayout());
		this.combat = new JPnlCombat(ctrl,p);
		this.button = new JPnlButton(ctrl);
		inter.add(this.button);
		this.remove(this.select);
		this.add(this.combat,BorderLayout.CENTER);
		this.add(inter,BorderLayout.SOUTH);
		this.validate();
	}
	
	public void finDePartie() {
		this.select = new ChampSelect(ctrl);
		this.remove(this.combat);
		this.remove(inter);
		this.add(select);
		this.validate();
		
	}
	
	public void attaquer() {
		this.combat.attaquer();
	}
	
	public void reset(boolean b) {
		this.button.setButton(b);
	}
	
	public void action(int action) {
		this.combat.action(action);
	}
	
	public void setPersoAttack(int persoAttack) {
		this.combat.setPersoAttack(persoAttack);
	}
	
	public void special() {
		this.combat.special();
	}
	
	public void trans() {
		this.combat.tranformation();
	}
	
	public void death() {
		this.combat.death();
	}
	
	public void changeValueBar() {
		this.button.changeValueBar();
	}
}
