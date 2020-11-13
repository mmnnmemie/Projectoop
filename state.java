package javaapplication7;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class state extends JPanel implements ActionListener{
    
	private final ImageIcon imgbg = new ImageIcon(this.getClass().getResource("bg1.gif"));
	private final ImageIcon imgbg2 = new ImageIcon(this.getClass().getResource("bg2.gif"));
	private final ImageIcon back = new ImageIcon(this.getClass().getResource("home.png"));
        private final ImageIcon pause = new ImageIcon(this.getClass().getResource("next.png")); 
	muku m = new muku();
        
        
        //mini heart 
        ArrayList<ImageIcon> HEART=new ArrayList<ImageIcon>();
        
	homegame hg = new homegame();
	ImageIcon feildover = new ImageIcon(this.getClass().getResource("qq.png"));
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("exit.png"));
        ImageIcon theendd = new ImageIcon(this.getClass().getResource("win.gif"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("Start.png"));
        ImageIcon heartt = new ImageIcon(this.getClass().getResource("heart.png"));
        
        JButton BStartover = new JButton(restart);
	JButton BExitover  = new JButton(exitover);
       
	private JLabel score = new JLabel();
        
	public ArrayList<e1> ea1 = new ArrayList<e1>();
	public ArrayList<e2> ea2 = new ArrayList<e2>();
	public ArrayList<e> ea5 = new ArrayList<e>();
        boolean nextpage = false;
        
	public int times ;
	public int HP = 3;
	public int rs1 = 1;
	public int rs2 = 2;
	boolean timestart = true;
	boolean startball = false;
	boolean gameover=false;
	boolean theend = false;
        private gameover gover = new gameover();
	public int scor = 0;
	boolean paralyze1 = false;
	
        
        //you win
	Thread OVER =new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(1);
                    }catch(Exception e){ }
                    if(scor<=-1||HP<=0){
                        gameover=true;
                    }
                    else if(scor>=200){
                        theend=true;
                    }
                }
            }
        });
        
        
        //speed
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
        
        
	Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
       
	Thread e1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startball == false){
				Thread.sleep((long)(Math.random()*1000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            ea1.add(new e1());
			}
		}
            }
	});
        
	Thread e2 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startball==false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            ea2.add(new e2());
			}
		}
            }
	});

	Thread e5 = new Thread(new Runnable(){
            public void run() {
            	while(true){
			try{
                            if(startball==false){
                                Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            ea5.add(new e());
			}
		}
            }
	});
        
        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1) ;
                           if(paralyze1){
                            }
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
        
        
         //state
	state(){
		this.setFocusable(true);
		this.setLayout(null);
		for(int i=0;i<3;i++){
                    HEART.add(heartt);
                }
		this.add(score);
		OVER.start();
		this.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
			if(!paralyze1){
			    if(a==KeyEvent.VK_LEFT || a == KeyEvent.VK_A){
			     	m.x-=10;
                                m.count++;
                            }
                            else if(a == KeyEvent.VK_RIGHT || a == KeyEvent.VK_A){
                               m.x+=10;
                               m.count++;
			   }
                            if(m.count>3){
                                m.count=0;
                            }                          
			}
                    }
                    public void keyReleased(KeyEvent e){
			m.count=0;
		    }
		});
                
		m.x = 400;
                m.y=400;
		time.start();
		actor.start();
		t.start();
		e1.start();
		e2.start();
		e5.start();
	}
	
        //paint
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(gameover){
                
               // this.remove(BExithome);
                this.setLayout(null);
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
		g.setColor(Color.BLACK);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));		
                g.drawString("SCORE   "+scor,200,200);	     
                g.setFont(new Font("TimesRoman", Font.BOLD, 50));
                
            }          
            else if(theend){
                
                this.setLayout(null);
                g.drawImage(theendd.getImage(),0,0,1000,800,this);
		g.setColor(Color.BLACK);
                g.setFont(new Font("TimesRoman", Font.BOLD, 40));		
                g.drawString("SCORE   "+scor,200,200);	     
                g.setFont(new Font("TimesRoman", Font.BOLD, 50));
                
            }
            
            //change 2
            else if(times <= 30){
                g.drawImage(imgbg2.getImage(),0,0,1000,800,this);
                int x=460;
                int y=30;
                for(int i=0;i<HEART.size();i++){
                    g.drawImage(HEART.get(i).getImage(),x+=55 , y, this);
                }
                if(paralyze1){
                    
                }else{
                 g.drawImage(m.im[m.count].getImage(), m.x, 450,200,250, this);
                }
   		if(m.x<0){
                    m.x=this.getWidth()-10;
   		}
   		if(m.x>this.getWidth()){
                    m.x=20;
   		}
                 
                //memee state1
               
 		//===========e1================
		for(int i=0 ; i<ea1.size();i++){
                    g.drawImage( ea1.get(i).getImage() ,ea1.get(i).getX(),ea1.get(i).getY(),100,100,this);
		}
                for(int i=0 ; i<ea1.size();i++){
                    
		    	if(Intersect(m.getboundG(),ea1.get(i).getbound())){
			    ea1.remove(i);
                            scor += 10;
			    g.drawString("+10",m.x+100,650);
                        } 
		}
		//===========e2================
		for(int i=0 ; i<ea2.size();i++){
                    g.drawImage(ea2.get(i).getImage(),ea2.get(i).getX(),ea2.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<ea2.size();i++){
                    if(Intersect(m.getboundG(),ea2.get(i).getbound())){
                        ea2.remove(i);
                        scor += 20;
                        g.drawString("+20",m.x+100,650);
                    } 
                }		
		//===========e================
		for(int i=0 ; i<ea5.size();i++){
		    g.drawImage(ea5.get(i).getImage(),ea5.get(i).getX(),ea5.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<ea5.size();i++){
                    if(Intersect(ea5.get(i).getbound(),m.getbound())){
                        ea5.remove(i);
                        scor -=20;
                        HP=HP-1;
                        g.drawString("-1HP",m.x+100,580);
                        g.drawString("-20",m.x+100,650);
                    } 
		}
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLACK);
		g.drawString(""+scor,800, 68);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,35));
		g.drawString(""+times,700,68);
                
            }
            else{
                g.drawImage(imgbg.getImage(),0,0,1000,800,this);
                int x=460;
                int y=30;
                for(int i=0;i<HEART.size();i++){
                    g.drawImage(HEART.get(i).getImage(),x+=55 , y, this);
                }
                if(paralyze1){
                    g.setFont(new Font("Hobo Std",Font.BOLD,50));               
                    g.drawString("-10",m.x+100,650);
                }else{
                    g.drawImage(m.im[m.count].getImage(), m.x,450,200,250, this);
                }
		if(m.x<0){
                    m.x=this.getWidth()-10;
		}
		if(m.x>this.getWidth()){
                    m.x=20;
		}
                

                //state 2
		//========================================e1================= 
                for(int i=0 ; i<ea1.size();i++){
                    g.drawImage(ea1.get(i).getImage(),ea1.get(i).getX(),ea1.get(i).getY(),100,100,this);
 		}
		for(int i=0 ; i<ea1.size();i++){
                    if(Intersect(ea1.get(i).getbound(),m.getboundG())){
                        ea1.remove(i);
                        scor += 10;
                        g.drawString("+10",m.x+100,650);
                    } 
                }
                
		//========================e2=========================
		for(int i=0 ; i<ea2.size();i++){
		    g.drawImage(ea2.get(i).getImage(),ea2.get(i).getX(),ea2.get(i).getY(),100,100,this);
		 }
		for(int i=0 ; i<ea2.size();i++){
                    if(Intersect(ea2.get(i).getbound(),m.getboundG())){
                        ea2.remove(i);
                        scor += 20;
                        g.drawString("+10",m.x+100,650);
                    } 
                }
		
		//=================e=============================
		for(int i=0 ; i<ea5.size();i++){
		    g.drawImage(ea5.get(i).getImage(),ea5.get(i).getX(),ea5.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<ea5.size();i++){
                    if(Intersect(m.getbound(),ea5.get(i).getbound())){
                        ea5.remove(i);
                        HEART.remove(0);
                        scor -=20;
                        HP=HP-1;
                        g.drawString("-1HP",m.x+100,650);
                        g.drawString("-20",m.x+100,580);
                    }
		}
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLACK);
		g.drawString(""+scor,800, 68);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,35));
		g.drawString(""+times,700,68);
		//g.setColor(Color.RED);
            }
            if(times <= 0){
                gameover = true;
            }
 
//            for (int i=0;i<heart.length;i++){
//                String heart ="heart"+(i+1)+".png";
//                URL imageURL = this.getClass().getResource(heart);
//            // heart[i]=Toolkit.getDefaultToolkit().getImage(imageURL)
//            }
        }

   public boolean Intersect(Rectangle2D a, Rectangle2D b){
            return (a.intersects(b));
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== BStartover){		
                    this.setSize(1000,800);
                    this.add(hg);
                    this.setLocation(null);
                    timestart = true;
                    startball = true;
		}else if(e.getSource() == BExitover){
                    System.exit(0);
		}		
	}
}
	
