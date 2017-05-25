package old;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.risinger.Card;
import org.risinger.Suit;

class SpritePanel extends JPanel{
	CardImage cardImage=new CardImage(270,130);
	CardImage cardImage2=new CardImage(270,330);
	//int imgX,imgY;
	int frame = 0;
	int frame2 = 1;

	SpritePanel(){
//		cardImage =
//		imgX=x;
//		imgY=y;
		addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	frame++;
               changeCard(frame);

            }
        });
	}

	public void changeCard(int frame){
		cardImage.setFrame(frame);
//		repaint(imgX,imgY,73,98);
		//repaint(cardImage.x,cardImage.y,cardImage.width,cardImage.height);

	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        cardImage.paintCardImage(g);
    }
}

class CardImage implements ImageObserver{
	int x,y,width,height,columns,frame;
	Image source;

	public CardImage(int x, int y){
		try {
	          this.source = ImageIO.read(new File("sprites.png"));
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
		this.x=x;
		this.y=y;
		this.columns=13;
		this.width=73;
		this.height=98;
		frame=0;
	}

	public void setFrame(int frame){
		this.frame=frame;
	}

	public void paintCardImage(Graphics g){
		int frameX = (frame % columns) * width;
		int frameY = (frame / columns) * height;
		g.drawImage(source, x, y, x+width, y+height,
		         frameX, frameY, frameX+width, frameY+height, this);
	}
	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}
}

public class War implements ActionListener, ImageObserver{
	JPanel panel;
//	SpritePanel drawPanel = new SpritePanel(270,130);
//	SpritePanel drawPanel2 = new SpritePanel(270,330);

	Graphics g;
	Color bg=new Color(200,225,255);
	Rectangle p1cardBounds= new Rectangle(270,130,73,98);
	Rectangle p2cardBounds= new Rectangle(270,330,73,98);

//	public static Image loadSprite(String file) {
//
//        Image sprite = null;
//
//        try {
//            sprite = ImageIO.read(new File(file));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return sprite;
//    }
//
	public War(){
		JFrame frame = new JFrame("War");
		//frame.setLayout(null);
		frame.getContentPane().setBackground(bg);
		frame.setSize(600, 600);
		//panel = new JPanel();
		//panel.setOpaque(false);
		//panel.setBounds(0, 0, 600, 600);
		//frame.getContentPane().add(panel);
		//panel.setLayout(null);

		initialize();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//frame.add(board);
		frame.setVisible(true);
//		drawPanel.setOpaque(false);
//		drawPanel2.setOpaque(false);

		//drawPanel.setBounds(270,130,73,98);
		//drawPanel2.setBounds(270,330,73,98);
		//drawPanel.setLayout(null);
//		frame.getContentPane().add(drawPanel);
//		frame.getContentPane().add(drawPanel2);


	}

	public void initialize(){
		Card aclubs=new Card(Suit.CLUBS,1);
		aclubs.setImage("aclubs.png");
		JLabel card1 = new JLabel();
		//panel.add(card1);
		card1.setBounds(p1cardBounds);
		aclubs.displayCard(card1);
		//drawPanel.changeCard(aclubs);
		Card twoclubs=new Card(Suit.CLUBS,2);
		//drawPanel2.changeCard(twoclubs);

		JLabel card2 = new JLabel();
		card2.setBounds(p2cardBounds);
		card2.setIcon(new ImageIcon("aclubs.png"));
		//panel.add(card2);
		//panel.setVisible(true);

		JButton stack1 = new JButton(new ImageIcon("blue-back.png"));
		stack1.setBounds(270,30,73,98);
		stack1.addActionListener(this);
		//panel.add(stack1);

	}

	public void displayCard(Card c, Rectangle r){
//		JLabel card1 = new JLabel();
//		card1.setBounds(r);
//		card1.setIcon(new ImageIcon(c.getImage()));
//		panel.add(card1);

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
		JOptionPane.showMessageDialog(null, "you clicked the button");
		//drawPanel.repaint();
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}

}
