package algorithymForSort;
import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int arraySize = 35;
	CreateDisorderArr list = null;
	SquarePaint[] square = null;
	
	public MyPanel()
	{
		list = new CreateDisorderArr(arraySize);
		square = new SquarePaint[arraySize];
		for(int i = 0 ; i < square.length ; i++)
		{
			square[i] = new SquarePaint(list.get(i),i);
		}
	}
	
	public void resetPanel()
	{
		this.list.resetArr();
		for(int i = 0 ; i < square.length ; i++)
		{
			square[i] = new SquarePaint(list.get(i),i);
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(new Color(238, 130, 238));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		g.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		for(int i = 0 ; i < arraySize ; i ++)
		{
			paintSquare(g,square[i]);
		}
	}
	
	public void paintSquare(Graphics g,SquarePaint sp)
	{
		g.drawString(String.valueOf(sp.getValue()), sp.getOrder() * 20 + 3, this.getHeight() - 10 * sp.getValue() - 10);
		g.drawRect( 20 * sp.getOrder(), this.getHeight() - 10 * sp.getValue(), 20, 10 * sp.getValue());
	}
	
	public int getArrSize()
	{
		return arraySize;
	}
}

class SquarePaint
{
	private int value;
	private int order;
	
	public SquarePaint(int value,int order)
	{
		this.value = value;
		this.order = order;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}


}
