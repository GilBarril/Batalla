package net.gilgasso;
import acm.program.*;
import acm.graphics.*;
import net.gilgasso.Exercit;

/**
 * 
 * @author gil
 *
 */
public class Rei extends Personatge{
	/**
	 * variable que permet el canvi de direcció del rei
	 */
	int movimenty=1;
	/**
	 * variable per al move
	 */
    int y;
    /**
     * la velocitat del rei
     */
    static final int VELOCITATREI=5;
    /**
     * miro l'altura de les files
     */
	int altura=Exercit.ALTURA*Exercit.numfiles;
	
	/**
	 * 
	 * @param imatge del soldat dur
	 * @param x posicio x
	 * @param y posicio y
	 * @param desti si ha arribat al limit de la pantalla
	 * @param v vides
	 * @param a amplada de la pantalla
	 */
	public Rei(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"rei",x,y,desti,v,a);
		   
		   
	   }
	/**
	 * metode per moure's
	 */
   public void moure(int dir){
	   
	   this.desti=true;
	   
	   if(imatgepersonatge.getY()<0 || imatgepersonatge.getY()>this.altura-imatgepersonatge.getHeight()){
		   if(movimenty==-1){
			   movimenty=1;
		   }else{
			   movimenty=-1;
		   }
	   }
	   
	   y=movimenty*VELOCITATREI;
	   imatgepersonatge.move(0,y);
	   
		
		
	}


	

}
