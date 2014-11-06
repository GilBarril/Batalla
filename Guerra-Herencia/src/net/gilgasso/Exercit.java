package net.gilgasso;
import java.util.ArrayList;
import net.gilgasso.Drac;
import acm.graphics.*;

public class Exercit {
    Bolafoc flama;
    ArrayList<Bolafoc> bolesdefoc;
	ArrayList<Personatge> soldatsallistats;
	int matadorz;
	boolean esatacnuvol=false;
	boolean esatacfoc=false;
	int numfiles=0;
	int Altura =72;
	int Amplada =72;
	int direccio=0;
	int ampladaPantalla=0;
	Principal Exercitpausa;


	Exercit(Principal pauses,ArrayList<Personatge> soldatsexercit,int dir,int ampladapantalla){
		
		soldatsallistats = soldatsexercit;
		direccio = dir;
		ampladaPantalla=ampladapantalla;
		Exercitpausa = pauses;
		
	}

	
	public void formacio(){
		
		if(soldatsallistats.size()>=10){
		numfiles = 6;
		}else{
		if(numfiles>2){
		   numfiles-=2;
		}
		}
		int[] files=new int[numfiles];
		
		for(Personatge peons : soldatsallistats){
			peons.desti=false;
			int quinafila = (int)(Math.random()*numfiles);
			if(this.direccio==1){
			files[quinafila]++;
	        peons.setPosicio(ampladaPantalla-(files[quinafila]* Amplada), quinafila*Altura);
	        
			}else{
			peons.setPosicio(files[quinafila]* Amplada, quinafila*Altura);
		    files[quinafila]++;	
			}
		}
		
		
		}
		
		
	public ArrayList<Personatge> getSoldatsallistats() {
		return soldatsallistats;
	}


	public void setSoldatsallistats(ArrayList<Personatge> soldatsallistats) {
		this.soldatsallistats = soldatsallistats;
	}
	
	
	
	public void moure(){
		
		
		for(Personatge soldatmou : soldatsallistats ){	
			
			if(soldatmou instanceof Rei){
				soldatmou.moure(0,5);
			}
			
			if(this.direccio==0){
				 if(soldatmou.tipuspersonatge!="rei"){
					if(soldatmou instanceof Nuvol){
						soldatmou.moure(20,0);
					}
					if(soldatmou instanceof Samurai){
						soldatmou.moure(12,0);
					}
					if(soldatmou instanceof Bolafoc){
						soldatmou.moure(20,0);
					}					
					else{
					 soldatmou.moure(6,0);
					}
					
				 }
					
			   }
				else
			   {
				if(soldatmou.tipuspersonatge!="rei"){
					if(soldatmou instanceof Nuvol){
						soldatmou.moure(-24,0);
					}
					if(soldatmou instanceof Samurai){
						soldatmou.moure(-11,0);
					}
					if(soldatmou instanceof Bolafoc){
						soldatmou.moure(-20,0);
					}	
					else{
					 soldatmou.moure(-5,0);
					}
					
				}
					
							
			
			
		}
	}
		
}
		
	public void atacdelsdracs(int direccio){
		bolesdefoc = new ArrayList<Bolafoc>();
		int tirarfoc = (int)(Math.random()*40)+1;
		
			
		for(Personatge soldatsdracs : soldatsallistats){
		if(soldatsdracs instanceof Drac){
			if(tirarfoc==8){
				flama = soldatsdracs.treureboladefoc(this.direccio);
				Exercitpausa.add(flama.imatgepersonatge);
			    bolesdefoc.add(flama);
			}
		
		}
	}
		for(Bolafoc o : bolesdefoc){
			soldatsallistats.add(o);
		}
		
}

	public void comprovarbaixes(ArrayList<Personatge> soldats){
		esatacnuvol=false;
		esatacfoc=false;
		for(int z=0;z<this.soldatsallistats.size();z++){
			for(int a=0;a<soldats.size();a++){
				
				if(this.soldatsallistats.get(z).imatgepersonatge.getBounds().intersects(soldats.get(a).imatgepersonatge.getBounds())){
					if(soldatsallistats.get(z).tipuspersonatge=="nuvol" || soldats.get(a).tipuspersonatge=="nuvol"){
						double posnuvolX = soldatsallistats.get(z).imatgepersonatge.getX();
						double posnuvolY = soldatsallistats.get(z).imatgepersonatge.getY();
						esatacnuvol=true;
						matadorz=z;
						Exercitpausa.remove(soldatsallistats.get(z).imatgepersonatge);
						Exercitpausa.remove(soldats.get(a).imatgepersonatge);
						soldatsallistats.get(z).setImatgepersonatge("boom.png",posnuvolX,posnuvolY-10);
						Exercitpausa.add(soldatsallistats.get(z).imatgepersonatge);
						Exercitpausa.pause(30);
						Exercitpausa.remove(soldatsallistats.get(z).imatgepersonatge);
						soldats.remove(a);
					}
					else{
				   if(soldatsallistats.get(z).tipuspersonatge=="bolafoc" || soldats.get(a).tipuspersonatge=="bolafoc" ){
					   
					   double posfocX = soldatsallistats.get(z).imatgepersonatge.getX();
						double posfocY = soldatsallistats.get(z).imatgepersonatge.getY();
						esatacfoc=true;
						matadorz=z;
						Exercitpausa.remove(soldatsallistats.get(z).imatgepersonatge);
						Exercitpausa.remove(soldats.get(a).imatgepersonatge);
						soldatsallistats.get(z).setImatgepersonatge("soldatcremat.png",posfocX,posfocY-10);
						Exercitpausa.add(soldatsallistats.get(z).imatgepersonatge);
						Exercitpausa.pause(30);
						Exercitpausa.remove(soldatsallistats.get(z).imatgepersonatge);
						soldats.remove(a);
				   }else{
					
					if(soldatsallistats.get(z).tipuspersonatge=="samurai"){
						soldats.get(a).vides-=2;
					}else{
					soldats.get(a).vides-=1;
					}
					if(soldats.get(a).vides<=0){
							Exercitpausa.remove(soldats.get(a).imatgepersonatge);
							soldats.remove(a);
						}
					}}
				}
			
		
		}
	}

	if(esatacnuvol==true || esatacfoc==true){
		soldatsallistats.remove(matadorz);}
}
			
			
		
	
	public final boolean comprobardestisoldats(){
		int contadordesti=0;
		boolean arribadesti=false;
		ArrayList<Personatge> bolesfinal = new ArrayList<Personatge>();
		for(int i=0;i<soldatsallistats.size();i++){
			
				if(soldatsallistats.get(i).desti==true){
					if(soldatsallistats.get(i) instanceof Bolafoc){
						
						bolesfinal.add(soldatsallistats.get(i));
						Exercitpausa.remove(soldatsallistats.get(i).imatgepersonatge);
					}
					contadordesti+=1;
				}
			
		if (contadordesti==soldatsallistats.size()){
			arribadesti=true;
		 }
		}
		for(int bol=0;bol<bolesfinal.size();bol++){
			
			soldatsallistats.remove(bolesfinal.get(bol));
		}
		return arribadesti;
	}
	
}
	

