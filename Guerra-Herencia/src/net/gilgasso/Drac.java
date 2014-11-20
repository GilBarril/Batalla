package net.gilgasso;
import acm.program.*;
import acm.graphics.*;
import net.gilgasso.Bolafoc;
import net.gilgasso.Principal;
/**
 * 
 * @author gil
 *
 */
public class Drac extends Personatge{
	
	/**
	 * velocitat del drac
	 */
	final static int VELOCITATDRAC=6;
	/**
	  * amplada de la pantalla
	  */
	int ampladapantalla;
	 
	/**
	 * 
	 * @param imatge del drac
	 * @param x posicio x
	 * @param y posicio y
	 * @param desti si ha arribat al limit de la pantalla
	 * @param v vides
	 * @param a amplada de la pantalla
	 */	
	public Drac(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"drac",x,y,desti,v,a);
		this.velocitatpersonatge=VELOCITATDRAC;
		ampladapantalla=a;   
	   }

	/**
	 * 
	 * @param dir passes la direcció de l'exercit
	 * @return torna una bola de foc
	 */
   public Bolafoc treureboladefoc(int dir){
	   int x;
	   int y;
	   if(dir==0){
		   x=(int) this.getImatgepersonatge().getX() + (int) this.imatgepersonatge.getWidth();
		   y=(int) this.getImatgepersonatge().getY();
	   }
	   else{
		    x=(int) this.getImatgepersonatge().getX() - (int) this.imatgepersonatge.getWidth();
		    y=(int) this.getImatgepersonatge().getY();
	   }
	   Bolafoc bola = new Bolafoc("flama.png",x,y,false,1,ampladapantalla);
	   bola.esforma=false;
	return bola;
	      
   }
	
	

}