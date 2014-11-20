package net.gilgasso;
import acm.program.*;
import acm.graphics.*;
import net.gilgasso.Bolafoc;
/**
 * 
 * @author gil
 *
 */
public abstract class Personatge{
	/**
	 * boolean que serveix per que les boles desaparèixin i no es tornin a formar
	 */
	boolean esforma=true;
	/**
	 * velocitat del personatge
	 */
	int velocitatpersonatge;
	/**
	 * la imatge del personatge
	 */
	GImage imatgepersonatge;
	/**
	 * variable per veure si ha arribat al desti(limit pantalla)
	 */
    boolean desti;
    /**
     * variable tipus de personatge
     */
	public String tipuspersonatge;
	/**
	 * les vides del personatge
	 */
	public int vides;
	/**
	 * l'amplada de la pantalla
	 */
	int ampladapantalla;
	/**
	 * 
	 * @param imatge del soldat dur
	 * @param x posicio x
	 * @param y posicio y
	 * @param des si ha arribat al limit de la pantalla
	 * @param v vides
	 * @param a amplada de la pantalla
	 */
	public Personatge(String imatge,String tipus,int x,int y,boolean des,int v,int a){
		   
		  imatgepersonatge = new GImage(imatge,x,y);
		  tipuspersonatge = tipus;
		  desti=des;
		  vides=v;
		  ampladapantalla=a;
	   }
   /**
    * 
    * @return imatge del personatge
    */
   public  GImage getImatgepersonatge() {
		return imatgepersonatge;
	}
   /**
    * posicionar els personatges
    * @param x posicio x
    * @param y posicio y
    */
   public void setPosicio(double x,double y) {
		this.imatgepersonatge.setLocation(x,y);
	}
   /**
    * 
    * @param s nom de la imatge
    * @param x posicio x
    * @param y posicio y
    */
   public void setImatgepersonatge(String s,double x,double y) {
 		this.imatgepersonatge = new GImage(s,x,y);
 	}
   
    /**
     * metode moure's
     * @param dir
     */
	public void moure(int dir) {
			 /**
			  * depenen de la direcció en que vagi
			  */
			    if(dir==0){
			    	/**
			    	 * mira si esta dins dels limits
			    	 */
				if(imatgepersonatge.getX()<ampladapantalla-imatgepersonatge.getWidth()&&imatgepersonatge.getX()>-1){
					imatgepersonatge.move(velocitatpersonatge,0);
				
				}
				/**
				 * si arriba al limit, desti és true
				 */
				else{
					this.desti=true;
					}
			    }
		    else{
		    	if(imatgepersonatge.getX()<ampladapantalla-imatgepersonatge.getWidth()&&imatgepersonatge.getX()>-1){
					imatgepersonatge.move(-(velocitatpersonatge-1),0);
				
				}
				else{
					this.desti=true;
					}
			    }
		 }

	}
	









	
	
	

