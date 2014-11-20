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
	 * boolea per mirar si un dels exercits guanya
	 */
	boolean mirarvictoria=false;
	/**
	 * passes l'identificador de l'exercit guanyador
	 */
	int idexercitperdedor=0;
	/**
	 * Un array d'exèrcits
	 */
	ArrayList<Exercit> exercits;
	/**
	 * objecte pantalla (canvas)
	 */
	Principal Batallapausa;
	
	/**
	 * 
	 * @param pausa passo l'objecte pantalla(canvas)
	 * @param battle2 Array d'exercits
	 */
	Batalla(Principal pausa,ArrayList<Exercit> battle2){
		
	exercits = battle2;	
	Batallapausa=pausa;
			
	}
	
	/**
	 * mètode que fa que comenci la guerra
	 */
	public void Guerra(){
		

		/**
		 * formacio dels dos exercits
		 */
			for(Exercit exercitsbatalla : exercits ){
				exercitsbatalla.formacio();
				Batallapausa.pause(100); 	
	    }
		/**
		 * miro que tots els soldats estiguin al desti
		 * i que encara no s'hagi posat a true el miravictoria
		 */
		while((!exercits.get(0).comprobardestisoldats() && !exercits.get(1).comprobardestisoldats()) && !mirarvictoria){
			
				exercits.get(0).moure();
				exercits.get(1).comprovarbaixes(exercits.get(0).soldatsallistats);
				exercits.get(1).moure();
				exercits.get(0).comprovarbaixes(exercits.get(1).soldatsallistats);
				exercits.get(0).atacdelsdracs(exercits.get(0).direccio);
				exercits.get(1).atacdelsdracs(exercits.get(1).direccio);
				
				Batallapausa.pause(55); 	
				this.mirarnumerodesoldats();
			
		}
			
		
		for(int s=0;s<exercits.size();s++){
			if(exercits.get(s).direccio==0){
				exercits.get(s).direccio=1;
			}
			else{
				exercits.get(s).direccio=0;
			}	
	    }	
		Batallapausa.pause(50);
    }	
	
	/**
	 * comrpoba si un dels exercits esta sense soldats
	 * @return si hi ha victoria o no
	 */
	public final boolean mirarnumerodesoldats(){
	
		
		for(int exer=0;exer<exercits.size();exer++){
			
			if(exercits.get(exer).soldatsallistats.size()==0){
				mirarvictoria = true;
				idexercitperdedor=exer;
			}
				
		}
		return mirarvictoria;
		
		
	}
	/**
	 * mostra la imatge de l'exercit guanyador
	 * @param idexer passes l'index de l'exercit perdedor
	 */
	public void mostrarguanyador(int idexer){
		GImage win = new GImage("",350,200);
		for(int b=0;b<exercits.size();b++){
			if(b==idexer){
				if(idexer==0){
					win.setImage("guanya-verd.png");
					
				}else{
					win.setImage("guanya-lila.png");
					
				}
		    }
		}
		Batallapausa.add(win);
		
	}
	
	
}
	


