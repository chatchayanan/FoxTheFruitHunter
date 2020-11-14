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
public class Fruit3 extends Fruit1 {
    Image img3;

    public Fruit3() {
        URL imageURL = this.getClass().getResource("fruit3.png");
	img3 = new ImageIcon(imageURL).getImage();
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
                            dropper.sleep(50);
                        }
                        if(check=false){
                            dropper.sleep(10);
                        }
                    }catch(InterruptedException e){}
                }
            }
    });
    
    public Image getImage(){
	return img3;
    }        
}
