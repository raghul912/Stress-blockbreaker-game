package mygame;
import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		JFrame a =new JFrame();
		Gameplay b =new Gameplay();
		a.setBounds(10, 10, 700, 600);
		a.setTitle("Raghul's Capstone game");
		a.setResizable(false);
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.add(b);

	}

}
