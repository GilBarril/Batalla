package net.gilgasso;
import java.util.ArrayList;

/**
 * 
 * @author gil
 *
 */
public class Exercit {
    /**
     * llista dels soldats de l'exèrcit
     */
	ArrayList<Soldat> soldatsallistats;
	/**
	 *  el numero de files per formar
	 */
	int numfiles=0;
	/**
	 * altura de les files per formar
	 */
	int Altura =70;
	/**
	 * amplada de les files per formar
	 */
	int Amplada = 70;
	/**
	 * direcció per saber cap on va l'exercit
	 */
	int direccio=0;
	/**
	 * amplada de la pantalla
	 */
	int ampladaPantalla=0;
	/**
	 *  porto la pantalla (canvas) per poder utilitzar algunes funcions
	 */
	Principal Exercitpausa;

    /**
     * 
     * @param pauses rebo la pantalla(canvas)
     * @param soldatsexercit array de soldats
     * @param dir la direcció de l'exèrcit
     * @param ampladapantalla l'amplada de la pantalla
     */
	Exercit(Principal pauses,ArrayList<Soldat> soldatsexercit,int dir,int ampladapantalla){
		
		soldatsallistats = soldatsexercit;
		direccio = dir;
		ampladaPantalla = ampladapantalla;
		Exercitpausa = pauses;
}
/**
 * forma els exercits abans de la batalla
 */
	public void formacio(){
		
		if (soldatsallistats.size() >= 20) {
		numfiles = 7;
		} else {
		
		numfiles -= 2;
		}
		int[] files = new int[numfiles];
		
		for(Soldat peons : soldatsallistats) {
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
		
	/**
	 * 
	 * @return  l'array de soldats
	 */
	public ArrayList<Soldat> getSoldatsallistats() {
		return soldatsallistats;
	}

   /**
    * 
    * @param soldatsallistats rebo l'array de soldats
    */
	public void setSoldatsallistats(ArrayList<Soldat> soldatsallistats) {
		this.soldatsallistats = soldatsallistats;
	}
	
	/**
	 *  faig que tot l'exercit es mogui	
	 */
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
	
	/**
	 * comprovo si hi ha baixes a l'exercit
	 * @param soldats li passo l¡array enemic
	 */
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
	/**
	 * 	
	 * @return el boolea per saber si tots els soldats han arribat al desti
	 */
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
	

