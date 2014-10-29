package net.gilgasso;
import java.util.ArrayList;


public class Exercit {

	ArrayList<Personatge> soldatsallistats;
	int numfiles=0;
	int Altura =45;
	int Amplada =45;
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
		numfiles = 8;
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
			if(soldatmou.tipuspersonatge=="rei"){
				soldatmou.moure(0,15);
			}
			
			if(this.direccio==0){
				 if(soldatmou.tipuspersonatge!="rei"){
					soldatmou.moure(16,0);
					Exercitpausa.pause(10);
				 }
					
			   }
				else
			   {
				if(soldatmou.tipuspersonatge!="rei"){
					soldatmou.moure(-15,0);
					Exercitpausa.pause(10);
				}
					
							
			
			
		}
	}
		
}
		
	

	public void comprovarbaixes(ArrayList<Personatge> soldats){

		for(int z=0;z<this.soldatsallistats.size();z++){
			for(int a=0;a<soldats.size();a++){
				
				if(this.soldatsallistats.get(z).imatgepersonatge.getBounds().intersects(soldats.get(a).imatgepersonatge.getBounds())){
						soldats.get(a).vides-=1;
						System.out.println( a+ " "+soldats.get(a).vides+ " entra");
						if(soldats.get(a).vides==0){
							Exercitpausa.remove(soldats.get(a).imatgepersonatge);
							soldats.remove(a);
						}
					}
				}
				
				
			}
			
			
		}
	
	public final boolean comprobardestisoldats(){
		int contadordesti=0;
		boolean arribadesti=false;
		
		for(Personatge soldiers : soldatsallistats){
			
				if(soldiers.desti==true){
					contadordesti+=1;
				}
			System.out.println(contadordesti+" "+soldatsallistats.size());
			System.out.println(soldatsallistats);
		if (contadordesti==soldatsallistats.size()){
			arribadesti=true;
		 }
		}
		return arribadesti;
	}
	
}
	

