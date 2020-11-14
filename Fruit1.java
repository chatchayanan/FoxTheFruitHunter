/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxthefruithunter;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
/**
 *
 * @author ACER
 */
public class Fruit1 {
    Image img;
    public int x=(int)(Math.random()*1200);   //(int)((Math.random()*300)+20);
    public int y= 0;
    public int count = 0;
    public boolean check=true;

    public Fruit1() {
        URL imageURL = this.getClass().getResource("fruit1.png");
	img = new ImageIcon(imageURL).getImage();
	dropper.start();
    }
    
    Thread dropper = new Thread(new Runnable() {
            public void run() {
		while(true){
                    y += 2;
                    if(y >= 800){
			img = null;
			dropper = null;
			x = -500;
			y = -500;
                    }
                    try{
                        if(check=true){
                            dropper.sleep(20);
                        }
                        if(check=false){
                            dropper.sleep(7);
                        }
                    }catch(InterruptedException e){}
                }
            }
    });
    
    public Image getImage(){
            return img;
	}
	
    public int getX(){
            return x;
	}
    public int getY(){
            return y;
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,45,45));
    }
}
