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
			String name = javax.swing.JOptionPane.showInputDialog("Please enter your name"); 
			return PlayWorld.buildLevel(1, name);
		} else if (kev.getKey() == '2' ) {
			return PlayWorld.buildLevel2();
		} else if (kev.getKey() == '3' ) {
			return PlayWorld.buildLevel3();
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
