/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxthefruithunter;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
/**
 *
 * @author ACER
 */
public class playstage extends JPanel implements ActionListener {
    URL imageURL = this.getClass().getResource("stage1_V2.png");
    Image image_1 = new ImageIcon(imageURL).getImage();
    URL imageURL2 = this.getClass().getResource("score.png");
    Image image_2 = new ImageIcon(imageURL2).getImage();
    URL imageURL3 = this.getClass().getResource("stage2_V2.png");
    Image image_3 = new ImageIcon(imageURL3).getImage();
    private final ImageIcon img_fox= new ImageIcon(this.getClass().getResource("fox1.png"));
    Fox f=new Fox();
    
    private JLabel score = new JLabel("Score = ");
    private JLabel show_score = new JLabel("0");
    private JLabel res_score = new JLabel(); 
    private JLabel clock = new JLabel("Time: ");
    private JLabel show_time = new JLabel("60"); 
    
    JButton play_again = new JButton();
    JButton exit = new JButton();
    public int times = 30 ;
    public int timestamp = times;
    boolean timestart = false;
    boolean start_fruit= false;
    boolean end_round= false;
    public int scor = 0;
    public ArrayList<Fruit1> fr1 = new ArrayList<Fruit1>();
    public ArrayList<Fruit2> fr2 = new ArrayList<Fruit2>();
    public ArrayList<Fruit3> fr3 = new ArrayList<Fruit3>();
    public ArrayList<Fruit4> fr4 = new ArrayList<Fruit4>();
    public ArrayList<Bottle1> bt1 = new ArrayList<Bottle1>();
    public ArrayList<Bottle2> bt2 = new ArrayList<Bottle2>();
    public ArrayList<Bottle3> bt3 = new ArrayList<Bottle3>();
    public ArrayList<Bottle4> bt4 = new ArrayList<Bottle4>();
    
    Thread time = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    if(timestart == false){
			repaint();
                    }
                }
                
            }
    });
    
    Thread player = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                        repaint();
		}
            }
    });
    
    Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1);
                            show_time.setText(String.valueOf(times));
                            timestamp++;
			}
			try{
                            Thread.sleep(2000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
    });
    
    Thread t_fruit1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(start_fruit == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(start_fruit == false){
                            fr1.add(new Fruit1());
			}
		}
            }
    });
    
    Thread t_fruit2 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(start_fruit == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(start_fruit == false){
                            fr2.add(new Fruit2());
			}
		}
            }
    });
    
    Thread t_fruit3 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(start_fruit == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(start_fruit == false){
                            fr3.add(new Fruit3());
			}
		}
            }
    });
    
    Thread t_fruit4 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(start_fruit == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(start_fruit == false){
                            fr4.add(new Fruit4());
			}
		}
            }
    });
    
    Thread t_bottle1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(start_fruit == false){
				Thread.sleep((long)(Math.random()*10000)+1500);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(start_fruit == false){
                            bt1.add(new Bottle1());
			}
		}
            }
    });
    
    Thread t_bottle2 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(start_fruit == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(start_fruit == false){
                            bt2.add(new Bottle2());
			}
		}
            }
    });
    
    Thread t_bottle3 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(start_fruit == false){
				Thread.sleep((long)(Math.random()*10000)+1000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(start_fruit == false){
                            bt3.add(new Bottle3());
			}
		}
            }
    });
    
    Thread t_bottle4 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(start_fruit == false){
				Thread.sleep((long)(Math.random()*10000)+1200);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(start_fruit == false){
                            bt4.add(new Bottle4());
			}
		}
            }
    });
    
    
    public playstage() {
        this.setFocusable(true);
        this.requestFocus(true);
	this.setLayout(null);
        this.add(score);
        score.setBounds(920,30, 200, 200);
        score.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.add(show_score);
        show_score.setBounds(1075,30, 200, 200);
        show_score.setFont(new Font("Verdana", Font.PLAIN, 55));
        this.add(clock);
        clock.setBounds(10,30, 200, 200);
        clock.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.add(show_time);
        show_time.setBounds(125,30, 200, 200);
        show_time.setFont(new Font("Verdana", Font.PLAIN, 55));
        this.addKeyListener(new key_Listener());
        f.x = 500;
	time.start();
	player.start();
        t_fruit1.start();
        t_fruit2.start();
        t_fruit3.start();
        t_fruit4.start();
        t_bottle1.start();
        t_bottle2.start();
        t_bottle3.start();
        t_bottle4.start();
        t.start();
        this.setFocusable(true);
        this.requestFocus(true);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(end_round== false){
            if(timestamp<=40){
                g.drawImage(this.image_1, 0, 0, null);
                 fr1.forEach((n)-> n.check= false);
                 fr2.forEach((n)-> n.check= false);
                 fr3.forEach((n)-> n.check= false);
                 fr4.forEach((n)-> n.check= false);
                 bt1.forEach((n)-> n.check= false);
                 bt2.forEach((n)-> n.check= false);
                 bt3.forEach((n)-> n.check= false);
                 bt4.forEach((n)-> n.check= false);
            }
             if(timestamp >40){
                 g.drawImage(this.image_3, 0, 0, null);
                 fr1.forEach((n)-> n.check= true);
                 fr2.forEach((n)-> n.check= true);
                 fr3.forEach((n)-> n.check= true);
                 fr4.forEach((n)-> n.check= true);
                 bt1.forEach((n)-> n.check= true);
                 bt2.forEach((n)-> n.check= true);
                 bt3.forEach((n)-> n.check= true);
                 bt4.forEach((n)-> n.check= true);
             }
        }
        if(times >0){
            g.drawImage(f.fox[f.count].getImage(), f.x, 600,125,155, this);
            if(f.x<0){
                f.x=this.getWidth()-10;
            }
            if(f.x>this.getWidth()){
                f.x=20;
            }
            
            //fruit1
            for(int i=0 ; i<fr1.size();i++){
                    g.drawImage(fr1.get(i).getImage(),fr1.get(i).getX(),fr1.get(i).getY(),100,100,this);
            }
            for(int j=0 ; j<fr1.size();j++){
                        if(Intersect(f.getbound(),fr1.get(j).getbound())){
                            fr1.remove(j);
			    scor +=10;
                            show_score.setText(String.valueOf(scor));
			} 
            }
        
            //fruit2
            for(int i=0 ; i<fr2.size();i++){
                    g.drawImage(fr2.get(i).getImage(),fr2.get(i).getX(),fr2.get(i).getY(),100,100,this);
            }
            for(int j=0 ; j<fr2.size();j++){
                        if(Intersect(f.getbound(),fr2.get(j).getbound())){
                            fr2.remove(j);
			    scor +=20;
                            show_score.setText(String.valueOf(scor));
			} 
            }
            
            //fruit3
            for(int i=0 ; i<fr3.size();i++){
                    g.drawImage(fr3.get(i).getImage(),fr3.get(i).getX(),fr3.get(i).getY(),100,100,this);
            }
            for(int j=0 ; j<fr3.size();j++){
                        if(Intersect(f.getbound(),fr3.get(j).getbound())){
                            fr3.remove(j);
			    scor +=30;
                            show_score.setText(String.valueOf(scor));
			} 
            }
        
            //fruit4
            for(int i=0 ; i<fr4.size();i++){
                    g.drawImage(fr4.get(i).getImage(),fr4.get(i).getX(),fr4.get(i).getY(),100,100,this);
            }
            for(int j=0 ; j<fr4.size();j++){
                        if(Intersect(f.getbound(),fr4.get(j).getbound())){
                            fr4.remove(j);
			    scor +=40;
                            show_score.setText(String.valueOf(scor));
			} 
            }
            
            for(int i=0 ; i<bt1.size();i++){
                    g.drawImage(bt1.get(i).getImg(),bt1.get(i).getX(),bt1.get(i).getY(),100,100,this);
            }
            for(int j=0 ; j<bt1.size();j++){
                        if(Intersect(f.getbound(),bt1.get(j).getbound())){
                            bt1.remove(j);
			    times -= 20;
                            show_time.setText(String.valueOf(times));
			} 
            }
            
            for(int i=0 ; i<bt2.size();i++){
                    g.drawImage(bt2.get(i).getImg(),bt2.get(i).getX(),bt2.get(i).getY(),100,100,this);
            }
            for(int j=0 ; j<bt2.size();j++){
                        if(Intersect(f.getbound(),bt2.get(j).getbound())){
                            bt2.remove(j);
			    times =0;
			} 
            }
            
            for(int i=0 ; i<bt3.size();i++){
                    g.drawImage(bt3.get(i).getImg(),bt3.get(i).getX(),bt3.get(i).getY(),100,100,this);
            }
            for(int j=0 ; j<bt3.size();j++){
                        if(Intersect(f.getbound(),bt3.get(j).getbound())){
                            bt3.remove(j);
			    times +=5;
                            show_time.setText(String.valueOf(times));
			} 
            }
            
            for(int i=0 ; i<bt4.size();i++){
                    g.drawImage(bt4.get(i).getImg(),bt4.get(i).getX(),bt4.get(i).getY(),100,100,this);
            }
            for(int j=0 ; j<bt4.size();j++){
                        if(Intersect(f.getbound(),bt4.get(j).getbound())){
                            bt4.remove(j);
			    scor-=10;
                            show_score.setText(String.valueOf(scor));
			} 
            }
        }
        else{
            end_round=true;
            start_fruit=true;
            timestart=true;
            
            score.setVisible(false);
            clock.setVisible(false);
            show_time.setVisible(false);
            show_score.setVisible(false);
            
            g.drawImage(this.image_2, 0, 0, null);
            
            res_score.setText(String.valueOf(scor));
            this.add(res_score);
            res_score.setBounds(775,500, 200, 200);
            res_score.setFont(new Font("Verdana", Font.PLAIN, 100));
            
            URL imageURL3 = this.getClass().getResource("button_play.png");
            Image image3 = new ImageIcon(imageURL3).getImage();
            play_again.setIcon(new ImageIcon(image3));
            play_again.setContentAreaFilled(false);
            play_again.setBorder(BorderFactory.createEmptyBorder());
            this.add(play_again);
            play_again.setBounds(370, 600, 400, 210);
            play_again.addActionListener(new buttonListener_Playagain());
            
            URL imageURL4 = this.getClass().getResource("button_home.png");
            Image image4 = new ImageIcon(imageURL4).getImage();
            exit.setIcon(new ImageIcon(image4));
            exit.setContentAreaFilled(false);
            this.add(exit);
            exit.setBounds(830, 600, 400, 210);
            
            res_score.setVisible(true);
            play_again.setVisible(true);
            exit.setVisible(true);            
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    private class key_Listener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyPressed(KeyEvent e) {
            int a = e.getKeyCode();
			if(a == KeyEvent.VK_A){
			     	f.x-=15;
                                f.count++; 
                        }
                        else if(a == KeyEvent.VK_D){
                               f.x+=15;
                               f.count++;
                        }
                        if(f.count>3){
                                f.count=0;            
                        }   
        }

        @Override
        public void keyReleased(KeyEvent e) {
            f.count=0;
        }
    }
    
    private class buttonListener_Playagain implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           res_score.setVisible(false);
           play_again.setVisible(false);
           exit.setVisible(false);
           
           score.setVisible(true);
           clock.setVisible(true);
           show_time.setVisible(true);
           show_score.setVisible(true);
                
           start_fruit=false;
           timestart=false;
           end_round=false;
           times=30;
           timestamp=times;
           scor=0;
           show_score.setText(String.valueOf(scor));
           show_time.setText(String.valueOf(times));
           validate();
           repaint(); 
        }
    }
    
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
        return (a.intersects(b));
    }

    public JLabel getScore() {
        return score;
    }

    public void setScore(JLabel score) {
        this.score = score;
    }

    public JLabel getShow_score() {
        return show_score;
    }

    public void setShow_score(JLabel show_score) {
        this.show_score = show_score;
    }

    public JLabel getRes_score() {
        return res_score;
    }

    public void setRes_score(JLabel res_score) {
        this.res_score = res_score;
    }

    public JLabel getClock() {
        return clock;
    }

    public void setClock(JLabel clock) {
        this.clock = clock;
    }

    public JLabel getShow_time() {
        return show_time;
    }

    public void setShow_time(JLabel show_time) {
        this.show_time = show_time;
    }

    public JButton getPlay_again() {
        return play_again;
    }

    public void setPlay_again(JButton play_again) {
        this.play_again = play_again;
    }

    public JButton getExit() {
        return exit;
    }

    public void setExit(JButton exit) {
        this.exit = exit;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public boolean isTimestart() {
        return timestart;
    }

    public void setTimestart(boolean timestart) {
        this.timestart = timestart;
    }

    public boolean isStart_fruit() {
        return start_fruit;
    }

    public void setStart_fruit(boolean start_fruit) {
        this.start_fruit = start_fruit;
    }

    public boolean isEnd_round() {
        return end_round;
    }

    public void setEnd_round(boolean end_round) {
        this.end_round = end_round;
    }

    public int getScor() {
        return scor;
    }

    public void setScor(int scor) {
        this.scor = scor;
    }

    public int getTimestamp() {
        return timestamp;
    }
 
}
