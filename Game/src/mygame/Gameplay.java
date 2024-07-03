package mygame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener,ActionListener {

	private boolean play =false;
	protected static int score=0;
	protected static int totalcapstone=21;
	private Timer timer;
	private int delay=8;
	private int playera=310;
	private int ballposx=120;
	private int ballposy=350;
	public int ballxdir=-2;
	public int ballydir=-3;
	private capstone map ;
	public int a=1;	 

	public Gameplay() {
		map=new capstone(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	timer = new Timer(delay,this);
		timer.start();
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 692, 592); //background
		map.draw((Graphics2D)g);//draw map
		g.setColor(Color.yellow);//border
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString("POINTS:"+score, 15, 30);
		g.setColor(Color.RED);//paddle
		g.fillRect(playera, 550, 100, 8);
		g.setColor(Color.red);//ball
		g.fillOval(ballposx, ballposy, 20, 20);
		g.setColor(Color.yellow);//ball
		g.setFont(new Font("serif",Font.CENTER_BASELINE,23));
		g.drawString("⚽", ballposx, ballposy+18);
		if(totalcapstone <=0) {
			if(a==1) {
			play=false;
			ballxdir=0;
			ballydir=0;
			g.setColor(Color.GREEN);
			g.setFont(new Font("serif",Font.BOLD,35));
			g.drawString("you won", 260, 300);
			g.setFont(new Font("serif",Font.BOLD,35));
			g.drawString("Press 2 For Level 2", 180, 350);
			}
			if(a==2) { 
				play=false;
				ballxdir=0;
				ballydir=0;
				g.setColor(Color.GREEN);
				g.setFont(new Font("serif",Font.BOLD,35));
				g.drawString("you won", 260, 300);
				g.setFont(new Font("serif",Font.BOLD,35));
				g.drawString("Press 3 For Level 3", 180, 350);
			}
			if(a==3) { 
				play=false;
				ballxdir=0;
				ballydir=0;
				g.setColor(Color.GREEN);
				g.setFont(new Font("serif",Font.BOLD,35));
				g.drawString("you won", 260, 300);
				g.setFont(new Font("serif",Font.BOLD,35));
				g.drawString("Press 4 For Level 4", 180, 350);
			}
			if(a==4) { 
				play=false;
				ballxdir=0;
				ballydir=0;
			g.setFont(new Font("serif",Font.BOLD,35));
			g.setColor(Color.GREEN);
			g.drawString("You Completed the Game", 170, 300);
			g.drawString("Congratulation", 230, 350);
			g.setFont(new Font("serif",Font.BOLD,20));
			g.drawString("🎉 Please take some rest 🎉",230, 380);
			}
		}
		if(ballposy>570) {
			 
			play=false;
			ballxdir=0;
			ballydir=0;
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,35));
			g.drawString("😭Gameover Scores:"+score, 180, 300);
			g.setFont(new Font("serif",Font.BOLD,20));
			g.drawString("Press spacebar to restart", 240, 350);
			
		}
		g.dispose();
	}
   
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			if(new Rectangle(ballposx,ballposy,20,20).intersects(new Rectangle(playera,550,100,8))) {
				ballydir=-ballydir; //Interact ball and paddle
			}
			A:for(int i=0;i<map.map.length;i++) {
				for(int j=0;j<map.map[0].length;j++) {
					if(map.map[i][j]>0) {
						int x=j*map.width+80;
						int y=i*map.height+50;
						int width=map.width;
						int height=map.height;
						
						Rectangle rect= new Rectangle(x,y,width,height);
						Rectangle ballrect =new Rectangle(ballposx,ballposy,20,20);
						Rectangle brickrect=rect;
						if(ballrect.intersects(brickrect)) {
							map.setValue(0, i, j);
							totalcapstone--;
							score +=5;
							if(ballposx+19<= brickrect.x||ballposx+1>=brickrect.x+brickrect.width) {
								ballxdir=-ballxdir;
							}else {
								ballydir=-ballydir;
							}
							break A;
						}
						
						
					}
				}
			}
			ballposx+=ballxdir;
			ballposy+=ballydir;
			if(ballposx<0) {
				ballxdir= -ballxdir;
				
			}
			if(ballposy<0) {
				ballydir= -ballydir;
				
			}
			if(ballposx>670) {
				ballxdir= -ballxdir;
				
			}
		}
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(playera<10) {
				playera=10;
			}else {
				moveleft();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(playera>=600) { //condition for the paddle to not go out of frame
				playera=600;
			}else {
				moveright();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_2) {
			if(!play) {
				ballposx=120;
				ballposy=350;
				ballxdir=-3;
				ballydir=-4;
				playera=310;
				totalcapstone=21;
				map=new capstone(3,7);
				repaint();
				a++;
				
				
				
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_3) {
			if(!play) {
				ballposx=120;
				ballposy=350;
				ballxdir=-4;
				ballydir=-5;
				playera=310;
				totalcapstone=21;
				map=new capstone(3,7);
				repaint();
				a++;
				
				
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_4) {
			if(!play) {
				ballposx=120;
				ballposy=350;
				ballxdir=-5;
				ballydir=-4;
				playera=310;
				totalcapstone=21;
				map=new capstone(3,7);
				repaint();
				a++;
				
				
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(!play) {
				ballposx=120;
				ballposy=350;
				ballxdir=-2;
				ballydir=-3;
				score=0;
				playera=310;
				totalcapstone=21;
				map=new capstone(3,7);
				repaint();
				a=1;
				
				
			}
		}
		
	}
	public void moveright() {
		play=true;
		playera+=20;
	
	}
	public void moveleft() {
		play=true;
		playera-=20;
	
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
