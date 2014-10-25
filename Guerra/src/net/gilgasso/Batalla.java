package net.gilgasso;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.awt.event.*;

public class Batalla {
	
	boolean mirarvictoria=false;
	
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
		
		while(!exercits.get(0).comprobardestisoldats() && !exercits.get(1).comprobardestisoldats()){
			if(!mirarvictoria){
				exercits.get(0).moure();
				exercits.get(1).comprovarbaixes(exercits.get(0).soldatsallistats);
				exercits.get(1).moure();
				exercits.get(0).comprovarbaixes(exercits.get(1).soldatsallistats);
				
				Batallapausa.pause(10); 	
				this.mirarnumerodesoldats();
			}
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
	
		
		for(Exercit batallaexercits : exercits){
			
			if(batallaexercits.soldatsallistats.size()>0){
				mirarvictoria = false;
			}
			else{
				mirarvictoria = true;
			}
			
		}
		return mirarvictoria;
		
		
	}
	
	
}
	


