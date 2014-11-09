package net.gilgasso;
import acm.program.*;
import acm.graphics.*;


public class Rei extends Personatge{
	
	int movimenty=1;
    boolean desti;
	
	
	public Rei(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"rei",x,y,desti,v,a);
		   
		   
	   }
	
   public void moure(int x,int y){
	   
	   this.desti=true;
	       
	   if(imatgepersonatge.getY()<0 || imatgepersonatge.getY()>560-imatgepersonatge.getHeight()){
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
