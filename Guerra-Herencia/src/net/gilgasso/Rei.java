package net.gilgasso;
import acm.program.*;
import acm.graphics.*;


public class Rei extends Personatge{
	
	int movimenty=1;
    boolean desti;
	
	
	public Rei(String imatge,int x,int y,boolean desti,int v){
		   
		super(imatge,"rei",x,y,desti,v);
		   
		   
	   }
	
   public void moure(int x,int y){
	   
	   this.desti=true;
	       
	   if(imatgepersonatge.getY()<0 || imatgepersonatge.getY()>360-imatgepersonatge.getHeight()){
		   if(movimenty==-1){
			   movimenty=1;
		   }else{
			   movimenty=-1;
		   }
	   }
	   
	   int movy=movimenty*y;
	   imatgepersonatge.move(x,movy);
	   
		
		
	}
	
	

}
