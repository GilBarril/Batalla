package net.gilgasso;
import acm.program.*;
import acm.graphics.*;
import net.gilgasso.Principal;
/**
 * 
 * @author gil
 *
 */
public class Soldat{
	/**
	 *  la imatge del soldat.
	 */
	GImage imatgesoldat;
	/**
	 * boolean per saber si ha arribat al final de pantalla.
	 */
    boolean desti;
	
	/**
	 * 
	 * @param imatge  és per exemple "soldat.png"
	 * @param x la posicio en les x
	 * @param y la posicio en les y
	 */
Soldat(String imatge,int x,int y) {
		   
		 imatgesoldat = new GImage(imatge,x,y);
}
	
	
	/**
	 * 
	 * @return la imatge del soldat.
	 */
   public GImage getImatgesoldat() {
		return imatgesoldat;
	}

	
    /**
     * 
     * @param x  la posicio x de la imatge
     * @param y  la posicio y de la imatge
     */
	public void setPosicio(double x,double y) {
		this.imatgesoldat.setLocation(x,y);
	}

	/**
	 * 
	 * @param x  moviment en les x
	 * @param y  moviment en les y
	 */
	public void mouresoldat(int x,int y){
		
		if(imatgesoldat.getX()<1000-imatgesoldat.getWidth()&&imatgesoldat.getX()>-1){
		imatgesoldat.move(x,y);
		
		}
		else{
			this.desti=true;
		}
	}
	
	

}
