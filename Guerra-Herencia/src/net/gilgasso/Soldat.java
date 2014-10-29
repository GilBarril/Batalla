package net.gilgasso;
import acm.program.*;
import acm.graphics.*;


public class Soldat extends Personatge{
	
	
 
	
	
	public Soldat(String imatge,int x,int y,boolean desti,int v){
		   
		super(imatge,"soldat",x,y,desti,v);
		   
		   
	   }
	
   public void moure(int x,int y){
		
		if(imatgepersonatge.getX()<1000-imatgepersonatge.getWidth()&&imatgepersonatge.getX()>-1){
			imatgepersonatge.move(x,y);
		
		}
		else{
			this.desti=true;
		}
	}
	
	

}
