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
public class Fox {
    public ImageIcon[] fox= new ImageIcon[5];
    int x,count=0;

    public Fox() {
        for(int i=0;i<fox.length;i++){
            fox[i] = new ImageIcon(this.getClass().getResource("fox"+(i+1)+".png"));
	}
    }
    
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(this.x,600,55,55));
    }
}
