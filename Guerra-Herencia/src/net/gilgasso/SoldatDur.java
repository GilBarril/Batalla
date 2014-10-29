package net.gilgasso;
import acm.program.*;
import acm.graphics.*;


public class SoldatDur extends Personatge{
	
	int vides;
   
	
	
	public SoldatDur(String imatge,int x,int y,boolean desti,int v){
		   
		super(imatge,"soldatdur",x,y,desti,v);
		 vides=2;
		   
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
