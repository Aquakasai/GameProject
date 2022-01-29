package IHM;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import Controleur.Controleur;

public class JPnlButton extends JPanel implements ActionListener {

	private JButton btnAttack;
	private JButton btnSpe;
	private Controleur ctrl;
	private JProgressBar pv;
	private JProgressBar mana;
	
	public JPnlButton(Controleur ctrl) { 
		
		/*****************Create Bar***************************/
		UIManager.put("ProgressBar.background", Color.RED);
		UIManager.put("ProgressBar.foreground", Color.GREEN);
		this.pv = new JProgressBar(0,100);
		this.pv.setValue(100);
		UIManager.put("ProgressBar.foreground", Color.BLUE);
		this.mana = new JProgressBar(0,100);
		this.mana.setValue(100);
		/******************************************************/
		this.setLayout(new GridLayout(0,2));
		JPanel p = new JPanel();
		this.ctrl = ctrl;
		this.btnAttack = new JButton("Attack");
		this.btnAttack.addActionListener(this);
		this.btnSpe = new JButton("SPE");
		this.btnSpe.addActionListener(this);
		p.setBackground(Color.green);
		p.setLayout(new GridLayout(0,2));
		p.add(btnAttack);
		p.add(this.btnSpe);
		this.add(p);
		p = new JPanel();
		p.setLayout(new GridLayout(2,0));
		p.add(pv);
		p.add(mana);
		this.add(p);
	}
	
	
	public int getVieAct() {
		return 0;
	}
	
	public int getManaAct() {
		return 0;
	}
	
	public int getVieMax() {
		return 0;
	}
	
	public int getManaMax() {
		return 0; 
	}
	
	public void setButton(boolean b) {
		this.btnAttack.setEnabled(b);
		this.btnSpe.setEnabled(b);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnAttack) {
			this.btnAttack.setEnabled(false);
			this.btnSpe.setEnabled(false);
			ctrl.attaquer();
		}
		
		if(e.getSource() == this.btnSpe) {
			this.btnAttack.setEnabled(false);
			this.btnSpe.setEnabled(false);
			if(this.ctrl.getPersoTour().getTypeSp() == 0) {
				this.ctrl.special();
			} else {
				this.ctrl.trans();
			}
		}
		
	}
	
	public void changeValueBar() {
		double ratio = (double)this.ctrl.getPersoTour().getPvAct()/this.ctrl.getPersoTour().getPvMax();
		int pourcentage = (int)((ratio)*100);
		this.pv.setValue(pourcentage);
		
	}

}
