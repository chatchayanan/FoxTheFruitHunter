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
public class Bottle4 extends Bottle1 {
    Image img4;
    public Bottle4() {
        URL imageURL4 = this.getClass().getResource("bottle4.png");
	img4 = new ImageIcon(imageURL4).getImage();
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
                            dropper.sleep(1);
                        }
                    }catch(InterruptedException e){}
                }
            }
    });
    
    public Image getImg(){
	return img4;
    }    
}
