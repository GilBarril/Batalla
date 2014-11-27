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
	 * la velocitat del soldat
	 */
	static final int VELOCITATSOLDAT=9;
	/**
	 *  la imatge del soldat.
	 */
	GImage imatgepersonatge;
	/**
	 * boolean per saber si ha arribat al final de pantalla.
	 */
    boolean desti;
    /**
     * amplada de la pantalla
     */
	int amplada;
	/**
	 * 
	 * @param imatge  és per exemple "soldat.png"
	 * @param x la posicio en les x
	 * @param y la posicio en les y
	 */
Soldat(String imatge,int x,int y,int ampl) {
		   
		 imatgepersonatge = new GImage(imatge,x,y);
		 amplada=ampl;
}
	
	
	/**
	 * 
	 * @return la imatge del soldat.
	 */
   public GImage getImatgesoldat() {
		return imatgepersonatge;
	}

	
    /**
     * 
     * @param x  la posicio x de la imatge
     * @param y  la posicio y de la imatge
     */
	public void setPosicio(double x,double y) {
		this.imatgepersonatge.setLocation(x,y);
	}

	/**
	 * 
	 * @param x  moviment en les x
	 * @param y  moviment en les y
	 */
public void mouresoldat(int dir){
	    
	    if(dir==0){
			if(imatgepersonatge.getX()<this.amplada-imatgepersonatge.getWidth()&&imatgepersonatge.getX()>-1){
				imatgepersonatge.move(VELOCITATSOLDAT,0);
			
			}
			else{
				this.desti=true;
				}
		    }
	    else{
	    	if(imatgepersonatge.getX()<this.amplada-imatgepersonatge.getWidth()&&imatgepersonatge.getX()>-1){
				imatgepersonatge.move(-(VELOCITATSOLDAT-1),0);
			
			}
			else{
				this.desti=true;
				}
		    }
	 }


	public boolean isDesti() {
		return desti;
	}


	public void setDesti(boolean desti) {
		this.desti = desti;
	}
	
	

}
