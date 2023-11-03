import processing.core.PApplet;
import processing.event.KeyEvent;

public class GameOverWorld implements IWorld {

	@Override
	public PApplet draw(PApplet c) {
		c.background(0);
		c.fill(255, 0, 0);
		c.textSize(30);
		c.text("Game Over :(", 320, 400);
		c.textSize(20);
		c.text("Press Spacebar To Play Again", 290, 450);
		c.text("Press R To Return Home", 300, 500);
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
			return PlayWorld.buildLevel1();
		} else if (kev.getKey() == 'r') {
			return new StartWorld(); 
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
