package net.gilgasso;
import acm.program.*;
import acm.graphics.*;

/**
 * 
 * @author gil
 *
 */
public class Soldat extends Personatge{
	
/**
 * velocitat del soldat	
 */
 final static int VELOCITATSOLDAT=6;
 /**
  * amplada de la pantalla
  */
 int ampladapantalla;
 	
 /**
	 * 
	 * @param imatge del soldat dur
	 * @param x posicio x
	 * @param y posicio y
	 * @param desti si ha arribat al limit de la pantalla
	 * @param v vides
	 * @param a amplada de la pantalla
	 */	
public Soldat(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"soldat",x,y,desti,v,a);
		  velocitatpersonatge=VELOCITATSOLDAT;
		  ampladapantalla = a; 
	   }	

}
