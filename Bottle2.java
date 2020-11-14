/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxthefruithunter;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
/**
 *
 * @author ACER
 */
public class Bottle2 extends Bottle1{
    Image img2;
    public Bottle2() {
        URL imageURL = this.getClass().getResource("bottle2.png");
	img2 = new ImageIcon(imageURL).getImage();
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
                            dropper.sleep(5);
                        }
                        if(check=false){
                            dropper.sleep(1);
                        }
                    }catch(InterruptedException e){}
                }
            }
    });
    
    public Image getImg(){
	return img2;
    }    
}
