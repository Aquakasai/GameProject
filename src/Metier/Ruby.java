package Metier;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Controleur.Controleur;
import IHM.ImgAdapt;
import IHM.UtilitaireImage;

public class Ruby extends Personnage {

	public Ruby(int pv, int mana, String nom, Controleur ctrl, int num, boolean revive) {
		super(pv, mana, nom, ctrl, num, revive);
		// TODO Auto-generated constructor stub
		this.setTypeSp(0);
	}

	@Override
	public void attaquer(Graphics2D g, Personnage p,int canvasWidth,int canvasHeight) {
		// TODO Auto-generated method stub
		Image i;
		try {
			if(this.frame < this.countFiles("Sprite/Ruby/Attaque/RubyVs"+p.getNom()) ) {
				if(this.frame < 10) {
					i = new ImageIcon("Sprite/Ruby/Attaque/RubyVs"+p.getNom()+"/RubyVs"+p.getNom()+"0"+this.frame+".png").getImage();
					ImgAdapt adpt = UtilitaireImage.backgroundSize(canvasWidth, canvasHeight, i);
					double p1 = adpt.getPourcentage();
					g.drawImage(i, adpt.getX1(), adpt.getY1(), (int)(i.getWidth(null)*p1),(int)(i.getHeight(null)*p1), null);
					//g.drawImage(i, adpt.getX1(), adpt.getY1(), adpt.getX2(), adpt.getY2(), 0, 0, i.getWidth(null), i.getHeight(null), null);
				} else {
					i = new ImageIcon("Sprite/Ruby/Attaque/RubyVs"+p.getNom()+"/RubyVs"+p.getNom()+""+this.frame+".png").getImage();
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
	public Image iddle() {
		// TODO Auto-generated method stub
		
		String fichier = "";
		if(! this.estMort()) {
			fichier = "Sprite/"+this.nom+"/Idle";
			try {
				if(this.frame >= this.countFiles(fichier) ) {
					this.frame = 0;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.frame++;
			Image i = new ImageIcon("Sprite/Ruby/Idle/IddleRuby"+this.frame+".png").getImage();
			this.tailleImgX = i.getWidth(null) *2;
			this.tailleImgY = i.getHeight(null)*2;
			return i;
		} else {
			fichier = "Sprite/"+this.nom+"/IdleDeath";
			try {
				if(this.frame >= this.countFiles(fichier) ) {
					this.frame = 0;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.frame++;
			Image i = new ImageIcon("Sprite/Ruby/IdleDeath/Idle"+this.frame+".png").getImage();
			this.tailleImgX = i.getWidth(null) *2;
			this.tailleImgY = i.getHeight(null)*2;
			return i;
		}
	}
	
	@Override
	public void special(Graphics2D g, Personnage p, int canvasWidth, int canvasHeight) {
		// TODO Auto-generated method stub
		Image i;
		try {
			if(this.frame < this.countFiles("Sprite/Ruby/Special/RubyVs"+p.getNom()) ) {
				if(this.frame < 10) {
					i = new ImageIcon("Sprite/Ruby/Special/RubyVs"+p.getNom()+"/RubyVs"+p.getNom()+"0"+this.frame+".png").getImage();
					ImgAdapt adpt = UtilitaireImage.backgroundSize(canvasWidth, canvasHeight, i);
					double p1 = adpt.getPourcentage();
					g.drawImage(i, adpt.getX1(), adpt.getY1(), (int)(i.getWidth(null)*p1),(int)(i.getHeight(null)*p1), null);
					//g.drawImage(i, adpt.getX1(), adpt.getY1(), adpt.getX2(), adpt.getY2(), 0, 0, i.getWidth(null), i.getHeight(null), null);
				} else {
					i = new ImageIcon("Sprite/Ruby/Special/RubyVs"+p.getNom()+"/RubyVs"+p.getNom()+""+this.frame+".png").getImage();
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

	@Override
	public void transform(Graphics2D g, int canvasWidth, int canvasHeight) {
		// TODO Auto-generated method stub
		
	}



}
