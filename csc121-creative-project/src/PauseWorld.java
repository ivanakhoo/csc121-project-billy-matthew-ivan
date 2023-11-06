import processing.core.PApplet;
import processing.event.KeyEvent;

public class PauseWorld implements IWorld {

	private PlayWorld paused;
	
	public PauseWorld(PlayWorld paused) {
		this.paused = paused;
	}

	@Override
	public PApplet draw(PApplet c) {
		c.background(0, 100, 200);
		
		// this.paused.draw(c);
		
		c.fill(0);
		c.textSize(30);
		c.text("Game Paused", 320, 400);
		c.textSize(20);
		c.text("Press Spacebar To Resume", 290, 450);
		c.text("Press R To Restart", 300, 475);
		c.text("Press Q To Return Home", 300, 500);
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
			return paused;
			//return PlayWorld.buildLevel1(); // need to find a way to pause game and reenter.
		} else if (kev.getKey() == 'r') {
			return PlayWorld.buildLevel1(); // this needs to return the same level we were on
		} else if (kev.getKey() == 'q') {
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
