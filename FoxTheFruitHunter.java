/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxthefruithunter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.net.URL;
/**
 *
 * @author ACER
 */

class HomeScreen extends JFrame{
    background bg_main=new background();
    playstage p1=new playstage();
    
    HomeScreen(){
        super("Fox The Fruit Hunter");

        bg_main.start.addActionListener(new buttonlistener_Start());
        bg_main.exit.addActionListener(new buttonListener_Close());
        
        add(bg_main);
        
        p1.exit.addActionListener(new buttonListener_Home());
    }
    private class buttonlistener_Start implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            getContentPane().removeAll();
            //bg_main.setVisible(false);
            add(p1);
            p1.requestFocus();
            validate();
            repaint(); 
            //getContentPane().repaint();
        }
    }
    private class buttonListener_Close implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    
    private class buttonListener_Home implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            p1.getRes_score().setVisible(false);
            p1.getPlay_again().setVisible(false);
            p1.getExit().setVisible(false);
           
            p1.getScore().setVisible(true);
            p1.getClock().setVisible(true);
            p1.getShow_time().setVisible(true);
            p1.getShow_score().setVisible(true);
                
            p1.start_fruit=false;
            p1.timestart=false;
            p1.end_round=false;
            p1.times=30;
            p1.timestamp=p1.times;
            p1.scor=0;
            p1.getShow_score().setText(String.valueOf(p1.scor));
            p1.getShow_time().setText(String.valueOf(p1.times));
            add(bg_main); 
            validate();
            repaint(); 
        }  
    }
}

class background extends JPanel{
        URL imageURL;
        URL imageURL2;
        URL imageURL3;
        Image image;
        Image image2;
        Image image3;
        JButton start;
        JButton exit;
        public background() {
            imageURL = this.getClass().getResource("background.png");
            image = new ImageIcon(imageURL).getImage();

            start=new JButton();
            URL imageURL2 = this.getClass().getResource("button_start2.png");
            Image image2 = new ImageIcon(imageURL2).getImage();
            start.setIcon(new ImageIcon(image2));
            start.setContentAreaFilled(false);
            start.setBorder(BorderFactory.createEmptyBorder());
        
            exit=new JButton();
            URL imageURL3 = this.getClass().getResource("button_exit2.png");
            Image image3 = new ImageIcon(imageURL3).getImage();
            exit.setIcon(new ImageIcon(image3));
            exit.setContentAreaFilled(false);
            exit.setBorder(BorderFactory.createEmptyBorder());
        
            this.setLayout(null);
        
            this.add(start);
            start.setBounds(590, 340, 400, 210);

            this.add(exit);
            exit.setBounds(590, 540, 400, 210);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
}

public class FoxTheFruitHunter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HomeScreen home= new HomeScreen();
        home.setSize(1200, 800);
        home.setResizable(false);
        home.setVisible(true);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
