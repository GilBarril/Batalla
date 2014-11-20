package net.gilgasso;
import acm.program.*;
import acm.graphics.*;

/**
 * 
 * @author gil
 *
 */
public class SoldatDur extends Personatge{
	 /**
	  *  La velocitat del soldat dur
	  */
     final static int VELOCITATSOLDATDUR=6;
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
	public SoldatDur(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"soldatdur",x,y,desti,v,a);
		ampladapantalla = a;
		this.velocitatpersonatge=VELOCITATSOLDATDUR;  
	   }

}
