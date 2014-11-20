package net.gilgasso;
import acm.program.*;
import acm.graphics.*;

/**
 * 
 * @author gil
 *
 */
public class Bolafoc extends Personatge{
	/**
	 * velocitat del nuvol
	 */
	final static int VELOCITATBOLAFOC=20;
	 /**
	  * amplada de la pantalla
	  */
	
	int ampladapantalla;
	 
	 /**
	 * 
	 * @param imatge del bolafoc
	 * @param x posicio x
	 * @param y posicio y
	 * @param desti si ha arribat al limit de la pantalla
	 * @param v vides
	 * @param a amplada de la pantalla
	 */
	public Bolafoc(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"bolafoc",x,y,desti,v,a);
		this.velocitatpersonatge=VELOCITATBOLAFOC;
		ampladapantalla=a;
		   
	   }
      	
		
		

}