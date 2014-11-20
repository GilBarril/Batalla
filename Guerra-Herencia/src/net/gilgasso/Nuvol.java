package net.gilgasso;
import acm.program.*;
import acm.graphics.*;
/**
 * 
 * @author gil
 *
 */

public class Nuvol extends Personatge{
	/**
	 * velocitat del nuvol
	 */
	final static int VELOCITATNUVOL=20;
	 /**
	  * amplada de la pantalla
	  */
	 int ampladapantalla;
	 	
	 /**
		 * 
		 * @param imatge del nuvol
		 * @param x posicio x
		 * @param y posicio y
		 * @param desti si ha arribat al limit de la pantalla
		 * @param v vides
		 * @param a amplada de la pantalla
		 */
	public Nuvol(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"nuvol",x,y,desti,v,a);
		this.velocitatpersonatge=VELOCITATNUVOL;
		ampladapantalla = a;   
		   
	   }
	
}
