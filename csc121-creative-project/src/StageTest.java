import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class StageTest {
	
	Platform p1 = new Platform(new Posn(200, 200), 100, 20, Color.red, new int[] { 1 });
	Platform p2 = new Platform(new Posn(300, 250), 100, 20, Color.red, new int[] { 2 });
	Platform p3 = new Platform(new Posn(250, 150), 100, 20, Color.red, new int[] { 0 });
	Stage stage = new Stage(Color.blue, new Platform[] { p1, p2, p3}, -1);
	
	/*
	   stage should contain livePlatforms : 
	      [
	      	new Platform("A", new Posn(200, 200), 100, 20, Color.red, new String[] { "B" }),
	      	new Platform("B", new Posn(500, 250), 100, 20, Color.red, new String[] { "C" }),
	      	new Platform("C", new Posn(750, 150), 100, 20, Color.red, new String[] { "A" })
	      	new Platform("A", new Posn(950, 200), 100, 20, Color.red, new String[] { "B" })
	      ]
	 */
	
	// create check off scren adn check on screen for first and last things 
	

	@Test
	void test() {
		assertEquals("blah", stage.toString());
	}

}
