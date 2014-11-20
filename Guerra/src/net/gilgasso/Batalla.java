package net.gilgasso;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.awt.event.*;

import acm.graphics.GImage;
/**
 * 
 * @author gil
 *
 */
public class Batalla {
	/**
	 *  mira si un dels exercits esta sense soldats 
	 */
	static boolean mirarvictoria=false;
	/**
	 * passa l'identificador de l'exèrcit que perd
	 */
	static int idexercitperdedor=0;
	/**
	 *  l' array d'exercits que formen la batalla
	 */
	ArrayList<Exercit> exercits;
	/**
	 * Passo la pantalla per poder utilitzar les seves propietats
	 */
	Principal Batallacanvas;
	/**
	 * 
	 * @param pausa  passo els paràmetres de la pantalla
	 * @param battle2 passo l'array d'exercits
	 */
	Batalla(Principal pausa,ArrayList<Exercit> battle2){
		
	exercits = battle2;	
	Batallacanvas=pausa;
			
	}
	
	
	public void Guerra(){
		

			for ( Exercit exercitsbatalla : exercits ) {
				exercitsbatalla.formacio();
				Batallacanvas.pause(100); 	
	    }
		
		while ( !exercits.get(0).comprobardestisoldats() && !exercits.get(1).comprobardestisoldats() && !mirarvictoria) {
			
				exercits.get(0).moure();
				exercits.get(1).comprovarbaixes(exercits.get(0).soldatsallistats);
				exercits.get(1).moure();
				exercits.get(0).comprovarbaixes(exercits.get(1).soldatsallistats);
				
				
				Batallacanvas.pause(10); 	
				this.mirarnumerodesoldats();
			
		}
			
		
		for (int s = 0; s<exercits.size() ; s++) {
			if (exercits.get(s).direccio == 0){
				exercits.get(s).direccio = 1;
			}
			else{
				exercits.get(s).direccio = 0;
			}	
	    }	
		Batallacanvas.pause(50);
    }	
	
	/**
	 *  Miro el nombre de soldats
	 * @return torno el boolean que em diu si hi ha una victoria
	 */
	public final boolean mirarnumerodesoldats(){
	
		
		for (int exer = 0; exer<exercits.size(); exer++){
			
			if (exercits.get(exer).soldatsallistats.size() == 0) {
				mirarvictoria = true;
				idexercitperdedor=exer;
			}
				
		}
		return mirarvictoria;
		
		
	}
	/**
	 *  Mostro l'exercit guanyador
	 * @param idexer id de l'exercit perdedor
	 */
	public void mostrarguanyador(int idexer) {
		GImage win = new GImage("",200,200);
		for (int b = 0; b<exercits.size(); b++) {
			if (b == idexer) {
				if (idexer == 0) {
					win.setImage("soldi.png");
					win.setSize(150, 150);
				} else {
					win.setImage("soldat.png");
					win.setSize(150, 150);
				}
		    }
		}
		Batallacanvas.add(win);
		
	}
	
	
}
	


