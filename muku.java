package javaapplication7;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class muku{
    
    public ImageIcon[] im = new ImageIcon[4];
    public int x;
    public int y;
    public int count = 0;
    muku(){
        for(int i=0;i<im.length;i++){
            im[i] = new ImageIcon(this.getClass().getResource((i+1)+".png"));
	}
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,150,200));
    }
    public Rectangle2D getboundG(){
    	return (new Rectangle2D.Double(x,y+50,150,200));
    }
}