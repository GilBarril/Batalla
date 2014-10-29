package net.gilgasso;
import java.util.ArrayList;


public class Exercit {

	ArrayList<Soldat> soldatsallistats;
	int numfiles=0;
	int Altura =70;
	int Amplada = 70;
	int direccio=0;
	int ampladaPantalla=0;
	Principal Exercitpausa;


	Exercit(Principal pauses,ArrayList<Soldat> soldatsexercit,int dir,int ampladapantalla){
		
		soldatsallistats = soldatsexercit;
		direccio = dir;
		ampladaPantalla=ampladapantalla;
		Exercitpausa = pauses;
		
	}

	
	public void formacio(){
		
		if(soldatsallistats.size()>=20){
		numfiles = 7;
		}else{
		
		numfiles-=2;
		}
		int[] files=new int[numfiles];
		
		for(Soldat peons : soldatsallistats){
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
		
		
	public ArrayList<Soldat> getSoldatsallistats() {
		return soldatsallistats;
	}


	public void setSoldatsallistats(ArrayList<Soldat> soldatsallistats) {
		this.soldatsallistats = soldatsallistats;
	}
	
	
	
	public void moure(){
		
		if(this.direccio==0){
		for(Soldat soldatmou : soldatsallistats ){
			soldatmou.mouresoldat(16, 0);
			Exercitpausa.pause(10);
			
		}
		
		}else
		{
			for(Soldat soldatmou : soldatsallistats ){
				soldatmou.mouresoldat(-15, 0);
				Exercitpausa.pause(10);
		}
		
	}
	
	}
	public void comprovarbaixes(ArrayList<Soldat> soldats){

		for(int z=0;z<this.soldatsallistats.size();z++){
			for(int a=0;a<soldats.size();a++){
				
				if(this.soldatsallistats.get(z).imatgesoldat.getBounds().intersects(soldats.get(a).imatgesoldat.getBounds())){
					
					Exercitpausa.remove(soldats.get(a).imatgesoldat);
					soldats.remove(a);
					
				}
				
				
			}
			
			
		}
	}
	
	public final boolean comprobardestisoldats(){
		int contadordesti=0;
		boolean arribadesti=false;
		
		for(Soldat soldiers : soldatsallistats){
			if(soldiers.desti==true){
				contadordesti+=1;
			}
			System.out.println(contadordesti+" "+soldatsallistats.size());
		if (contadordesti==soldatsallistats.size()){
			arribadesti=true;
		 }
		}
		return arribadesti;
	}
	
}
	

