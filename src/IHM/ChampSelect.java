package IHM;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Metier.Personnage;
import Metier.Ruby;
import Metier.Shadow;
import Metier.Sonic;
import Metier.Weiss;

public class ChampSelect extends JPanel implements ActionListener{
	
	private Personnage[] perso;
	private int num;
	private JPanel champ;
	private JButton btnSonic;
	private JButton btnShadow;
	private JButton btnRuby;
	private JButton btnWeiss;
	private Controleur ctrl;
	private JLabel[] tabLbl;
	
	
	public ChampSelect(Controleur ctrl) {
		this.setLayout(new BorderLayout());
		this.ctrl = ctrl;
		this.num = 0;
		this.tabLbl = new JLabel[4];
		for(int cpt = 0; cpt < this.tabLbl.length; cpt++) {
			this.tabLbl[cpt] = new JLabel();
		}
		this.perso = new Personnage[4];
		this.setLayout(new BorderLayout());
		this.champ = new JPanel();
		this.champ.setLayout(new GridLayout(2,2,20,20));
		this.btnSonic = new JButton();
		this.btnSonic.setIcon(new ImageIcon("Sprite/BtnImage/BtnSonic.png"));
		this.btnSonic.addActionListener(this);
		this.btnShadow = new JButton();
		this.btnShadow.setIcon(new ImageIcon("Sprite/BtnImage/BtnShadow.png"));
		this.btnShadow.addActionListener(this);
		this.btnRuby = new JButton();
		this.btnRuby.setIcon(new ImageIcon("Sprite/BtnImage/BtnRuby.png"));
		this.btnRuby.addActionListener(this);
		this.btnWeiss = new JButton();
		this.btnWeiss.setIcon(new ImageIcon("Sprite/BtnImage/BtnWeiss.png"));
		this.btnWeiss.addActionListener(this);
		this.champ.add(this.btnSonic);
		this.champ.add(this.btnShadow);
		this.champ.add(this.btnWeiss);
		this.champ.add(this.btnRuby);
		
		this.add(this.champ);
		JPanel b = new JPanel();
		b.add(this.tabLbl[0]);
		b.add(this.tabLbl[2]);
		b.setLayout(new GridLayout(2,1,25,25));
		this.add(b, BorderLayout.WEST);
		b = new JPanel();
		b.add(this.tabLbl[1]);
		b.add(this.tabLbl[3]);
		b.setLayout(new GridLayout(2,1,25,25));
		this.add(b, BorderLayout.EAST);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnSonic) {
			if(this.perso.length-1 == this.num) {
				this.perso[this.num] = new Sonic(150, 100, "Sonic", this.ctrl,this.num+1, true);
				this.tabLbl[this.num].setIcon(this.btnSonic.getIcon());
				ctrl.lancerGame(this.perso);
			} else {
				this.perso[this.num] = new Sonic(150, 100, "Sonic", this.ctrl,this.num+1, true);
				this.tabLbl[this.num].setIcon(this.btnSonic.getIcon());
				this.btnSonic.setEnabled(false);
				this.num++;
			}
		}
		
		if(e.getSource() == this.btnShadow) {
			if(this.perso.length-1 == this.num) {
				this.perso[this.num] = new Shadow(150, 100, "Shadow", this.ctrl,this.num+1, true);
				this.tabLbl[this.num].setIcon(this.btnShadow.getIcon());
				ctrl.lancerGame(this.perso);
			} else {
				this.perso[this.num] = new Shadow(150, 100, "Shadow", this.ctrl,this.num+1, true);
				this.tabLbl[this.num].setIcon(this.btnShadow.getIcon());
				this.btnShadow.setEnabled(false);
				this.num++;
			}
		}
		
		if(e.getSource() == this.btnWeiss) {
			if(this.perso.length-1 == this.num) {
				this.perso[this.num] = new Weiss(150, 100, "Weiss", this.ctrl,this.num+1, false);
				this.tabLbl[this.num].setIcon(this.btnWeiss.getIcon());
				ctrl.lancerGame(this.perso);
			} else {
				this.perso[this.num] = new Weiss(150, 100, "Weiss", this.ctrl,this.num+1, false);
				this.tabLbl[this.num].setIcon(this.btnWeiss.getIcon());
				this.btnWeiss.setEnabled(false);
				this.num++;
			}
		}
		
		if(e.getSource() == this.btnRuby) {
			if(this.perso.length-1 == this.num) {
				this.perso[this.num] = new Ruby(150, 100, "Ruby", this.ctrl,this.num+1, false);
				this.tabLbl[this.num].setIcon(this.btnRuby.getIcon());
				ctrl.lancerGame(this.perso);
			} else {
				this.perso[this.num] = new Ruby(150, 100, "Ruby", this.ctrl,this.num+1, false);
				this.tabLbl[this.num].setIcon(this.btnRuby.getIcon());
				this.btnRuby.setEnabled(false);
				this.num++;
			}
		}
	}
	
}
