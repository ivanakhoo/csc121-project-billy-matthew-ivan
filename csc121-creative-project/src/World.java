import processing.core.PApplet;

/** Matthew Peterson, Billy Blood, and Ivan Khoo
 * Represents the World and the objects in it*/
public class World {
	DoodleJumper dj;
	Platform p;
//	Background background; // unsure if we need background yet if our background is a solid color
	
	
	public World(DoodleJumper dj, Platform p) {
//		super();
		this.dj = dj;
		this.p = p;
	}	
	
	public PApplet draw(PApplet c, DoodleJumper dj, Platform p) {
        c.background(255);
//        c.text("NoodleHump!", 20, 20);
//        c.fill(135, 135, 0);
//        c.circle(100, 100, 15);
//        p.draw(c);
        dj.draw(c);
        p.draw(c);
        return c;
    }

//	public World update() {
//		return new World(this.dj.update(), this.p);
//	}

	
	
}



