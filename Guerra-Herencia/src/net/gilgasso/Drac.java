package net.gilgasso;
import acm.program.*;
import acm.graphics.*;
import net.gilgasso.Bolafoc;
import net.gilgasso.Principal;

public class Drac extends Personatge{
	
	
 
	int ampladapantalla;
	
	public Drac(String imatge,int x,int y,boolean desti,int v,int a){
		   
		super(imatge,"drac",x,y,desti,v,a);
		   
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
   public Bolafoc treureboladefoc(int dir){
	   int x;
	   int y;
	   if(dir==0){
		   x=(int) this.getImatgepersonatge().getX() + (int) this.imatgepersonatge.getWidth();
		   y=(int) this.getImatgepersonatge().getY();
	   }
	   else{
		    x=(int) this.getImatgepersonatge().getX() - (int) this.imatgepersonatge.getWidth();
		    y=(int) this.getImatgepersonatge().getY();
	   }
	   Bolafoc bola = new Bolafoc("flama.png",x,y,false,1,ampladapantalla);
	return bola;
	      
   }
	
	

}