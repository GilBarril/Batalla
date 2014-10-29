package net.gilgasso;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.awt.event.*;

import acm.graphics.GImage;

public class Batalla {
	
	boolean mirarvictoria=false;
	int idexercitperdedor=0;
	ArrayList<Exercit> exercits;
	Principal Batallapausa;
	
	Batalla(Principal pausa,ArrayList<Exercit> battle2){
		
	exercits = battle2;	
	Batallapausa=pausa;
			
	}
	
	
	public void Guerra(){
		

		
			for(Exercit exercitsbatalla : exercits ){
				exercitsbatalla.formacio();
				Batallapausa.pause(100); 	
	    }
		
		while(!exercits.get(0).comprobardestisoldats() && !exercits.get(1).comprobardestisoldats() && !mirarvictoria){
			
				exercits.get(0).moure();
				exercits.get(1).comprovarbaixes(exercits.get(0).soldatsallistats);
				exercits.get(1).moure();
				exercits.get(0).comprovarbaixes(exercits.get(1).soldatsallistats);
				
				
				Batallapausa.pause(10); 	
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
	
	public final boolean mirarnumerodesoldats(){
	
		
		for(int exer=0;exer<exercits.size();exer++){
			
			if(exercits.get(exer).soldatsallistats.size()==0){
				mirarvictoria = true;
				idexercitperdedor=exer;
			}
				
		}
		return mirarvictoria;
		
		
	}
	
	public void mostrarguanyador(int idexer){
		GImage win = new GImage("",200,200);
		for(int b=0;b<exercits.size();b++){
			if(b==idexer){
				if(idexer==0){
					win.setImage("soldi.png");
					win.setSize(150, 150);
				}else{
					win.setImage("soldat.png");
					win.setSize(150, 150);
				}
		    }
		}
		Batallapausa.add(win);
		
	}
	
	
}
	


