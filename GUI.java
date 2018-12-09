import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame{

	public GUI() {
		// TODO Auto-generated constructor stub
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JButton startButton = new JButton();
		
		final LineComponent lineComp = new LineComponent();
		JLabel playground = new JLabel(new ImageIcon("files/playground.jpg"));
		
		playground.setSize(490,730);
		panel.add(playground);

		

		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startButton.setBackground(Color.red);
				
			}
		};
		
		
		panel.setLayout(null);

		
		buttonComponent but = new buttonComponent();
		
		
		
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
		
		btn.setBounds(245 , 647+57 ,3 ,4);
		playground.add(btn);
		
		lineComp.setPreferredSize(new Dimension(400, 600));
	
		Color darkGreen = new Color(44, 108, 64);
		panel.setBackground(darkGreen);

		this.add(panel,BorderLayout.CENTER);
	
	}
	
	
	
}
