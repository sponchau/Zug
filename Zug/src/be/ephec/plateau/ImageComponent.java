package be.ephec.plateau;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

public class ImageComponent extends Component
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image monImage;
        
    public ImageComponent(Image monImage)
    {
        this.monImage = monImage; 
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.drawImage(monImage, 0, 0, getWidth(), getHeight(), null, null);
       
    }
}
