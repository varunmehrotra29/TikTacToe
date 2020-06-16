import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.JOptionPane;
class TicTacToe extends JFrame
{
	JLabel la=new JLabel(new ImageIcon(getClass().getResource("images/t2.jpg")));
	JPanel []pa=new JPanel[3];
	JLabel msg=new JLabel("First Player Turn...");
	JButton reset=new JButton("Reset");
	JButton bt[]=new JButton[9];
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	String player="";
	int user=1;
	int count=0;
	boolean winner=false;
	public TicTacToe()
	{
		super("TicTacToe");
		setSize(600,640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setResizable(false);
		add(la);
		addPanels();
		//JOptionPane.showMessageDialog(getContentPane(),"Oooops!!!(Press ok)");
		setVisible(true);
	}
	private void addPanels()
	{
		la.setLayout(null);
		for(int i=0;i<3;i++)
		{
			pa[i]=new JPanel();
			la.add(pa[i]);
		}
		pa[0].setBounds(100,30,400,40);
		pa[1].setBounds(100,100,400,400);
		pa[2].setBounds(100,530,400,40);
		addInfo();
		addButtons();
	}
	
	private void addInfo()
	{
		pa[0].add(msg);
		msg.setFont(new Font("elephant",0,25));
		msg.setForeground(Color.blue);
		pa[2].add(reset);
		pa[2].setOpaque(false);
		reset.setFont(new Font("arial",0,20));
		reset.addActionListener(new ResetListener());
		reset.setEnabled(false);
	}
	private void addButtons()
	{
		
		Border b=BorderFactory.createLineBorder(Color.red,3);
		pa[1].setBorder(b);
		pa[1].setLayout(new GridLayout(3,3));
		TicListener li=new TicListener();
		for(int i=0;i<9;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(li);
			bt[i].setBackground(Color.green);
			bt[i].setBorder(b);
			pa[1].add(bt[i]);
		}
	}
	class TicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			JButton bc=(JButton)evt.getSource();
			if(bc.getIcon()!=null || winner)
			return;
			if(user==1)
			{
				bc.setIcon(icon1);
				msg.setText("Second Player Turn..");
				msg.setForeground(Color.red);
				user=2;
				player="First";
				findWinner(icon1);
			}
			else if(user==2)
			{
				bc.setIcon(icon2);
				msg.setText("First Player Turn..");
				msg.setForeground(Color.blue);
				user=1;
				player="Second";
				findWinner(icon2);
			}
			count++;
			if(count==9 && !winner)
			{
				msg.setText("it's a tie..");
				msg.setForeground(Color.red);
				reset.setEnabled(true);
			}
		
	        //JOptionPane.showMessageDialog(getContentPane(),"Oooops!!!(Press ok)");
		}
		private void findWinner(ImageIcon img)
		{
			if(bt[0].getIcon()==img && bt[1].getIcon()==img && bt[2].getIcon()==img)
			  announcewinner(0,1,2);
			if(bt[3].getIcon()==img && bt[4].getIcon()==img && bt[5].getIcon()==img)
			  announcewinner(3,4,5);
			if(bt[6].getIcon()==img && bt[7].getIcon()==img && bt[8].getIcon()==img)
			  announcewinner(6,7,8);
			if(bt[0].getIcon()==img && bt[3].getIcon()==img && bt[6].getIcon()==img)
			  announcewinner(0,3,6);
			if(bt[1].getIcon()==img && bt[4].getIcon()==img && bt[7].getIcon()==img)
			  announcewinner(1,4,7);
			if(bt[2].getIcon()==img && bt[5].getIcon()==img && bt[8].getIcon()==img)
			  announcewinner(2,5,8);
			if(bt[0].getIcon()==img && bt[4].getIcon()==img && bt[8].getIcon()==img)
			  announcewinner(0,4,8);
			if(bt[2].getIcon()==img && bt[4].getIcon()==img && bt[6].getIcon()==img)
			  announcewinner(2,4,6);
		}
		private void announcewinner(int i,int j,int z)
		{
			msg.setText(player+" player won!!");
			bt[i].setBackground(Color.gray);
			bt[j].setBackground(Color.gray);
			bt[z].setBackground(Color.gray);
			winner=true;
			reset.setEnabled(true);
			
	                JOptionPane.showMessageDialog(getContentPane(),"Game Over!!");
		}
	}
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			for(int i=0;i<9;i++)
			{
				bt[i].setIcon(null);
				bt[i].setBackground(Color.green);
			}
			msg.setText("First Player Turn..");
			msg.setForeground(Color.blue);
			user=1;
			count=0;
			winner=false;
			reset.setEnabled(false);
		}
	}
	public static void main(String []args)
	{
		setDefaultLookAndFeelDecorated(true);
		new TicTacToe();
	}
}
