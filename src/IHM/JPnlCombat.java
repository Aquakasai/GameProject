package IHM;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Metier.Personnage;

public class JPnlCombat extends JPanel implements MouseListener{
	
	Controleur ctrl;
	private Personnage[] perso;
	private ThrDessin des;
	private int action;
	private int persoAttack;
	private int estAttaque;
	private int index;
	private boolean change;
	private ArrayList<Integer> turnGes;
	private int x2;
	private int y2;
	private int typeAttack;
	
	public JPnlCombat(Controleur ctrl,Personnage[] p) {
		this.ctrl = ctrl;
		this.action = 0;
		this.perso = p;
		this.persoAttack = 0;
		this.estAttaque = 0;
		this.des = new ThrDessin(this);
		this.des.start();
		this.x2 = 0;
		this.y2 = 0;
		this.typeAttack = 0;
	}
	
/*-------------------------------------------------------------Draw gestion------------------------------------------------------------*/	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform old = g2d.getTransform();
		
		if(action == 0)
		{
			Image img  = new ImageIcon("Sprite/Background.png").getImage();
			ImgAdapt adpt = UtilitaireImage.backgroundSize(this.getWidth(), this.getHeight(), img);
			double pourcentage = adpt.getPourcentage();
			this.x2 = (int)(img.getWidth(null)*pourcentage);
			this.y2 = (int)(img.getHeight(null)*pourcentage);
	        g2d.drawImage(img, adpt.getX1(),adpt.getY1(),this.x2,this.y2, null);
			g.setColor(Color.BLACK);
			/*****************************************************************Idle*****************************************************************/
			if(this.persoAttack == 0) {
				int x[] = {this.perso[0].getPosX()+(int)(this.x2*0.0275),this.perso[0].getPosX()+(int)(this.x2*0.0275)-(int)(this.x2*0.015),this.perso[0].getPosX()+(int)(this.x2*0.0275)+(int)(this.x2*0.015)};
				int y[] = {this.perso[0].getPosY()-(int)((this.y2*0.02)*6),this.perso[0].getPosY()-(int)((this.y2*0.02)*6.5),this.perso[0].getPosY()-(int)((this.y2*0.02)*6.5)};
				g.fillPolygon(x, y, 3);
			}
			
			if(this.persoAttack == 1) {
				int x[] = {this.perso[1].getPosX()-(int)(this.x2*0.0275),this.perso[1].getPosX()-(int)(this.x2*0.0275)-(int)(this.x2*0.015),this.perso[1].getPosX()-(int)(this.x2*0.0275)+(int)(this.x2*0.015)};
				int y[] = {this.perso[1].getPosY()-(int)((this.y2*0.02)*6),this.perso[1].getPosY()-(int)((this.y2*0.02)*6.5),this.perso[1].getPosY()-(int)((this.y2*0.02)*6.5)};
				g.fillPolygon(x, y, 3);
			}
			
			if(this.persoAttack == 2) {
				int x[] = {this.perso[2].getPosX()+(int)(this.x2*0.0275),this.perso[2].getPosX()+(int)(this.x2*0.0275)-(int)(this.x2*0.015),this.perso[2].getPosX()+(int)(this.x2*0.0275)+(int)(this.x2*0.015)};
				int y[] = {this.perso[2].getPosY()-(int)((this.y2*0.02)*6),this.perso[2].getPosY()-(int)((this.y2*0.02)*6.5),this.perso[2].getPosY()-(int)((this.y2*0.02)*6.5)};
				g.fillPolygon(x, y, 3);
			}
			
			if(this.persoAttack == 3) {
				int x[] = {this.perso[3].getPosX()-(int)(this.x2*0.0275),this.perso[3].getPosX()-(int)(this.x2*0.0275)-(int)(this.x2*0.015),this.perso[3].getPosX()-(int)(this.x2*0.0275)+(int)(this.x2*0.015)};
				int y[] = {this.perso[3].getPosY()-(int)((this.y2*0.02)*6),this.perso[3].getPosY()-(int)((this.y2*0.02)*6.5),this.perso[3].getPosY()-(int)((this.y2*0.02)*6.5)};
				g.fillPolygon(x, y, 3);
			}
			/***************************************************************Personnage 1 *********************************************************************************/
			this.perso[0].setPosX((int)(this.x2*0.15)+adpt.getX1());
			this.perso[0].setPosY((int)(this.y2*0.75)+adpt.getY1());
			/***********************************************************Affichage des point de vie et mana ***************************************************************/
			double ratio = (double)this.perso[0].getPvAct()/this.perso[0].getPvMax();
			g.setColor(Color.red);
			g.fillRect(this.perso[0].getPosX(), this.perso[0].getPosY()-(int)((this.y2*0.013)*4), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.green);
			g.fillRect(this.perso[0].getPosX(), this.perso[0].getPosY()-(int)((this.y2*0.013)*4), (int)((this.x2*0.055)*ratio), (int)(this.y2*0.013));
			g.setColor(Color.black);
			g.drawRect(this.perso[0].getPosX(), this.perso[0].getPosY()-(int)((this.y2*0.013)*4), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.blue);
			g.fillRect(this.perso[0].getPosX(), this.perso[0].getPosY()-(int)((this.y2*0.013)*3), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.black);
			g.drawRect(this.perso[0].getPosX(), this.perso[0].getPosY()-(int)((this.y2*0.013)*3), (int)(this.x2*0.055), (int)(this.y2*0.013));
			/*************************************************************************************************************************************************************/
			Image i = perso[0].iddle();
			pourcentage = UtilitaireImage.addaptSprite(this.y2, i);
			this.perso[0].setPourcentage(pourcentage);
			g2d.drawImage(i, this.perso[0].getPosX(), this.perso[0].getPosY(),(int)(i.getWidth(null)*pourcentage),(int)(i.getHeight(null)*pourcentage), null);
			/***************************************************************Personnage 2 *********************************************************************************/
			this.perso[1].setPosX((int)(this.x2*0.65)+adpt.getX1());
			this.perso[1].setPosY((int)(this.y2*0.75)+adpt.getY1());
			/***********************************************************Affichage des point de vie et mana ***************************************************************/
			ratio = (double)this.perso[1].getPvAct()/this.perso[1].getPvMax();
			g.setColor(Color.red);
			g.fillRect(this.perso[1].getPosX()-this.perso[1].getTImgX(), this.perso[1].getPosY()-(int)((this.y2*0.013)*4), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.green);
			g.fillRect(this.perso[1].getPosX()-this.perso[1].getTImgX(), this.perso[1].getPosY()-(int)((this.y2*0.013)*4), (int)((this.x2*0.055)*ratio), (int)(this.y2*0.013));
			g.setColor(Color.black);
			g.drawRect(this.perso[1].getPosX()-this.perso[1].getTImgX(), this.perso[1].getPosY()-(int)((this.y2*0.013)*4), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.blue);
			g.fillRect(this.perso[1].getPosX()-this.perso[1].getTImgX(), this.perso[1].getPosY()-(int)((this.y2*0.013)*3), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.black);
			g.drawRect(this.perso[1].getPosX()-this.perso[1].getTImgX(), this.perso[1].getPosY()-(int)((this.y2*0.013)*3), (int)(this.x2*0.055), (int)(this.y2*0.013));
			/*************************************************************************************************************************************************************/
			i = perso[1].iddle();
			pourcentage = UtilitaireImage.addaptSprite(this.y2, i);
			this.perso[1].setPourcentage(pourcentage);
			g2d.drawImage(i, this.perso[1].getPosX(), this.perso[1].getPosY(),-(int)(i.getWidth(null)*pourcentage),(int)(i.getHeight(null)*pourcentage), null);
			/***************************************************************Personnage 3 *********************************************************************************/
			this.perso[2].setPosX((int)(this.x2*0.35)+adpt.getX1());
			this.perso[2].setPosY((int)(this.y2*0.75)+adpt.getY1());
			/***********************************************************Affichage des point de vie et mana ***************************************************************/
			ratio = (double)this.perso[2].getPvAct()/this.perso[2].getPvMax();
			g.setColor(Color.red);
			g.fillRect(this.perso[2].getPosX(), this.perso[2].getPosY()-(int)((this.y2*0.013)*4), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.green);
			g.fillRect(this.perso[2].getPosX(), this.perso[2].getPosY()-(int)((this.y2*0.013)*4), (int)((this.x2*0.055)*ratio), (int)(this.y2*0.013));
			g.setColor(Color.black);
			g.drawRect(this.perso[2].getPosX(), this.perso[2].getPosY()-(int)((this.y2*0.013)*4), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.blue);
			g.fillRect(this.perso[2].getPosX(), this.perso[2].getPosY()-(int)((this.y2*0.013)*3), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.black);
			g.drawRect(this.perso[2].getPosX(), this.perso[2].getPosY()-(int)((this.y2*0.013)*3), (int)(this.x2*0.055), (int)(this.y2*0.013));
			/*************************************************************************************************************************************************************/
			i = perso[2].iddle();
			pourcentage = UtilitaireImage.addaptSprite(this.y2, i);
			this.perso[2].setPourcentage(pourcentage);
			g2d.drawImage(i, this.perso[2].getPosX(), this.perso[2].getPosY(),(int)(i.getWidth(null)*pourcentage),(int)(i.getHeight(null)*pourcentage), null);
			/***************************************************************Personnage 4 *********************************************************************************/
			this.perso[3].setPosX((int)(this.x2*0.85)+adpt.getX1());
			this.perso[3].setPosY((int)(this.y2*0.75)+adpt.getY1());
			/***********************************************************Affichage des point de vie et mana ***************************************************************/
			ratio = (double)this.perso[3].getPvAct()/this.perso[3].getPvMax();
			g.setColor(Color.red);
			g.fillRect(this.perso[3].getPosX()-this.perso[3].getTImgX(), this.perso[3].getPosY()-(int)((this.y2*0.013)*4), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.green);
			g.fillRect(this.perso[3].getPosX()-this.perso[3].getTImgX(), this.perso[3].getPosY()-(int)((this.y2*0.013)*4), (int)((this.x2*0.055)*ratio), (int)(this.y2*0.013));
			g.setColor(Color.black);
			g.drawRect(this.perso[3].getPosX()-this.perso[3].getTImgX(), this.perso[3].getPosY()-(int)((this.y2*0.013)*4), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.blue);
			g.fillRect(this.perso[3].getPosX()-this.perso[3].getTImgX(), this.perso[3].getPosY()-(int)((this.y2*0.013)*3), (int)(this.x2*0.055), (int)(this.y2*0.013));
			g.setColor(Color.black);
			g.drawRect(this.perso[3].getPosX()-this.perso[3].getTImgX(), this.perso[3].getPosY()-(int)((this.y2*0.013)*3), (int)(this.x2*0.055), (int)(this.y2*0.013));
			/*************************************************************************************************************************************************************/
			i = perso[3].iddle();
			pourcentage = UtilitaireImage.addaptSprite(this.y2, i);
			this.perso[3].setPourcentage(pourcentage);
			g2d.drawImage(i, this.perso[3].getPosX(), this.perso[3].getPosY(),-(int)(i.getWidth(null)*pourcentage),(int)(i.getHeight(null)*pourcentage), null);
			
		}
		
		if(action == 1) {
			perso[this.persoAttack].attaquer(g2d, perso[this.estAttaque], this.getWidth(), this.getHeight());
		}
		if(action == 2) {
			perso[this.persoAttack].special(g2d, perso[this.estAttaque], this.getWidth(), this.getHeight());
		}
		if(action == 3) {
			perso[this.persoAttack].special(g2d, null, this.getWidth(), this.getHeight());
		}
		
		if(action == 4) {
			perso[this.estAttaque].transform(g2d,this.getWidth(), this.getHeight());
		}
		
		if(action == 5) {
			perso[this.estAttaque].death(g2d,this.getWidth(), this.getHeight());
		}
		
		g2d.setTransform(old);
		g2d.dispose();
		g.dispose();
		Toolkit.getDefaultToolkit().sync();
	}
	
	
/*------------------------------------------------------Gestion game-----------------------------------------------------------------------*/
	
	public void action(int action) {
		
		this.action = action;
	}
	
	public void setPersoAttack(int persoAttack) {
		this.persoAttack = persoAttack;
	}
	
	
	public void attaquer() {
		this.typeAttack = 0;
		this.addMouseListener(this);
	}
	
	public void tranformation() {
		this.perso[this.persoAttack].ResetFrame();
		this.action = 3;
	}
	
	public void special() {
		this.typeAttack = 1;
		this.addMouseListener(this);
	}
	
	public void death() {
		this.perso[this.estAttaque].ResetFrame();
		this.action = 5;
	}

/*-----------------------------------------------------------------------------------------------------------------------------------------*/	
/*--------------------------------------------------Gestion Event--------------------------------------------------------------------------*/
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(persoAttack == 0 || persoAttack == 2) {
			
			if((e.getX() < this.perso[1].getPosX() && e.getX() > this.perso[1].getPosX() - (int)(this.perso[1].getTImgX()*(this.perso[1].getPourcentage())) && ((e.getY() > this.perso[1].getPosY() && e.getY() < this.perso[1].getPosY()+ (int)((this.perso[1].getTImgY()*this.perso[1].getPourcentage())))))) {
				if(!this.perso[1].estMort()) {
					this.estAttaque = 1;
					this.ctrl.setPersoEstAttaquer(1);
					this.perso[this.persoAttack].ResetFrame();
					if(this.typeAttack == 0) {
						this.action = 1; //Attaque Normale 
					}
					if(this.typeAttack == 1) {
						this.action = 2; // Attaque Sp�cial
					}
					
					this.removeMouseListener(this);
				}
			}
			
			if((e.getX() < this.perso[3].getPosX() && e.getX() > this.perso[3].getPosX() - (int)((this.perso[3].getTImgX()*this.perso[3].getPourcentage()))) && ((e.getY() > this.perso[3].getPosY() && e.getY() < this.perso[3].getPosY()+ (int)((this.perso[3].getTImgY()*this.perso[3].getPourcentage()))))) {
				if(!this.perso[3].estMort()) {
					this.estAttaque = 3;
					this.ctrl.setPersoEstAttaquer(3);
					this.perso[this.persoAttack].ResetFrame();
					if(this.typeAttack == 0) {
						this.action = 1;//Attaque Normale 
					}
					if(this.typeAttack == 1) {
						this.action = 2;//Attaque Sp�cial
					}
					this.removeMouseListener(this);
				}
			}
		}
		
		if(persoAttack == 1 || persoAttack == 3) {
			
			if((e.getX() > this.perso[0].getPosX() && e.getX() < this.perso[0].getPosX()+ (int)((this.perso[0].getTImgX()*this.perso[0].getPourcentage()))) && ((e.getY() > this.perso[0].getPosY() && e.getY() < this.perso[0].getPosY()+ (int)((this.perso[0].getTImgY()*this.perso[0].getPourcentage()))))) {
				if(!this.perso[0].estMort()) {
					this.estAttaque = 0;
					this.ctrl.setPersoEstAttaquer(0);
					this.perso[this.persoAttack].ResetFrame();
					if(this.typeAttack == 0) {
						this.action = 1; //Attaque Normale 
					}
					if(this.typeAttack == 1) {
						this.action = 2;//Attaque Sp�cial
					}
					this.removeMouseListener(this);
				}
				
			}

			if((e.getX() > this.perso[2].getPosX() && e.getX() < this.perso[2].getPosX()+ (int)((this.perso[2].getTImgX()*this.perso[2].getPourcentage()))) && ((e.getY() > this.perso[2].getPosY() && e.getY() < this.perso[2].getPosY()+ (int)((this.perso[2].getTImgY()*this.perso[2].getPourcentage()))))) {
				if(!this.perso[2].estMort()) {
					this.estAttaque = 2;
					this.ctrl.setPersoEstAttaquer(2);
					this.perso[this.persoAttack].ResetFrame();
					if(this.typeAttack == 0) {
						this.action = 1;//Attaque Normale 
					}
					if(this.typeAttack == 1) {
						this.action = 2;//Attaque Sp�cial
					}
					this.removeMouseListener(this);
				}
				
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
