package net.gilgasso;
import acm.program.*;
import acm.graphics.*;


public abstract class Personatge{
	
	GImage imatgepersonatge;
    boolean desti;
	public String tipuspersonatge;
	public int vides;
	
	public Personatge(String imatge,String tipus,int x,int y,boolean des,int v){
		   
		  imatgepersonatge = new GImage(imatge,x,y);
		  tipuspersonatge = tipus;
		  desti=des;
		  vides=v;
	   }
	
	
	
   public GImage getImatgepersonatge() {
		return imatgepersonatge;
	}

	

	public void setPosicio(double x,double y) {
		this.imatgepersonatge.setLocation(x,y);
	}

	
	public abstract void moure(int x,int y);
	
	public String toString(){
		return tipuspersonatge + " " +desti;
	}

}

	
	
	

