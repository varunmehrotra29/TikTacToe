import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
class First extends JFrame
{
	JButton bt=new JButton("START");
	JLabel la=new JLabel("TIC TAC TOE GAME");
	public First()
	{
		super("Gaming");
		setSize(600,640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(Color.green);
		setLayout(null);
		la.setBounds(150,100,250,40);	
		la.setForeground(Color.red);
		la.setFont(new Font("Monotype Corsiva",0,30));
		add(la);
		bt.setBounds(200,320,150,70);
		bt.setBackground(Color.orange);
		bt.setForeground(Color.cyan);
		bt.setMargin(new Insets(0,0,0,0));
		bt.setFont(new Font("elephant",0,30));
		Border b=BorderFactory.createLineBorder(Color.blue,3);
		bt.setBorder(b);
		bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(bt);
		bt.addActionListener(new ButtonListener());
		setVisible(true);
	}
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			JButton bc=(JButton)evt.getSource();
			new TicTacToe();
		}
	}
	public static void main(String ...args)
	{
		setDefaultLookAndFeelDecorated(true);
		new First();
	}
}