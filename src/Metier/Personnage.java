package Metier;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;

import Controleur.Controleur;
import IHM.ImgAdapt;
import IHM.UtilitaireImage;

public abstract class Personnage {

	private int pvMax;
	private int pvAct;
	private int manaMax;
	private int manaAct;
	protected String nom;
	protected Controleur ctrl;
	protected boolean changement;
	protected int frame;
	protected int numPosition;
	protected boolean canRevive;
	protected int posX;
	protected int posY;
	protected int tailleImgX;
	protected int tailleImgY;
	protected double pourcentage;
	protected int typeSpecial;
	
	public Personnage(int pv, int mana, String nom, Controleur ctrl, int num, boolean canRevive ) {
		this.numPosition = num;
		this.pvAct = pv;
		this.pvMax = pv;
		this.manaAct = mana;
		this.manaMax = mana;
		this.nom = nom;
		this.ctrl = ctrl;
		this.changement = false;
		this.frame = 0;
		this.canRevive = canRevive;
		this.posX = 0;
		this.posY = 0;
		this.tailleImgX = 0;
		this.tailleImgY = 0;
		this.pourcentage = 1;
	}
	
	public void degatPris(int pv) {
		this.pvAct -= pv;
		if(this.pvAct < 0) {
			this.pvAct = 0;
		}
	}
	
	public boolean estMort() {
		return this.pvAct <= 0;
	}
	
	public void regen(int pv, boolean ressut) {
		if(! ressut) {
			if(pv > 0) {
				this.pvAct += pv;
				}
		} else {
			this.pvAct += pv;
		}
		
		if(this.pvAct > this.pvMax) {
			this.pvAct = this.pvMax;
		}
	}
	
	public void regenTotal() {
		this.pvAct = this.pvMax;
		this.manaAct = this.manaMax;
	}
	
	public void viderMana(int mana) {
		this.manaAct -= mana;
	}
	
	public void ResetFrame() {
		this.frame = 0;
	}
	
	public void death(Graphics2D g,int canvasWidth,int canvasHeight) {
		try {
			if(this.frame < this.countFiles("Sprite/"+this.getNom()+"/Death/") ) {
				Image i;
				i = new ImageIcon("Sprite/"+this.getNom()+"/Death/Death"+this.frame+".png").getImage();
				ImgAdapt adpt = UtilitaireImage.backgroundSize(canvasWidth, canvasHeight, i);
				double p1 = adpt.getPourcentage();
				g.drawImage(i, adpt.getX1(), adpt.getY1(), (int)(i.getWidth(null)*p1),(int)(i.getHeight(null)*p1), null);
				
			} else {
				this.frame = 0;
				this.ctrl.verifVictoire();
				this.ctrl.reset(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.frame++;
	}
	
	public abstract void attaquer(Graphics2D g, Personnage p, int canvasWidth,int canvasHeight);
	
	public abstract void special(Graphics2D g, Personnage p, int canvasWidth,int canvasHeight);
	
	public abstract Image iddle();
	
	public abstract void transform(Graphics2D g, int canvasWidth,int canvasHeight);
	
	public int countFiles (String parent) throws Exception {
	    File file = new File (parent);
	    
	    if (!file.exists ())
	        throw new FileNotFoundException ();
	    return file.list ().length;
	}
	
	
	/**********************************************************************Fonction Get ***********************************************************************************************/
	
	public String getNom() { return this.nom;}
	
	public boolean canRevive() { return this.canRevive; }
	
	public int getPosX() { return this.posX; }
	
	public int getPosY() { return this.posY; }
	
	public int getTImgX() { return this.tailleImgX; }
	
	public int getTImgY() { return this.tailleImgY; }
	
	public double getPourcentage() { return this.pourcentage; }
	
	public int getPvAct() {return this.pvAct;}
	
	public int getPvMax() {return this.pvMax;}
	
	public int getManaAct() {return this.manaAct;}
	
	public int getManaMax() {return this.manaMax;}
	
	public int getTypeSp() {return this.typeSpecial;}
	/**********************************************************************Fonction Set ************************************************************************************************/
	
	public void setRevive(boolean b) { this.canRevive = b; }
	
	public void setPosX(int posX) { this.posX = posX;}
	
	public void setPosY(int posY) { this.posY = posY;}
	
	public void setPourcentage(double pourcentage) { this.pourcentage = pourcentage;}
	
	public void setTypeSp(int typeSpecial) { this.typeSpecial = typeSpecial;}
	
}
