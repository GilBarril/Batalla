package net.gilgasso;
import acm.program.*;
import acm.graphics.*;
import net.gilgasso.Bolafoc;

public abstract class Personatge{
	
	GImage imatgepersonatge;
    boolean desti;
	public String tipuspersonatge;
	public int vides;
	int ampladapantalla;
	public Personatge(String imatge,String tipus,int x,int y,boolean des,int v,int a){
		   
		  imatgepersonatge = new GImage(imatge,x,y);
		  tipuspersonatge = tipus;
		  desti=des;
		  vides=v;
		  ampladapantalla=a;
	   }
	
	
	
   public void setImatgepersonatge(String s,double x,double y) {
		this.imatgepersonatge = new GImage(s,x,y);
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



	public abstract Bolafoc treureboladefoc(int d);





}

	
	
	

