package algorithymForSort;
import java.awt.*;
import javax.swing.*;

public class PaintPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void  paint(Graphics g)
	{
		super.paint(g);
		Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Images/triangular.png"));
		g.drawImage(im, 20, 20, 24, 16, this);
	}
	
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("test");
		PaintPanel pp = new PaintPanel();
		
		jf.add(pp);
		
		jf.setVisible(true);
		jf.setSize(400, 300);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
