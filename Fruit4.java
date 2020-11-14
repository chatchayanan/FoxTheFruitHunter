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
public class Fruit4 extends Fruit1{
    Image img4;

    public Fruit4() {
        URL imageURL = this.getClass().getResource("fruit4.png");
	img4 = new ImageIcon(imageURL).getImage();
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
                            dropper.sleep(25);
                        }
                        if(check=false){
                            dropper.sleep(15);
                        }
                    }catch(InterruptedException e){}
                }
            }
    });
    
    public Image getImage(){
	return img4;
    }        
}
