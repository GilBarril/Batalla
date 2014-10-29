package net.gilgasso;
import java.util.ArrayList;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Principal extends GraphicsProgram {
	
	public void init(){
		setSize(1000,800);
	}
	
	ArrayList<Exercit> exercits;
	ArrayList<Personatge> soldatsalabatalla;
	ArrayList<Personatge> soldatsalabatalla2;
	Exercit exercit1;
	Exercit exercit2;
	
	GImage finalguerra = new GImage("");
	
	public int getWidth() {
		
		return super.getWidth();
	}
	
	public void run(){
		soldatsalabatalla = new ArrayList<Personatge>();
		soldatsalabatalla2 = new ArrayList<Personatge>();
		
		Personatge rei1 = new Rei("reinikochan.png",0,0,false,1);
		Personatge rei2 = new Rei("nikochan-1.png",0,0,false,1);
		soldatsalabatalla.add(rei1);
		soldatsalabatalla2.add(rei2);
		
		for(int i=0;i<29;i++){
		  int numerosoldat = (int) (Math.random()*8)+1;
			if(numerosoldat==4){
				Personatge soldur1 = new SoldatDur("rei.png",0,0,false,2);
				Personatge soldur2 = new SoldatDur("rei1.png",0,0,false,2);
				soldatsalabatalla.add(soldur1);
				soldatsalabatalla2.add(soldur2);
			}
			Personatge soldi = new Soldat("soldi.png",0,0,false,1);
			Personatge sold = new Soldat("soldat.png",0,0,false,1);
			soldatsalabatalla.add(soldi);
			soldatsalabatalla2.add(sold);
		}
		
		exercit1 = new Exercit(this,soldatsalabatalla,0,getWidth());
		exercit2 = new Exercit(this,soldatsalabatalla2,1,getWidth());
		exercits = new ArrayList<Exercit>();
		exercits.add(exercit1);
		exercits.add(exercit2);
		
		for(int index=0;index<30;index++){
			add(exercit1.soldatsallistats.get(index).imatgepersonatge);
			add(exercit2.soldatsallistats.get(index).imatgepersonatge);
			
			}
		
		Batalla Ardenas = new Batalla(this,exercits);
		
		while(!Ardenas.mirarvictoria){
		Ardenas.Guerra();
		}
		this.removeAll();
		Ardenas.mostrarguanyador(Ardenas.idexercitperdedor);
		
		
		
		
		
		
		
	}
	
	
	
	

}
