package algorithymForSort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionSort extends Swap implements Runnable,ActionListener{
	SquarePaint[] squares = null;
	FrameDesign frame = null;
	
	private static boolean interrupted = true;
	private static boolean suspend = false;
	
	public SelectionSort(SquarePaint[] squares,FrameDesign frame)
	{
		this.squares = squares;
		this.frame = frame;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		suspend = false;
		
		while(true) {
			for(int i = (squares.length - 1) ; i > 0 ; i--)
			{
				int max = i;
				for(int j = i - 1; j >= 0 ; j--)
				{
					if( squares[max].getValue() < squares[j].getValue())
					{
						max = j;
					}
				}
				if( max != i)
				{
					super.swap(squares[i], squares[max]);
					frame.myPanel[0].repaint();
					teaxAreaWrite();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}						
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(suspend) {
						break;
					}
					if(!interrupted) {
						break;
					}
				}
				if(suspend) {
					break;
				}
				if( i == 1 ) {
					suspend = true;
				}
			}
			if(suspend) {
				break;
			}
		}
		System.out.println("thread is over");
		frame.statesChange("Stop");
	}
	private void teaxAreaWrite() {
		// TODO Auto-generated method stub
		frame.textArea.setText(null);
		for(int i = 0 ; i < frame.myPanel[0].getArrSize() ; i ++) {
			frame.textArea.append(String.format("%2d", (frame.myPanel[0].square[i].getValue())) + "\t");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("Start")){
			interrupted = false;
		}else if(arg0.getActionCommand().equals("Pause")) {
			interrupted = true;
		}else if(arg0.getActionCommand().equals("Stop")) {
			suspend = true;
		}else if(arg0.getActionCommand().equals("Restart")) {
			suspend = true;
		}
	}

}
