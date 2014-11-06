package net.gilgasso;
import acm.program.*;
import acm.graphics.*;


public class Bolafoc extends Personatge{
	
	
   int ampladapantalla;
	
	
	public Bolafoc(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"bolafoc",x,y,desti,v,a);
		ampladapantalla=a;
		   
	   }


public void moure(int x,int y){
		
		if(imatgepersonatge.getX()<ampladapantalla-imatgepersonatge.getWidth()&&imatgepersonatge.getX()>-1){
			imatgepersonatge.move(x,y);
		
		}
		else{
			this.desti=true;
		}
	}


	@Override
	public Bolafoc treureboladefoc(int dir) {
		// TODO Auto-generated method stub
		return null;
	}

   
	

}