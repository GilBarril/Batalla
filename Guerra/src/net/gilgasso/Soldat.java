package net.gilgasso;
import acm.program.*;
import acm.graphics.*;


public class Soldat{
	
	GImage imatgesoldat;
    boolean desti;
	
	
	Soldat(String imatge,int x,int y){
		   
		  imatgesoldat = new GImage(imatge,x,y);
		   
		   
	   }
	
	
	
   public GImage getImatgesoldat() {
		return imatgesoldat;
	}

	

	public void setPosicio(double x,double y) {
		this.imatgesoldat.setLocation(x,y);
	}

	
	public void mouresoldat(int x,int y){
		
		if(imatgesoldat.getX()<1000-imatgesoldat.getWidth()&&imatgesoldat.getX()>-1){
		imatgesoldat.move(x,y);
		
		}
		else{
			this.desti=true;
		}
	}
	
	

}
