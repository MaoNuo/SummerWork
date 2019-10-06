package algorithymForSort;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class FrameDesign extends JFrame implements ActionListener{
	
	/**
	 * @author MaoNuo
	 * @function create frame
	 */
	private static final long serialVersionUID = 1L;
	
	//set containers
	private static final int panelSize = 2;
	private static final int myPanelSize = 2;
	private static final int menuItemSize = 2;
	private static final int buttonSize = 3;
	private static final int labelSize = 4;
	private static final int radioButtonSize = 4;
	private static final Font font = new Font("Microsoft YaHei UI", Font.PLAIN, 12);

	protected MyPanel[] myPanel = null;
	private JPanel contentPane = null;
	private JPanel[] panel = null;
	private JMenuBar menubar = null;
	private JMenu menu = null;
	private JMenuItem[] menuItem = null;
	protected JTextArea textArea = null;
	private JButton[] button = null;
	private JLabel[] label = null;
	private JRadioButton[] radioButton = null;
	private ButtonGroup buttonGroup = null;
	private BubbleSort bubbleSort = null;
	private CocktailSort cocktailSort = null;
	private InsertSort insertSort = null;
	private SelectionSort selectionSort = null;
	private Thread thread = null;
	
	public FrameDesign()
	{
		//create containers
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		myPanel = new MyPanel[myPanelSize];
		
		myPanel[0] = new MyPanel();
		myPanel[0].setBounds(0, 20, 700, 400);
		
//		myPanel[1] = new MyPanel();
//		myPanel[1].setBounds(0, 420, 700, 40);
//		myPanel[1].setBackground(Color.WHITE);
//		myPanel[1].setBorder(new LineBorder(new Color(0,0,0)));
//		myPanel[1].setLayout(null);
		
		panel = new JPanel[panelSize];
		panel[0] = new JPanel();	
		panel[0].setBounds(700, 20, 130, 440);
		panel[0].setBorder(new LineBorder(new Color(0,0,0)));
		panel[0].setLayout(null);
		
		panel[1] = new JPanel();
		panel[1].setBounds(0, 420, 700, 40);
		panel[1].setBackground(Color.WHITE);
		panel[1].setBorder(new LineBorder(new Color(0,0,0)));
		panel[1].setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 65, 105, 165);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setEditable(false);
		textArea.setLineWrap(true);	
		textArea.setWrapStyleWord(true);	
		textArea.setTabSize(2);
		for(int i = 0 ; i < myPanel[0].getArrSize() ; i ++) {
			textArea.append(String.format("%2d", (myPanel[0].list.get(i))) + "\t");
		}
		

		
		//Start button
		button = new JButton[buttonSize];
		button[0] = new JButton();
		button[0].setBounds(10, 345, 20, 20);
		button[0].setIcon(new ImageIcon("src/Images/button.png"));
		button[0].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


		//Pause button
		button[1] = new JButton();
		button[1].setBounds(10, 370, 20, 20);
		button[1].setIcon(new ImageIcon("src/Images/button.png"));
		button[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		button[1].setEnabled(false);
		
		//Stop button
		button[2] = new JButton();
		button[2].setBounds(10, 395, 20, 20);
		button[2].setIcon(new ImageIcon("src/Images/button.png"));
		button[2].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		radioButton = new JRadioButton[radioButtonSize];
		radioButton[0] = new JRadioButton("Bubble Sort");
		radioButton[0].setSelected(true);
		radioButton[0].setFont(font);
		radioButton[0].setBounds(10, 240, 115, 20);
		radioButton[0].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		radioButton[1] = new JRadioButton("Selection Sort");
		radioButton[1].setFont(font);
		radioButton[1].setBounds(10, 265, 115, 20);
		radioButton[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		radioButton[2] = new JRadioButton("Insert Sort");
		radioButton[2].setFont(font);
		radioButton[2].setBounds(10, 290, 115, 20);
		radioButton[2].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		radioButton[3] = new JRadioButton("Cocktail Sort");
		radioButton[3].setFont(font);
		radioButton[3].setBounds(10, 315, 115, 20);
		radioButton[3].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton[0]);
		buttonGroup.add(radioButton[1]);
		buttonGroup.add(radioButton[2]);
		buttonGroup.add(radioButton[3]);
		
		//instanse for sort
		bubbleSort = new BubbleSort(myPanel[0].square,this);
		cocktailSort = new CocktailSort(myPanel[0].square,this);
		insertSort = new InsertSort(myPanel[0].square,this);
		selectionSort = new SelectionSort(myPanel[0].square,this);
		
		button[0].addActionListener(this);
		button[0].addActionListener(bubbleSort);
		button[0].addActionListener(insertSort);
		button[0].addActionListener(selectionSort);
		button[0].addActionListener(cocktailSort);
		button[0].setActionCommand("Start");
		
		button[1].addActionListener(this);
		button[1].addActionListener(bubbleSort);
		button[1].addActionListener(insertSort);
		button[1].addActionListener(selectionSort);
		button[1].addActionListener(cocktailSort);
		button[1].setActionCommand("Pause");
		
		button[2].addActionListener(this);
		button[2].addActionListener(bubbleSort);
		button[2].addActionListener(insertSort);
		button[2].addActionListener(selectionSort);
		button[2].addActionListener(cocktailSort);
		button[2].setActionCommand("Stop");
		
		label = new JLabel[labelSize];
		label[0] = new JLabel("Order Now");
		label[0].setBounds(10, 40, 115, 20);
		label[0].setFont(font);
		
		label[1] = new JLabel("Start");
		label[1].setBounds(35, 345, 85, 20);
		label[1].setFont(font);
		
		label[2] = new JLabel("Pause");
		label[2].setBounds(35, 370, 85, 20);
		label[2].setFont(font);
		
		label[3] = new JLabel("Stop");
		label[3].setBounds(35, 395, 85, 20);
		label[3].setFont(font);

		
		menubar = new JMenuBar();
		menubar.setBounds(0, 0, 800, 20);
		
		menu = new JMenu("Menu");
		menu.setFont(font);
		
		menuItem = new JMenuItem[menuItemSize];
		menuItem[0] = new JMenuItem("Restart");
		menuItem[0].setFont(font);
		menuItem[0].addActionListener(this);
		menuItem[0].addActionListener(bubbleSort);
		menuItem[0].addActionListener(cocktailSort);
		menuItem[0].addActionListener(selectionSort);
		menuItem[0].addActionListener(insertSort);
		menuItem[0].setActionCommand("Restart");
		
		menuItem[1] = new JMenuItem("Exit");
		menuItem[1].setFont(font);
		menuItem[1].addActionListener(this);
		menuItem[1].setActionCommand("Exit");
		
		//add containers
		contentPane.add(panel[0]);
		contentPane.add(panel[1]);
		contentPane.add(myPanel[0]);
//		contentPane.add(myPanel[1]);
		contentPane.add(menubar);
		
		panel[0].add(button[0]);
		panel[0].add(button[1]);
		panel[0].add(button[2]);
		panel[0].add(label[0]);
		panel[0].add(label[1]);
		panel[0].add(label[2]);
		panel[0].add(label[3]);
		panel[0].add(radioButton[0]);
		panel[0].add(radioButton[1]);
		panel[0].add(radioButton[2]);
		panel[0].add(radioButton[3]);
		panel[0].add(textArea);
		
		menubar.add(menu);
		menu.add(menuItem[0]);
		menu.addSeparator();
		menu.add(menuItem[1]);
		
		//add contents to frame
		this.add(contentPane);
		
		//Frame setting
		this.setTitle("Sort");
		this.setIconImage(new ImageIcon("src/Images/icon.png").getImage());
		this.setSize(830, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//visible
		this.setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
//		if(arg0.getActionCommand().equals("Restart"))
//		{
//			this.statesChange("Restart");
//		}
//		else if(arg0.getActionCommand().equals("Exit"))
//		{
//
//		}else if(arg0.getActionCommand().equals("Start"))
//		{
//
//
//		}else if(arg0.getActionCommand().equals("Pause")) {
//
//		}else if(arg0.getActionCommand().equals("Stop")) {
//
//		}
		statesChange(arg0.getActionCommand());
	}
	
	public void statesChange(String states) {
		if(states.equals("Restart")) {
			button[0].setEnabled(true);
			button[1].setEnabled(false);
			this.myPanel[0].resetPanel();
			this.myPanel[0].repaint();
			textArea.setText(null);
			for(int i = 0 ; i < myPanel[0].getArrSize() ; i ++) {
				this.textArea.append(String.format("%2d", (myPanel[0].list.get(i))) + "\t");
			}
			if(thread != null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				thread = null;
			}
			for(int i = 0; i < radioButtonSize; i++) {
				radioButton[i].setEnabled(true);
			}
		}
		else if(states.equals("Start")) {
			if(radioButton[0].isSelected()){
				if(thread == null)
				{
					thread = new Thread(bubbleSort);
					thread.start();
				}
				
			}else if(radioButton[1].isSelected()) {
				if(thread == null)
				{
					thread = new Thread(selectionSort);
					thread.start();
				}
			}else if(radioButton[2].isSelected()) {
				if(thread == null)
				{
					thread = new Thread(insertSort);
					thread.start();
				}
			}else if(radioButton[3].isSelected()) {	
				if(thread == null)
				{
					thread = new Thread(cocktailSort);
					thread.start();
				}
			}
			button[0].setEnabled(false);
			button[1].setEnabled(true);
			for(int i = 0; i < radioButtonSize; i++) {
				if(!radioButton[i].isSelected()) {
					radioButton[i].setEnabled(false);
				}
			}
		}
		else if(states.equals("Pause")) {
			button[0].setEnabled(true);
			button[1].setEnabled(false);
		}
		else if(states.equals("Stop")) {
			button[0].setEnabled(true);
			button[1].setEnabled(false);
			if(thread != null) {
				thread = null;
			}
			for(int i = 0; i < radioButtonSize; i++) {
				radioButton[i].setEnabled(true);
			}
		}
		else if(states.equals("Exit")) {
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		new FrameDesign();
	}
}
