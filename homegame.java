package javaapplication7;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class homegame extends JPanel{
        private ImageIcon feild = new ImageIcon(this.getClass().getResource("bg.gif"));
        private ImageIcon imgmemee = new ImageIcon(this.getClass().getResource(""));
	private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
	private ImageIcon starts = new ImageIcon();
	public JButton BStart = new JButton(starts);
	public JButton BExit1  = new JButton(exit);
	homegame(){
            setLayout(null);
             
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1000,800,this);
	}
}