import processing.core.PApplet;
import processing.event.KeyEvent;

public class StartWorld implements IWorld {

	
	
	@Override
	public PApplet draw(PApplet c) {
		c.background(255);
		c.fill(0);
		c.text("Press space to start", 350, 350);
		return c;
	}

	@Override
	public IWorld update() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == ' ') {
			return PlayWorld.buildStandard();
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
