import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.plaf.synth.SynthStyle;

public class GUI extends JFrame implements KeyListener{
	Coordinate cord = new Coordinate(245 , 362);
	final LineComponent lineComp = new LineComponent();
	Action action ;
	static Points[]  point = new Points[105];
	static Points[]  temp_point = new Points[105];
	
	

	int pointNum = 49 ;
	Minimax minimax = new Minimax(pointNum);

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
			Points point1 = new Points(true, true, true, true, true, true, true, true, false,0,0);
			point[i] = point1 ;
//			temp_point[i] = point1 ;
		}
		pointInit(point);
//		System.arraycopy(point, 0, temp_point, 0, point.length);
		System.out.println(point[99].value);
		
		init_temp_point();
		
		lineComp.setPreferredSize(new Dimension(400, 600));
		
//		System.out.println(point[46].a);
//		System.out.println(temp_point[46].a);

//		action = minimax.minimax_decision(pointNum,temp_point);
		
//		System.out.println(point[46].a);		
//		System.out.println(temp_point[46].a);
//

		startButton.setOpaque(true);

		startButton.setBounds(245, 362, 6, 6);
		playground.add(startButton);
		playground.add(lineComp);
		
		lineComp.setBounds(0,0,500,700);		
		
		Color darkGreen = new Color(44, 108, 64);
		panel.setBackground(darkGreen);

		this.add(panel,BorderLayout.CENTER);
	
	}
	private void init_temp_point() {
		// TODO Auto-generated method stub
		for (int i = 0; i < point.length; i++) {
			
			temp_point[i] =new  Points(point[i].a, point[i].q, point[i].w, point[i].d,point[i].e, point[i].x, point[i].z, point[i].c, point[i].goal, point[i].adj,point[i].value) ;
		}
	}
//forbidden action
	private void pointInit(Points[] point) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < 105 ; i++){
			
			if(i>98){
				if(i == 100 && i == 103 ){
					point[i].adj = 5 ;
					point[i].goal = true ;
					if(i == 100){
						point[i].d = false;
						point[i].c = false;
						point[i].a = false;
						point[i].z = false;
						point[i].x = false;
					}else{
						
						point[i].d = false;
						point[i].e = false;
						point[i].w = false;
						point[i].q = false;
						point[i].a = false;
					}
				}else{
					
					point[i].goal = true ;
					point[i].adj = 7 ;
					if(i == 99){
						point[i].d = false;
						point[i].c = false;
						point[i].w = false;
						point[i].q = false;
						point[i].a = false;
						point[i].z = false;
						point[i].x = false;
					}else if( i == 101){
						point[i].d = false;
						point[i].e = false;
						point[i].w = false;
						point[i].c = false;
						point[i].a = false;
						point[i].z = false;
						point[i].x = false;
					}else if(i == 102){
						point[i].d = false;
						point[i].e = false;
						point[i].w = false;
						point[i].q = false;
						point[i].a = false;
						point[i].z = false;
						point[i].x = false;
					}else if(i == 104){
						point[i].d = false;
						point[i].e = false;
						point[i].w = false;
						point[i].q = false;
						point[i].a = false;
						point[i].c = false;
						point[i].x = false;
					}

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
	/*private void NoPossibleAction(int i,int adj,int flag)
	{
		if(i%9 == 8 || i%9 == 0||(90< i && i<93 )||
			(95<i && i<98)||(0<i && i< 3 )|| (5<i && i<9))
				if(adj==5)
					System.out.println("there is no more action.player" +(flag+1)+"win");
			
			else if(i==3 ||i==5 ||i==93 ||i==95)
				if(adj==3)
						System.out.println("there is no more action.player "+(flag+1)+"win");
				
			else if(i==0 ||i==100||i==90 ||i==98 ||i==103 )
				if(adj==7)
					System.out.println("there is no more action.player "+(flag+1)+"win");
			else
				if(adj==8)
					System.out.println("there is no more action.player "+(flag+1)+"win");
	}*/
	
//************************************************
	 int changeturn(int a){
		if(a==0){
			a=1;
			}
		else if(a==1)
			a=0;
		return a;
	}
	
	
	int flag=1;
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == KeyEvent.VK_D){
			East();
			
			
		}if(e.getKeyCode() == KeyEvent.VK_A){
			West();
			
			
		}if(e.getKeyCode() == KeyEvent.VK_W){
			North();
			
			
		}if(e.getKeyCode() == KeyEvent.VK_X){
			South();
			
			
		}if(e.getKeyCode() == KeyEvent.VK_E){
			NorthEast();
			
			
		}if(e.getKeyCode() == KeyEvent.VK_Q){
			NorthWest();
			
			
		}if(e.getKeyCode() == KeyEvent.VK_C){
			SouthEast();
		

		}if(e.getKeyCode() == KeyEvent.VK_Z){
			SouthWest();
				
		}
		if(flag==0)
		{
			System.out.println("player 1 turn.");
			init_temp_point();
			action = minimax.minimax_decision(pointNum,temp_point);
			Act(action);
//			randomAct();
		}
		else if(flag==1)
		{
			System.out.println("player2  turn.");
		}
	
}
	
//actions;
	public void SouthWest() {
		
		if(point[pointNum].z){
			if(pointNum !=95 && pointNum != 94){
	
				System.out.println("south west");
				lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y + 57);
				cord.update(cord ,-1, 1);
				//NoPossibleAction(pointNum,point[pointNum].adj,flag );
				point[pointNum].z = false ;
				point[pointNum].adj ++ ;
				pointNum=pointNum+8;
				point[pointNum].e = false ;
				point[pointNum].adj ++ ;
				if(point[pointNum].adj==8)
					JOptionPane.showMessageDialog(null,"there is no more action.player "+(flag+1)+"win");
				if(point[pointNum].adj<2){
					flag=changeturn(flag);}
				else
					{
						if(flag==0){
							init_temp_point();
							action = minimax.minimax_decision(pointNum,temp_point);
							Act(action);
//							randomAct();
						}
					}
				}
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y + 57);
				System.out.println("Player 2 Wins.it was not player "+(flag+1)+"turn");
				JOptionPane.showMessageDialog(null,"Player 2 Wins.it was not player "+(flag+1)+"turn");
			}
		}

	public void SouthEast() {
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
				point[pointNum].adj ++ ;
				if(point[pointNum].adj==8)
					JOptionPane.showMessageDialog(null,"there is no more action.player "+(flag+1)+"win");
				//NoPossibleAction(pointNum,point[pointNum].adj,flag );
				if(point[pointNum].adj<2)
					flag=changeturn(flag);
				else
				{
					if(flag==0){
						init_temp_point();
						action = minimax.minimax_decision(pointNum,temp_point);
						Act(action);
//						randomAct();
					}
				}
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{				
				lineComp.addLine(cord.x, cord.y, cord.x + 57 , cord.y + 57);
				System.out.println("Player 2 Wins.it was not player "+(flag+1)+"turn");
				JOptionPane.showMessageDialog(null,"Player 2 Wins.it was not player "+(flag+1)+"turn");	
				
			}
		}
	}

	public void NorthWest() {
		// TODO Auto-generated method stub
		if(point[pointNum].q){
			if(pointNum !=5 && pointNum != 4){
	
				System.out.println("north west");
				lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y - 57);
				cord.update(cord ,-1, -1);
				//NoPossibleAction(pointNum,point[pointNum].adj,flag );
				point[pointNum].q = false ;
				point[pointNum].adj ++ ;
				pointNum = pointNum - 10 ; 
				point[pointNum].c = false ;
				point[pointNum].adj ++ ;
				if(point[pointNum].adj==8)
					JOptionPane.showMessageDialog(null,"there is no more action.player "+(flag+1)+"win");
				if(point[pointNum].adj<2)
					flag=changeturn(flag);
				else
				{
					if(flag==0){
						init_temp_point();
						action = minimax.minimax_decision(pointNum,temp_point);
						Act(action);
//						randomAct();
					}
				}
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x - 57 , cord.y - 57);
				System.out.println("Player 1 Wins.it was not player "+(flag+1)+"turn");
				JOptionPane.showMessageDialog(null,"Player 1 Wins.it was not player "+(flag+1)+"turn");
			}
		}
	}

	public void NorthEast() {
		
		if(point[pointNum].e){
			if(pointNum != 3 && pointNum != 4){

				System.out.println("north east");
				lineComp.addLine(cord.x, cord.y, cord.x + 57 , cord.y - 57);
				cord.update(cord, 1, -1);
				//NoPossibleAction(pointNum,point[pointNum].adj,flag );
				point[pointNum].e = false ;
				point[pointNum].adj ++ ;
				pointNum = pointNum - 8 ; 
				point[pointNum].z = false ;
				point[pointNum].adj ++ ;
				if(point[pointNum].adj==8)
					JOptionPane.showMessageDialog(null,"there is no more action.player "+(flag+1)+"win");
				if(point[pointNum].adj<2)
					flag=changeturn(flag);
				else
				{
					if(flag==0){
						init_temp_point();
						action = minimax.minimax_decision(pointNum,temp_point);
						Act(action);
//						randomAct();
					}
				}
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x + 57 , cord.y - 57);
				System.out.println("Player 1 Wins.it was not player "+(flag+1)+"turn");
				JOptionPane.showMessageDialog(null,"Player 1 Wins.it was not player "+(flag+1)+"turn");
			}
		}
	}

	public void South() {
		// TODO Auto-generated method stub
		if(point[pointNum].x){
			if(pointNum !=94 ){

				System.out.println("south");
				lineComp.addLine(cord.x, cord.y, cord.x , cord.y + 57);
				cord.update(cord ,0 , 1);
				//NoPossibleAction(pointNum,point[pointNum].adj,flag );
				point[pointNum].x = false ;
				point[pointNum].adj ++ ;
				pointNum = pointNum + 9 ;
				point[pointNum].w = false ;
				point[pointNum].adj ++ ;
				if(point[pointNum].adj==8)
					JOptionPane.showMessageDialog(null,"there is no more action.player "+(flag+1)+"win");
				if(point[pointNum].adj<2)
					{flag=changeturn(flag);}
				else if(flag==0)
				{
					init_temp_point();
					action = minimax.minimax_decision(pointNum,temp_point);
					Act(action);
//						randomAct();
				}
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x , cord.y + 57);
				System.out.println("Player 2 Wins.it was not player " +(flag+1)+"turn");
				JOptionPane.showMessageDialog(null,"Player 2 Wins.it was not player "+(flag+1)+"turn");
			}
		}
	}

	public void North() {
		// TODO Auto-generated method stub
		if(point[pointNum].w){
			if(pointNum != 4){
				
				System.out.println("north");
				lineComp.addLine(cord.x, cord.y, cord.x , cord.y - 57);
				cord.update(cord ,0,-1);
				//NoPossibleAction(pointNum,point[pointNum].adj,flag );
				point[pointNum].w = false ;
				point[pointNum].adj ++ ;
				pointNum = pointNum - 9 ;
				point[pointNum].x = false ;
				point[pointNum].adj ++ ;
				if(point[pointNum].adj==8)
					JOptionPane.showMessageDialog(null,"there is no more action.player "+(flag+1)+"win");
				if(point[pointNum].adj<2)
					flag=changeturn(flag);
				else
				{
					if(flag==0){
						init_temp_point();
						action = minimax.minimax_decision(pointNum,temp_point);
						Act(action);
//						randomAct();
						}
				}
				System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			}else{
				lineComp.addLine(cord.x, cord.y, cord.x , cord.y - 57);
				System.out.println("Player 1 Wins. it was not player "+(flag+1)+"turn");
				JOptionPane.showMessageDialog(null,"Player 1 Wins.it was not player "+(flag+1)+"turn");
			}
		}		
	}

	public void West() {
		// TODO Auto-generated method stub
		if(point[pointNum].a){

			System.out.println("west");
			lineComp.addLine(cord.x, cord.y, cord.x - 57, cord.y);
			cord.update(cord,-1, 0);
			//NoPossibleAction(pointNum,point[pointNum].adj,flag );
			point[pointNum].a = false ;
			point[pointNum].adj ++ ;
			pointNum -- ;
			point[pointNum].d = false ;
			point[pointNum].adj ++ ;
			if(point[pointNum].adj==8)
				JOptionPane.showMessageDialog(null,"there is no more action.player "+(flag+1)+"win");
			if(point[pointNum].adj<2)
				flag=changeturn(flag);
			else
			{
				if(flag==0){
					init_temp_point();
					action = minimax.minimax_decision(pointNum,temp_point);
					Act(action);
//					randomAct();
				}
			}
			System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
		
		}

	}

	public void East() {
		// TODO Auto-generated method stub
		if(point[pointNum].d){
			System.out.println("east");
			lineComp.addLine(cord.x, cord.y, cord.x + 57, cord.y);
			cord.update(cord ,1,0);
			//NoPossibleAction(pointNum,point[pointNum].adj,flag );
			point[pointNum].d = false ;
			point[pointNum].adj ++ ;
			pointNum ++ ;
			point[pointNum].a = false ;
			point[pointNum].adj ++ ;
			if(point[pointNum].adj==8)
				JOptionPane.showMessageDialog(null,"there is no more action.player "+(flag+1)+"win");
			if(point[pointNum].adj<2)
				flag=changeturn(flag);
			else
			{
				if(flag==0){
					init_temp_point();
					action = minimax.minimax_decision(pointNum,temp_point);
					Act(action);
//					randomAct();
				}
			}
			System.out.println("point num : "+ pointNum+"  ["+cord.x +", "+cord.y+"]");
			
			
		}
	}
	
	private void Act(Action act) {
		// TODO Auto-generated method stub
		System.out.println(minimax.getdirection(act.state, act.successor));
		switch (minimax.getdirection(act.state, act.successor)) {
		case 'a':
			West();
			break;
		case 'z':
			SouthWest();
			break;
		case 'x':
			South();
			break;
		case 'c':
			SouthEast();
			break;
		case 'd':
			East();
			break;
		case 'e':
			NorthEast();
			break;
		case 'w':
			North();
			break;
		case 'q':
			NorthWest();
			break;	
		default:
			break;
		}
	}


	Random rand=new Random();
	
	public void randomAct()
	{
		
		int A=rand.nextInt(8);
		System.out.println("random"+A);
		if(A==0)
			North();
		if(A==1)
			West();
		else if(A==2)
			East();
		else if(A==3)
			South();
		else if(A==4)
			NorthEast();
		else if(A==5)
			NorthWest();
		else if(A==6)
			SouthEast();
		else if(A==7)
			SouthWest();
			
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}

