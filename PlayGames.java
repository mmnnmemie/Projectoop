package javaapplication7;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class PlayGames extends JFrame {  
    
	homegame homegames1 = new homegame();
	state state1 = new state();
	gameover gover = new gameover();
	public PlayGames(){
            
           
            addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    super.mouseClicked(e);
                    if(e.getX()>=0&&e.getX()<=1010&&e.getY()>=0&&e.getY()<=800&&(!state1.nextpage)){
                        setLocationRelativeTo(null);
                        remove(homegames1);
                        setSize(1010,800);
                        add(state1);
                        state1.requestFocusInWindow();
                        state1.timestart = false;
                        state1.scor=0;
                        state1.times = 60;
                        state1.startball=false;
                        state1.timestart=false;
                        state1.nextpage = true;      
                    }
                    else if(e.getX()>=870&&e.getX()<=921&&e.getY()>=85&&e.getY()<=135&&(state1.nextpage))
                        {
                        setLocationRelativeTo(null);
                        remove(state1);
                        setSize(1010,800);
                        add(homegames1); 
                        homegames1.requestFocusInWindow();
                        removeMouseListener(this);
                  
                    }
                }
            });
		this.setSize(1010,800);
                this.setResizable(false);
		this.add(homegames1);               
	}
     
    }    	
