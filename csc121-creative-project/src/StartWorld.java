import processing.core.PApplet;
import processing.event.KeyEvent;

public class StartWorld implements IWorld {

	
	
	@Override
	public PApplet draw(PApplet c) {
		c.background(0, 150, 200);
		c.fill(0, 255, 0);
		c.textSize(60);
		c.text("DoodleJumper", 230, 310);
		c.fill(0);
		c.textSize(30);
		c.text("Press space to start", 290, 400);
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
