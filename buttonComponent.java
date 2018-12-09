import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class buttonComponent extends JButton {
 ;
	Color white = Color.white;
	
	@Override
	public void setBackground(Color bg) {
		// TODO Auto-generated method stub
		bg = white;
		super.setBackground(bg);
	}
	
	@Override
	public void setBorderPainted(boolean b) {
		// TODO Auto-generated method stub
		b = false ;
		super.setBorderPainted(b);
	}
	@Override
	public void setBorder(Border border) {
		// TODO Auto-generated method stub
		border = new LineBorder(Color.white);
		super.setBorder(border);
	}

	@Override
	public void setOpaque(boolean isOpaque) {
		// TODO Auto-generated method stub
		isOpaque = true;
		super.setOpaque(isOpaque);
	}
	
	@Override
	public void setContentAreaFilled(boolean b) {
		// TODO Auto-generated method stub
		b = true;
		super.setContentAreaFilled(b);
	}
	
	
	
	private static class Button{
	    final int x1; 
	    final int y1;
	    final int x2;
	    final int y2;   
	    final Color color;

	    public Button(int x1, int y1, int x2, int y2, Color color) {
	        this.x1 = x1;
	        this.y1 = y1;
	        this.x2 = x2;
	        this.y2 = y2;
	        this.color = color;
	    }               
	}
	
	
	
	private final LinkedList<Button> buttons = new LinkedList<Button>();

	public void addButton(int x1, int x2, int x3, int x4) {
	    addButton(x1, x2, x3, x4, Color.WHITE);
	}
	
	public void addButton(int x1, int x2, int x3, int x4, Color color) {
	    buttons.add(new Button(x1, x2, x3, x4, color));        
	    repaint();
	}
	
	
	public void clearButton() {
	    buttons.clear();
	    repaint();
	}
	@Override
	public void setBounds(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		super.setBounds(x, y, width, height);
	}
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(Button button : buttons){
			g.drawLine(button.x1, button.y1, button.x2, button.y2);
		}
	}
	
}
