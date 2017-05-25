package org.risinger;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.media.jfxmedia.events.PlayerEvent;

public class WarGame extends JFrame{

	JPanel gamePanel;
	JLabel deck1Label;
	JLabel deck2Label;
	JLabel card1Label;
	JLabel card2Label;
	//Hand hand1,hand2;
	GameRunner gameRunner;

	public WarGame(){
		super("War");

		gameRunner=new GameRunner();

		gamePanel=new JPanel();
		gamePanel.setMinimumSize(new Dimension(1000,700));
		gamePanel.setBackground(new Color(0,180,0));
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));

		deck1Label = new JLabel(new ImageIcon("images/blue-back-stack.png"));
		deck1Label.setName("Deck 1");
		deck2Label = new JLabel(new ImageIcon("images/blue-back-stack.png"));
		deck2Label.setName("Deck 2");

		deck1Label.setAlignmentX(CENTER_ALIGNMENT);
		deck2Label.setAlignmentX(CENTER_ALIGNMENT);
		deck1Label.addMouseListener(new MyMouseListener());
		//deck2Label.addMouseListener(new MyMouseListener());

		card1Label = new JLabel(new ImageIcon("images/aclubs.png"));
		card2Label = new JLabel(new ImageIcon("images/aclubs.png"));
		card1Label.setAlignmentX(CENTER_ALIGNMENT);
		card2Label.setAlignmentX(CENTER_ALIGNMENT);

		gamePanel.add(Box.createRigidArea(new Dimension(0,50)));
		gamePanel.add(deck1Label);
		gamePanel.add(Box.createRigidArea(new Dimension(0,10)));
		gamePanel.add(card1Label);
		gamePanel.add(Box.createRigidArea(new Dimension(0,100)));
		gamePanel.add(card2Label);
		gamePanel.add(Box.createRigidArea(new Dimension(0,10)));
		gamePanel.add(deck2Label);

		setMinimumSize(new Dimension(1000,700));
		add(gamePanel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class MyMouseListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent event) {
			LinkedList<ImageIcon> cardIcons;
			JLabel deckLabel = (JLabel)event.getSource();
			//System.out.println(deckLabel.getName() + " clicked");
			System.out.println("turn a new card here...");
			cardIcons=gameRunner.playCard();
			if (cardIcons==null) {
				System.out.println("GAME OVER");
				return;
			}
			
			//System.out.println(cardIcons);
			card1Label.setIcon(cardIcons.get(0));
			card2Label.setIcon(cardIcons.get(1));
			gameRunner.battle();
			System.out.println(gameRunner.handSizes()[0]+" "+gameRunner.handSizes()[1]);
			if (gameRunner.handSizes()[0]<20){
				deck1Label.setIcon(new ImageIcon("images/blue-back.png"));
			}
			else deck1Label.setIcon(new ImageIcon("images/blue-back-stack.png"));
		}
	}


}

//final class MyMouseListener extends MouseAdapter{
//
//	@Override
//	public void mouseClicked(MouseEvent event) {
//		JLabel deckLabel = (JLabel)event.getSource();
//		System.out.println(deckLabel.getName() + " clicked");
//		System.out.println("turn a new card here...");
//
//
//	}
//
//}
