package IHM;
import java.awt.Image;

public class ImgAdapt {

	private int x1;
	private int y1;
	private double pourcentage;
	
	public ImgAdapt(int x1, int y1, double pourcentage) {
		this.x1 = x1;
		this.y1 = y1;
		this.pourcentage = pourcentage;
	}
	
	public int getX1() { return this.x1;}
	
	
	public int getY1() { return this.y1;}
	
	
	public double getPourcentage() {return this.pourcentage;}
	
}
