package net.gilgasso;
import java.util.ArrayList;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Principal extends GraphicsProgram {
	
	public void init(){
		setSize(1000,800);
	}
	
	ArrayList<Exercit> exercits;
	ArrayList<Soldat> soldatsalabatalla;
	ArrayList<Soldat> soldatsalabatalla2;
	Exercit exercit1;
	Exercit exercit2;
	
	public int getWidth() {
		
		return super.getWidth();
	}
	
	public void run(){
		soldatsalabatalla = new ArrayList<Soldat>();
		soldatsalabatalla2 = new ArrayList<Soldat>();
		
		for(int i=0;i<20;i++){
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
		
		for(int index=0;index<20;index++){
			add(exercit1.soldatsallistats.get(index).imatgesoldat);
			add(exercit2.soldatsallistats.get(index).imatgesoldat);
			
			}
		
		Batalla Ardenas = new Batalla(this,exercits);
		
		while(!Ardenas.mirarvictoria){
		Ardenas.Guerra();
		
		}
		
		
		
		
		
		
		
	}
	
	
	
	

}
