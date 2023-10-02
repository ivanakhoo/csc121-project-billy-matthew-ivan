/** Represents a Stage of the game through generating a list of platforms*/
import processing.core.PApplet;

public interface Stage {

}

class MTLoP implements Stage {
	
}

//to represent a book added to a list of books
class ConsLoP implements Stage {
	Platform plat;
	Stage rest;
	
	public ConsLoP(Platform plat, Stage rest) {
		this.plat = plat;
		this.rest = rest;
	}
}
