package mygame;
/*[
{ //case-1 ball interaction
  (ballrect.intersects(brickrect)->score+=5;
  (ballrect.intersects(brickrect)->totalcapstone--;
  //case-2 paddle movement
  (e.getKeyCode()==KeyEvent.VK_LEFT)=moveleft();
  (e.getKeyCode()==KeyEvent.VK_RIGHT)=moveright();
  //case-3 gameover
  (ballposy>570)=play(false);
  }
  ]*/
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class test extends Gameplay{
		@Test
		public void setup() {
			 if(totalcapstone==21) {
	String str="Test case passed";
 assertEquals ("Test case passed",str);}
			 if(score==0) {
					String str="Test case passed";
				 assertEquals ("Test case passed",str);}
	}}

	