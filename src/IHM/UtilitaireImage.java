package IHM;
import java.awt.Image;

public class UtilitaireImage {

	public static double addaptSprite( int canvasHeight, Image img) {
		double pourcentage = 0.0;
		int recomandHeight = (int)(canvasHeight * 0.115);
		pourcentage = recomandHeight/(double)img.getHeight(null);
		
		
		return pourcentage;
	}
	
	public static ImgAdapt backgroundSize(int widthScreen, int heightScreen,Image img) {
		double pourcentage = 0.0;
		
		if(img.getWidth(null) >= widthScreen && heightScreen >= img.getHeight(null)) {
			pourcentage  = (double)widthScreen / img.getWidth(null);
		}
		
		if(img.getWidth(null) <= widthScreen && heightScreen <= img.getHeight(null)){
			pourcentage  = (double)heightScreen / img.getHeight(null);
		}
		
		if(img.getWidth(null) <= widthScreen && heightScreen >= img.getHeight(null) || img.getWidth(null) >= widthScreen && heightScreen <= img.getHeight(null)){
			
			if(widthScreen - img.getWidth(null) < heightScreen - img.getHeight(null)) {
				pourcentage  = (double)widthScreen / img.getWidth(null);
			} else {
				pourcentage  = (double)heightScreen / img.getHeight(null);
			}
		}
		
		int poX = (int) ((widthScreen - img.getWidth(null)* pourcentage)/2);
		int poY = (int) ((heightScreen - img.getHeight(null)* pourcentage)/2);
		return new ImgAdapt(poX,poY,pourcentage);
	}
}
