package Metier;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Controleur.Controleur;
import IHM.ImgAdapt;
import IHM.UtilitaireImage;

public class Shadow extends Personnage {
	public Shadow(int pv, int mana, String nom, Controleur ctrl,int num, boolean revive) {
		super(pv, mana, nom,ctrl, num, revive);
		// TODO Auto-generated constructor stub
		this.setTypeSp(0);
	}


	@Override
	public Image iddle() {
			
		String fichier = "";
		
		if(! this.estMort()) {
			fichier = "Sprite/"+this.nom+"/Idle";
		} else {
			fichier = "Sprite/"+this.nom+"/IdleDeath";
		}
		try {
			if(this.frame >= this.countFiles(fichier) ) {
				this.frame = 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.frame++;
		Image i = new ImageIcon(fichier+"/Idle"+this.frame+".png").getImage();
		this.tailleImgX = i.getWidth(null) *2;
		this.tailleImgY = i.getHeight(null)*2;
		return i;
	}

	@Override
	public void attaquer(Graphics2D g, Personnage p,int canvasWidth,int canvasHeight) {
		// TODO Auto-generated method stub
		try {
			Image i;
			if(this.frame < this.countFiles("Sprite/"+this.nom+"/Attaque/"+this.nom+"Vs"+p.getNom()) ) {
				if(this.frame < 10) {
					i = new ImageIcon("Sprite/"+this.nom+"/Attaque/"+this.nom+"Vs"+p.getNom()+"/"+this.nom+"Vs"+p.getNom()+"0"+this.frame+".png").getImage();
					ImgAdapt adpt = UtilitaireImage.backgroundSize(canvasWidth, canvasHeight, i);
					double p1 = adpt.getPourcentage();
					g.drawImage(i, adpt.getX1(), adpt.getY1(), (int)(i.getWidth(null)*p1),(int)(i.getHeight(null)*p1), null);
				} else {
					i = new ImageIcon("Sprite/"+this.nom+"/Attaque/"+this.nom+"Vs"+p.getNom()+"/"+this.nom+"Vs"+p.getNom()+""+this.frame+".png").getImage();
					ImgAdapt adpt = UtilitaireImage.backgroundSize(canvasWidth, canvasHeight, i);
					double p1 = adpt.getPourcentage();
					g.drawImage(i, adpt.getX1(), adpt.getY1(), (int)(i.getWidth(null)*p1),(int)(i.getHeight(null)*p1), null);
				}	
			} else {
				p.degatPris(25);
				this.frame = 0;
				this.ctrl.finAttack();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.frame++;	
	}
	
	@Override
	public void special(Graphics2D g, Personnage p, int canvasWidth, int canvasHeight) {
		// TODO Auto-generated method stub
		try {
			if(this.frame < this.countFiles("Sprite/"+this.nom+"/Special/"+this.nom+"Vs"+p.getNom()) ) {
				Image i;
				
				if(this.frame < 10) {
					i = new ImageIcon("Sprite/"+this.nom+"/Special/"+this.nom+"Vs"+p.getNom()+"/"+this.nom+"Vs"+p.getNom()+"0"+this.frame+".png").getImage();
					ImgAdapt adpt = UtilitaireImage.backgroundSize(canvasWidth, canvasHeight, i);
					double p1 = adpt.getPourcentage();
					g.drawImage(i, adpt.getX1(), adpt.getY1(), (int)(i.getWidth(null)*p1),(int)(i.getHeight(null)*p1), null);
				} else {
					i = new ImageIcon("Sprite/"+this.nom+"/Special/"+this.nom+"Vs"+p.getNom()+"/"+this.nom+"Vs"+p.getNom()+""+this.frame+".png").getImage();
					ImgAdapt adpt = UtilitaireImage.backgroundSize(canvasWidth, canvasHeight, i);
					double p1 = adpt.getPourcentage();
					g.drawImage(i, adpt.getX1(), adpt.getY1(), (int)(i.getWidth(null)*p1),(int)(i.getHeight(null)*p1), null);
				}	
			} else {
				p.degatPris(35);
				this.frame = 0;
				this.ctrl.finAttack();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.frame++;
	}
	
	public void resetFrame() {
		this.frame = 0;
	}


	@Override
	public void transform(Graphics2D g,int canvasWidth,int canvasHeight) {
		// TODO Auto-generated method stub
		try {
			Image i;
			if(this.frame < this.countFiles("Sprite/Shadow/Transform/") ) {
				if(this.frame < 10) {
					i = new ImageIcon("Sprite/Shadow/Transform/Transform"+"0"+this.frame+".png").getImage();
					ImgAdapt adpt = UtilitaireImage.backgroundSize(canvasWidth, canvasHeight, i);
					double p1 = adpt.getPourcentage();
					g.drawImage(i, adpt.getX1(), adpt.getY1(), (int)(i.getWidth(null)*p1),(int)(i.getHeight(null)*p1), null);
				} else {
					i = new ImageIcon("Sprite/Shadow/Transform/Transform"+""+this.frame+".png").getImage();
					ImgAdapt adpt = UtilitaireImage.backgroundSize(canvasWidth, canvasHeight, i);
					double p1 = adpt.getPourcentage();
					g.drawImage(i, adpt.getX1(), adpt.getY1(), (int)(i.getWidth(null)*p1),(int)(i.getHeight(null)*p1), null);
				}
			} else {
				super.setRevive(false);
				this.nom = "Super_Shadow";
				this.regenTotal();
				this.frame = 0;
				this.ctrl.reset(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.frame++;	
		
	}

}