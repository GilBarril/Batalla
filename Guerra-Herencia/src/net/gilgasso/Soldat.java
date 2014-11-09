package net.gilgasso;
import acm.program.*;
import acm.graphics.*;


public class Soldat extends Personatge{
	
	
 int ampladapantalla;
	
	
	public Soldat(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"soldat",x,y,desti,v,a);
		   
		  ampladapantalla = a; 
	   }
	
   public void moure(int x,int y){
		
		if(imatgepersonatge.getX()<ampladapantalla-imatgepersonatge.getWidth()&&imatgepersonatge.getX()>-1){
			imatgepersonatge.move(x,y);
		
		}
		else{
			this.desti=true;
		}
	}

	

}
