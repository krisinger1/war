package org.risinger;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class War implements ActionListener{
	JPanel panel;
	Color bg=new Color(200,225,255);
	Rectangle p1card= new Rectangle(270,130,73,98);
	Rectangle p2card= new Rectangle(270,330,73,98);

	
	public War(){
		JFrame frame = new JFrame("Tic Tac Toe");
		//frame.setLayout(null);
		frame.getContentPane().setBackground(bg);
		frame.setSize(600, 600);
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		initialize();
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.add(board);
		frame.setVisible(true);
	}
	
	public void initialize(){
		JLabel card1 = new JLabel();
		card1.setBounds(p1card);
		card1.setIcon(new ImageIcon("aclubs.png"));
		panel.add(card1);
		JLabel card2 = new JLabel();
		card2.setBounds(p2card);
		card2.setIcon(new ImageIcon("aclubs.png"));
		panel.add(card2);
		panel.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new War();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
