package mygame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class capstone {

		public int map[][];
		public int width;
		public int height;
		public int widtha;
		public int heighta;
		public capstone(int row,int col) {
			map =new int[row][col];
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[0].length;j++) {
					map[i][j]=1;
				}
			}
		width=540/col;
		height=150/row;
		widtha=540/col;
		heighta=150/row;
		}
		public void draw(Graphics2D g) {
			g.setFont(new Font("serif",Font.CENTER_BASELINE,90));
			g.setColor(Color.GREEN);
			g.drawString("Happiness😀", 100, 150);
			g.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,12));
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[0].length;j++) {
				if(map[i][j]>0) {
					g.setColor(Color.orange);
					g.fillRect(j*width+80,i*height+50, width, height);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(j*width+80,i*height+50, width, height);
				g.setColor(Color.white);
				g.drawString("Developed By Raghul",500,500);
				}
				
				}
			}
			
			for(int i=0;i<map.length;i++) {

				
				for(int j=0;j<map[0].length;j++) {
				if(map[i][j]>0) {
					g.setColor(Color.black);
					g.setFont(new Font("serif",Font.CENTER_BASELINE,12));
					g.drawString("STRESS",j*widtha+95,i*heighta+80);
				}
				
				}
			}
		
	
		

	}
		public void setValue(int value,int row,int col) {
			map[row][col]=value;
		}

}
