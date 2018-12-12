import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class GUI extends JFrame implements KeyListener{
	Coordinate cord = new Coordinate(245 , 362);
	final LineComponent lineComp = new LineComponent();
	Points[]  point = new Points[105];
	int pointNum = 49 ;
	
	public GUI() {
		// TODO Auto-generated constructor stub
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JButton startButton = new JButton();
		
		
		
		JLabel playground = new JLabel(new ImageIcon("files/playground.jpg"));
		JLabel player1 = new JLabel("#1");
		JLabel player2 = new JLabel("#2");
		
		player1.setPreferredSize(new Dimension(500, 700));
		player2.setPreferredSize(new Dimension(500, 700));

		playground.setSize(490,730);
		panel.add(playground);
	
		
		addKeyListener(this);
		panel.setLayout(null);

		
		player1.setBounds(325 , 680 ,20 ,20);
		player2.setBounds(325 , 35 ,20 ,20);
		player1.setForeground(Color.white);
		player2.setForeground(Color.white);
		
		playground.add(player1);
		playground.add(player2);
		
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
		
		
		for(int i = 0 ; i<105 ; i++){
			Points point1 = new Points(true, true, true, true, true, true, true, true, false,0);
			point[i] = point1 ;
		}
		pointInit(point);
		
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
//forbidden action
	public void pointInit(Points[] point) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < 105 ; i++){
			
			if(i>98){
				if(i == 100 && i == 103 ){
					point[i].adj = 5 ;
				}else{
					
					point[i].goal = true ;
					point[i].adj = 7 ;

				}
			}
			else if(i == 0 ){
				point[i].d = false;
				point[i].e = false;
				point[i].w = false;
				point[i].q = false;
				point[i].a = false;
				point[i].z = false;
				point[i].x = false;
				point[i].adj = 7 ;

			}
			else if((0<i && i< 3 )|| (5<i && i<9)){
				point[i].d = false ;
				point[i].e = false ;
				point[i].w = false ;
				point[i].q = false ;
				point[i].a = false ;
				point[i].adj = 5 ;
				
			}else if(i == 3){
				point[i].w = false ;
				point[i].q = false ;
				point[i].a = false ;
				point[i].adj = 3 ;


			}else if(i == 5){
				point[i].w = false ;
				point[i].e = false ;
				point[i].d = false ;
				point[i].adj = 3 ;

				
			}else if(i == 90){
				point[i].e = false ;
				point[i].w = false ;
				point[i].a = false ;
				point[i].z = false ;
				point[i].x = false ;
				point[i].c = false ;
				point[i].d = false ;
				point[i].adj = 7 ;


			}else if(i == 98){
				point[i].a = false ;
				point[i].z = false ;
				point[i].x = false ;
				point[i].c = false ;
				point[i].d = false ;
				point[i].e = false ;
				point[i].w = false ;
				point[i].adj = 7 ;


				
			}else if((90< i && i<93 )||(95<i && i<98)){
				
				point[i].a = false ;
				point[i].z = false ;
				point[i].x = false ;
				point[i].c = false ;
				point[i].d = false ;
				point[i].adj = 5 ;

				
			}else if(i == 93 ){
				point[i].a = false ;
				point[i].z = false ;
				point[i].x = false ;
				point[i].adj = 3 ;

			}else if( i == 95){
				point[i].d = false ;
				point[i].c = false ;
				point[i].x = false ;
				point[i].adj = 3 ;

			}
			else if(i%9 == 0 ){
				point[i].w = false ;

				point[i].q = false ;
				point[i].a = false ;
				point[i].z = false ;
				point[i].x = false ;
				point[i].adj = 5 ;

				
			}
			else if(i%9 == 8){
				point[i].w = false ;
				point[i].e = false ;
				point[i].d = false ;
				point[i].c = false ;
				point[i].x = false ;
				point[i].adj = 5 ;

			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
//get key
	Random rand=new Random();
	//int A=rand.nextInt(2);
	 int flag;
	public int changeturn(int a){
		if(a==0){
			a=1;
			//System.out.println("changeturn");
			}
		else if(a==1)
			a=0;
		return a;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	flag=changeturn(flag);
	if(flag==0)
	{
		System.out.println("player 1 turn.");
	}
	else if(flag==1)
	{
		System.out.println("player2  turn.");
	}
		
		if(e.getKeyCode() == KeyEvent.VK_D){
			Eest();
			//changeturn(flag);
			
		}if(e.getKeyCode() == KeyEvent.VK_A){
			West();
			//changeturn(flag);
			
		}if(e.getKeyCode() == KeyEvent.VK_W){
			North();
			//changeturn(flag);
			
		}if(e.getKeyCode() == KeyEvent.VK_X){
			South();
			//changeturn(flag);
			
		}if(e.getKeyCode() == KeyEvent.VK_E){
			NorthEast();
			//changeturn(flag);
			
		}if(e.getKeyCode() == KeyEvent.VK_Q){
			NorthWest();
			//changeturn(flag);
			
		}if(e.getKeyCode() == KeyEvent.VK_C){
			SouthEast();
			//changeturn(flag);

		}if(e.getKeyCode() == KeyEvent.VK_Z){
			SouthWest();
			//changeturn(flag);
			
		}
	}
//actions;
	private void SouthWest() {
		// TODO Auto-generated method stub
		if(point[pointNum].z){
			if(pointNum !=95 && pointNum != 94){
	
				System.out.println("south west");
				lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y + 57);
				cord.update(cord ,-1, 1);
				point[pointNum].z = false ;
				point[pointNum].adj ++ ;
				pointNum = pointNum  + 8 ;
				point[pointNum].e = false ;
				if(point[pointNum].adj<=1)
					changeturn(flag);
				point[pointNum].adj ++ ;
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y + 57);
				System.out.println("Player 2 Wins.");
			}
		}
	}

	private void SouthEast() {
		// TODO Auto-generated method stub
		if(point[pointNum].c){
			if(pointNum !=93 && pointNum != 94){

				System.out.println("south east");
				lineComp.addLine(cord.x, cord.y, cord.x + 57 , cord.y + 57);
				cord.update(cord ,1, 1);
				point[pointNum].c = false ;
				point[pointNum].adj ++ ;
				pointNum = pointNum + 10 ;
				point[pointNum].q = false ;
				if(point[pointNum].adj<=1)
					changeturn(flag);
				point[pointNum].adj ++ ;
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{				
				lineComp.addLine(cord.x, cord.y, cord.x + 57 , cord.y + 57);
				System.out.println("Player 2 Wins.");

			}
		}
	}

	private void NorthWest() {
		// TODO Auto-generated method stub
		if(point[pointNum].q){
			if(pointNum !=5 && pointNum != 4){
	
				System.out.println("north west");
				lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y - 57);
				cord.update(cord ,-1, -1);
				point[pointNum].q = false ;
				point[pointNum].adj ++ ;
				pointNum = pointNum - 10 ; 
				point[pointNum].c = false ;
				if(point[pointNum].adj<=1)
					changeturn(flag);
				point[pointNum].adj ++ ;
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y - 57);
				System.out.println("Player 1 Wins.");

			}
		}
	}

	private void NorthEast() {
		// TODO Auto-generated method stub
		if(point[pointNum].e){
			if(pointNum != 3 && pointNum != 4){

				System.out.println("north east");
				lineComp.addLine(cord.x, cord.y, cord.x + 57 , cord.y - 57);
				cord.update(cord, 1, -1);
				point[pointNum].e = false ;
				point[pointNum].adj ++ ;
				pointNum = pointNum - 8 ; 
				point[pointNum].z = false ;
				if(point[pointNum].adj<=1)
					changeturn(flag);
				point[pointNum].adj ++ ;
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x + 57 , cord.y - 57);
				System.out.println("Player 1 Wins.");
			}
		}
	}

	private void South() {
		// TODO Auto-generated method stub
		if(point[pointNum].x){
			if(pointNum !=94 ){

				System.out.println("south");
				lineComp.addLine(cord.x, cord.y, cord.x , cord.y + 57);
				cord.update(cord ,0 , 1);
				point[pointNum].x = false ;
				if(point[pointNum].adj<=1)
					changeturn(flag);
				point[pointNum].adj ++ ;
				pointNum = pointNum + 9 ;
				point[pointNum].w = false ;
				point[pointNum].adj ++ ;
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x , cord.y + 57);
				System.out.println("Player 2 Wins.it was player " +(flag+1)+"turn");
			}
		}
	}

	private void North() {
		// TODO Auto-generated method stub
		if(point[pointNum].w){
			if(pointNum != 4){
				
				System.out.println("north");
				lineComp.addLine(cord.x, cord.y, cord.x , cord.y - 57);
				cord.update(cord ,0,-1);
				point[pointNum].w = false ;
				if(point[pointNum].adj<=1)
					changeturn(flag);
				point[pointNum].adj ++ ;
				pointNum = pointNum - 9 ;
				point[pointNum].x = false ;
				point[pointNum].adj ++ ;
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x , cord.y - 57);
				System.out.println("Player 1 Wins. it was player "+(flag+1)+"turn");
			}
		}		
	}

	private void West() {
		// TODO Auto-generated method stub
		if(point[pointNum].a){

			System.out.println("west");
			lineComp.addLine(cord.x, cord.y, cord.x - 57, cord.y);
			cord.update(cord,-1, 0);
			point[pointNum].a = false ;
			if(point[pointNum].adj<=1)
				changeturn(flag);
			point[pointNum].adj ++ ;
			pointNum -- ;
			point[pointNum].d = false ;
			point[pointNum].adj ++ ;
			System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
		}

	}

	private void Eest() {
		// TODO Auto-generated method stub
		if(point[pointNum].d){
			System.out.println("east");
			lineComp.addLine(cord.x, cord.y, cord.x + 57, cord.y);
			cord.update(cord ,1,0);
			point[pointNum].d = false ;
			if(point[pointNum].adj<=1)
				changeturn(flag);
			point[pointNum].adj ++ ;
			pointNum ++ ;
			point[pointNum].a = false ;
			point[pointNum].adj ++ ;
			System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			//changeturn(flag);
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
