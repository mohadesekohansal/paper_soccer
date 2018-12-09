import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GUI extends JFrame implements KeyListener{

	Coordinate cord = new Coordinate(245 , 362);
	final LineComponent lineComp = new LineComponent();
	
	public GUI() {
		// TODO Auto-generated constructor stub
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JButton startButton = new JButton();
		
		
		JLabel playground = new JLabel(new ImageIcon("files/playground.jpg"));
		
		playground.setSize(490,730);
		panel.add(playground);
	
		
		addKeyListener(this);
		panel.setLayout(null);

		
		buttonComponent but = new buttonComponent();
		
		setVisible(true);
		
		for (int i =0 ; i<9 ; i++){
			for(int j = 0 ; j< 11 ; j++){
				JButton btn = new JButton();
				
				btn.setBounds(17+i*57 , 77+j*57 ,3 ,4);
				playground.add(btn);
			}
		}
		JButton btn = new JButton();
		
		btn.setBounds(245 , 20 ,3 ,4);
		playground.add(btn);
		btn = new JButton();
		
		btn.setBounds(245 , 704 ,3 ,4);
		playground.add(btn);
		
		lineComp.setPreferredSize(new Dimension(400, 600));
	
		startButton.setOpaque(true);

		startButton.setBounds(245, 362, 6, 6);
		playground.add(startButton);
		playground.add(lineComp);
		
		lineComp.setBounds(0,0,500,700);		
		
		
		
		Color darkGreen = new Color(44, 108, 64);
		panel.setBackground(darkGreen);

		this.add(panel,BorderLayout.CENTER);
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_D){
			System.out.println("east");
			lineComp.addLine(cord.x, cord.y, cord.x + 57, cord.y);
			cord.x = cord.x + 57 ;
			cord.location();
			
			
		}if(e.getKeyCode() == KeyEvent.VK_A){
			System.out.println("west");
			lineComp.addLine(cord.x, cord.y, cord.x - 57, cord.y);
			cord.x = cord.x - 57 ;
			cord.location();

			
		}if(e.getKeyCode() == KeyEvent.VK_W){
			System.out.println("north");
			lineComp.addLine(cord.x, cord.y, cord.x , cord.y - 57);
			cord.y = cord.y - 57 ;
			cord.location();

			
		}if(e.getKeyCode() == KeyEvent.VK_X){
			System.out.println("south");
			lineComp.addLine(cord.x, cord.y, cord.x , cord.y + 57);
			cord.y = cord.y + 57 ;
			cord.location();

			
		}if(e.getKeyCode() == KeyEvent.VK_E){
			System.out.println("north east");
			lineComp.addLine(cord.x, cord.y, cord.x + 57 , cord.y - 57);
			cord.x = cord.x + 57;
			cord.y = cord.y - 57;
			cord.location();

		
		}if(e.getKeyCode() == KeyEvent.VK_Q){
			System.out.println("north west");
			lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y - 57);
			cord.x = cord.x - 57;
			cord.y = cord.y - 57;
			cord.location();

			
		}if(e.getKeyCode() == KeyEvent.VK_C){
			System.out.println("south east");
			lineComp.addLine(cord.x, cord.y, cord.x + 57 , cord.y + 57);
			cord.x = cord.x + 57;
			cord.y = cord.y + 57;
			cord.location();

		}if(e.getKeyCode() == KeyEvent.VK_Z){
			System.out.println("south west");
			lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y + 57);
			cord.x = cord.x - 57;
			cord.y = cord.y + 57;
			cord.location();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
