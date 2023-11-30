import processing.core.PApplet;
import processing.event.KeyEvent;

public class StartWorld implements IWorld {

	
	
	@Override
	public PApplet draw(PApplet c) {
		c.background(0, 150, 200);
		c.fill(0, 255, 0);
		c.textSize(60);
		c.text("DoodleJumper", 220, 310);
		c.fill(0);
		c.textSize(20);
		c.text("Press 1 for Easy Mode", 295, 400);
		c.text("Press 2 for Medium Mode", 280, 450);
		c.text("Press 3 for Difficult Mode", 280, 500);
		return c;
	}

	@Override
	public IWorld update() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == '1') {
			String name1 = javax.swing.JOptionPane.showInputDialog("Please enter your name"); 
			return PlayWorld.buildLevel(1, name1);
		} else if (kev.getKey() == '2' ) {
			String name2 = javax.swing.JOptionPane.showInputDialog("Please enter your name");
			return PlayWorld.buildLevel(2, name2);
		} else if (kev.getKey() == '3' ) {
			String name3 = javax.swing.JOptionPane.showInputDialog("Please enter your name");
			return PlayWorld.buildLevel(3, name3);
		} else {
			return this;
		}
	}

	@Override
	public IWorld keyReleased(KeyEvent kev) {
		// TODO Auto-generated method stub
		return this;
	}

}
