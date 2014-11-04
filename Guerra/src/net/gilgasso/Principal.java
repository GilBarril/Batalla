package net.gilgasso;
import java.util.ArrayList;
import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * 
 * @author gil
 *
 */
public class Principal extends GraphicsProgram {
	
	public void init(){
		setSize(1000,800);
	}
	/**
	 * numero de soldats per a cada exercit
	 */
	public final int numerosoldats=30;
	/**
	 *  Array exercits
	 */
	ArrayList<Exercit> exercits;
	/**
	 *  ArrayList de soldats per el primer exercit
	 */
	ArrayList<Soldat> soldatsalabatalla;
	/**
	 *  ArrayList de soldats del segon exercit
	 */
	ArrayList<Soldat> soldatsalabatalla2;
	/**
	 * creo primer exercit
	 */
	Exercit exercit1;
	/**
	 * creo segon exercit
	 */
	Exercit exercit2;
	/**
	 *  creo la imatge del guanyador
	 */
	GImage finalguerra = new GImage("");
	
	public int getWidth() {
		
		return super.getWidth();
	}
	
	public void run(){
		/**
		 * inicies les arrays
		 */
		soldatsalabatalla = new ArrayList<Soldat>();
		soldatsalabatalla2 = new ArrayList<Soldat>();
		
		/**
		 * creo els soldats
		 */
		for(int i=0;i<numerosoldats;i++){
			Soldat sold = new Soldat("soldi.png",0,0);
			Soldat soldi = new Soldat("soldat.png",0,0);
			soldatsalabatalla.add(soldi);
			soldatsalabatalla2.add(sold);
		}
		
		exercit1 = new Exercit(this,soldatsalabatalla,0,getWidth());
		exercit2 = new Exercit(this,soldatsalabatalla2,1,getWidth());
		exercits = new ArrayList<Exercit>();
		exercits.add(exercit1);
		exercits.add(exercit2);
		
		for(int index=0;index<numerosoldats;index++){
			add(exercit1.soldatsallistats.get(index).imatgesoldat);
			add(exercit2.soldatsallistats.get(index).imatgesoldat);
			
			}
		
		/**
		 * Comença la guerra
		 */
		Batalla Ardenas = new Batalla(this,exercits);
		
		while(!Ardenas.mirarvictoria){
		Ardenas.Guerra();
		
		}
		this.removeAll();
		Ardenas.mostrarguanyador(Ardenas.idexercitperdedor);
		
		
		
		
		
		
		
	}
	
	
	
	

}
