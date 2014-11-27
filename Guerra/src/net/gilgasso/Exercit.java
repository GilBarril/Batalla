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
	static int numfiles=7;
	/**
	 * altura de les files per formar
	 */
	final static int  Altura =70;
	/**
	 * amplada de les files per formar
	 */
	final static int Amplada = 70;
	/**
	 * direcció per saber cap on va l'exercit
	 */
	int direccio=0;
	/**
	 * amplada de la pantalla
	 */
	static int ampladaPantalla=0;
	/**
	 *  porto la pantalla (canvas) per poder utilitzar algunes funcions
	 */
	Principal Exercitcanvas;

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
		Exercitcanvas = pauses;
}
/**
 * forma els exercits abans de la batalla
 */
	public void formacio(){
		
		if (soldatsallistats.size() <= 20 && numfiles>1) {
		numfiles -= 1;
		} 
		int[] files = new int[numfiles];
		
		for(Soldat peons : soldatsallistats) {
			peons.setDesti(false);
			int quinafila = (int)(Math.random()*numfiles);
			if(this.getDireccio()==1){
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
		
		if(this.getDireccio()==0){
		for(Soldat soldatmou : soldatsallistats ){
			soldatmou.mouresoldat(this.getDireccio());
			
			
		}
		Exercitcanvas.pause(50);
		}else
		{
			for(Soldat soldatmou : soldatsallistats ){
				soldatmou.mouresoldat(this.getDireccio());
				
		}
			Exercitcanvas.pause(50);
	}
	
	}
	
	public int getDireccio() {
		return direccio;
	}
	public void setDireccio(int direccio) {
		this.direccio = direccio;
	}
	/**
	 * comprovo si hi ha baixes a l'exercit
	 * @param soldats li passo l¡array enemic
	 */
	public void comprovarbaixes(ArrayList<Soldat> soldats){

		for(int z=0;z<this.soldatsallistats.size();z++){
			for(int a=0;a<soldats.size();a++){
				
				if(this.soldatsallistats.get(z).getImatgesoldat().getBounds().intersects(soldats.get(a).getImatgesoldat().getBounds())){
					
					Exercitcanvas.remove(soldats.get(a).getImatgesoldat());
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
	

