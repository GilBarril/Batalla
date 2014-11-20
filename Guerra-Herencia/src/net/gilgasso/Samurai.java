package net.gilgasso;
import acm.program.*;
import acm.graphics.*;

/**
 * 
 * @author gil
 *
 */
public class Samurai extends Personatge{
	/**
	  *  La velocitat del samurai
	  */
     final static int VELOCITATSAMURAI=12;
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
	public Samurai(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"samurai",x,y,desti,v,a);
		this.velocitatpersonatge=VELOCITATSAMURAI;
		ampladapantalla=a;   
	   }



}
