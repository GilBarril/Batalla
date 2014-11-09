package net.gilgasso;
import java.util.ArrayList;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Principal extends GraphicsProgram {
	
	public void init(){
		setSize(1200,800);
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
		int  numsoldats=8;
		soldatsalabatalla = new ArrayList<Personatge>();
		soldatsalabatalla2 = new ArrayList<Personatge>();
		Personatge rei1 = new Rei("reilila.png",0,0,false,1,this.getWidth());
		Personatge rei2 = new Rei("reiverd.png",0,0,false,1,this.getWidth());
		soldatsalabatalla.add(rei1);
		soldatsalabatalla2.add(rei2);
		
		for(int i=0;i<numsoldats;i++){
		  int numerosoldat = (int) (Math.random()*8)+1;
			
			if(numerosoldat==4){
				Personatge soldur1 = new SoldatDur("android-dur-lila.png",0,0,false,2,this.getWidth());
				Personatge soldur2 = new SoldatDur("android-dur-verd.png",0,0,false,2,this.getWidth());
				soldatsalabatalla.add(soldur1);
				soldatsalabatalla2.add(soldur2);
			}
			if(numerosoldat==6){
				Personatge samu1 = new Samurai("samurai2.png",0,0,false,2,this.getWidth());
				Personatge samu2 = new Samurai("samurai.png",0,0,false,2,this.getWidth());
				soldatsalabatalla.add(samu1);
				soldatsalabatalla2.add(samu2);
			}
			if(numerosoldat==2){
				Personatge nuvol = new Nuvol("nuvol.png",0,0,false,1,this.getWidth());
				Personatge nuvol1 = new Nuvol("nuvol.png",0,0,false,1,this.getWidth());
				soldatsalabatalla.add(nuvol);
				soldatsalabatalla2.add(nuvol1);
			}
		    if(numerosoldat==5){
				Personatge drac = new Drac("android-drac-1.png",0,0,false,1,this.getWidth());
				Personatge drac2 = new Drac("android-drac.png",0,0,false,1,this.getWidth());
				soldatsalabatalla.add(drac);
				soldatsalabatalla2.add(drac2);
			}
		    
			Personatge soldi = new Soldat("soldi.png",0,0,false,1,this.getWidth());
			Personatge sold = new Soldat("soldat.png",0,0,false,1,this.getWidth());
			soldatsalabatalla.add(soldi);
			soldatsalabatalla2.add(sold);
		}
		
		
		exercit1 = new Exercit(this,soldatsalabatalla,0,getWidth());
		exercit2 = new Exercit(this,soldatsalabatalla2,1,getWidth());
		exercits = new ArrayList<Exercit>();
		exercits.add(exercit1);
		exercits.add(exercit2);
		
		for(int index=0;index<soldatsalabatalla.size();index++){
			add(exercit1.soldatsallistats.get(index).imatgepersonatge);
			add(exercit2.soldatsallistats.get(index).imatgepersonatge);
			
			}
		
		Batalla Ardenas = new Batalla(this,exercits);
		
		while(!Ardenas.mirarvictoria){
		Ardenas.Guerra();
		}
		pause(200);
		this.removeAll();
		Ardenas.mostrarguanyador(Ardenas.idexercitperdedor);
		
		
		
		
		
		
		
	}
	
	
	
	

}
