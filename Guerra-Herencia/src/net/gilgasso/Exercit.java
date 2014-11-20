package net.gilgasso;
import java.util.ArrayList;
import net.gilgasso.Drac;
import acm.graphics.*;
/**
 * 
 * @author gil
 *
 */
public class Exercit {
	/**
	 * un objecte Bola de Foc
	 */
    Bolafoc flama;
    /**
     * Un array list de boles de foc
     */
    ArrayList<Bolafoc> bolesdefoc;
    /**
     * Un array list de Personatges
     */
	ArrayList<Personatge> soldatsallistats;
	/**
	 * variable per agafar l'index dels kamikazes(nuvol,bolafoc)
	 */
	int matadorz;
	/**
	 * boolean per saber si ha sigut atac kamikaze
	 */
	boolean esatackamikaze=false;
	/**
	 * nombre de files de la formació
	 */
	static int numfiles=6;
	/**
	 * altura fila
	 */
	static final int ALTURA=72;
	/**
	 * amplada fila
	 */
	static final int AMPLADA=72;
	/**
	 * la direcció de l'exercit
	 */
	int direccio;
	/**
	 * amplada de la pantalla
	 */
	static int ampladaPantalla;
	/**
	 * objecte principal(pantalla)
	 */
	Principal Exercitpausa;

    /**
     * 
     * @param pauses propietats del canvas(principal)
     * @param soldatsexercit array de PERSONATGES
     * @param dir la direcció de l'exercit
     * @param ampladapantalla l'amplada de la pantalla
     */
	Exercit(Principal pauses,ArrayList<Personatge> soldatsexercit,int dir,int ampladapantalla){
		
		soldatsallistats = soldatsexercit;
		direccio = dir;
		ampladaPantalla=ampladapantalla;
		Exercitpausa = pauses;
		
	}

	/**
	 * creem la formació de l'exercit
	 */
	public void formacio(){
		
		if(soldatsallistats.size()<=10 && numfiles>1){
			 numfiles-=1;
			 
		  }
		
		
		int[] files=new int[numfiles];
		
		for(Personatge peons : soldatsallistats){
			if(peons.esforma==true){	
				peons.desti=false;
				int quinafila = (int)(Math.random()*numfiles);
				if(this.direccio==1){
					files[quinafila]++;
			        peons.setPosicio(ampladaPantalla-(files[quinafila]* AMPLADA), quinafila*ALTURA);
		        
				}else{
					peons.setPosicio(files[quinafila]* AMPLADA, quinafila*ALTURA);
				    files[quinafila]++;	
				}
			}
		}
		
		
		}
		
	/**
	 * 
	 * @return array de Personatges
	 */
	public ArrayList<Personatge> getSoldatsallistats() {
		return soldatsallistats;
	}

    /**
     * 
     * @param soldatsallistats reps Array de Personatges
     */
	public void setSoldatsallistats(ArrayList<Personatge> soldatsallistats) {
		this.soldatsallistats = soldatsallistats;
	}
	
	
	/**
	 * crides el mètode moure
	 */
	public void moure(){
		
		
		for(Personatge soldatmou : soldatsallistats ){	
			soldatmou.moure(this.direccio);
		}
	}
		

	/**
	 * 	motode per atacar amb els androids drac
	 * @param direccio li passes la direcció de l'exercit
	 */
	public void atacdelsdracs(int direccio){
		bolesdefoc = new ArrayList<Bolafoc>();
		int tirarfoc = (int)(Math.random()*40)+1;
		
			
		for(Personatge soldatsdracs : soldatsallistats){
		if(soldatsdracs instanceof Drac){
			if(tirarfoc==8){
				flama = ((Drac)soldatsdracs).treureboladefoc(this.direccio);
				Exercitpausa.add(flama.imatgepersonatge);
			    bolesdefoc.add(flama);
			}
		
		}
	}
		for(Bolafoc o : bolesdefoc){
			soldatsallistats.add(o);
		}
		
}
    /**
     * mètode per comprobar baixes
     * @param soldats passo array de l'exercit enemic
     */
	public void comprovarbaixes(ArrayList<Personatge> soldats){
		esatackamikaze=false;
		for(int z=0;z<this.soldatsallistats.size();z++){
			for(int a=0;a<soldats.size();a++){
				
				if(this.soldatsallistats.get(z).imatgepersonatge.getBounds().intersects(soldats.get(a).imatgepersonatge.getBounds())){
					/**
					 * atac del nuvol(moren els dos personatges)
					 */
					if(soldatsallistats.get(z).tipuspersonatge=="nuvol" || soldats.get(a).tipuspersonatge=="nuvol"){
						double posnuvolX = soldatsallistats.get(z).imatgepersonatge.getX();
						double posnuvolY = soldatsallistats.get(z).imatgepersonatge.getY();
						esatackamikaze=true;
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
						/**
						 * atac de la bola de foc(moren els dos)
						 */
				   if(soldatsallistats.get(z).tipuspersonatge=="bolafoc" || soldats.get(a).tipuspersonatge=="bolafoc" ){
					   
					   double posfocX = soldatsallistats.get(z).imatgepersonatge.getX();
						double posfocY = soldatsallistats.get(z).imatgepersonatge.getY();
						esatackamikaze=true;
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

	if(esatackamikaze==true){
		soldatsallistats.remove(matadorz);}
}
			
			
		
	/**
	 * mètode per comprobar que els soldats estan al desti
	 * @return retorna si tots els soldats estan al desti
	 */
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
	

