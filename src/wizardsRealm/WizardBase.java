package wizardsRealm;

public abstract class WizardBase implements Wizard {
	protected float x, y, vx, vy;
	protected int width, height, health;
	// Add customization variables here
	
	public WizardBase(float x, float y){
		this.x = x;
		this.y = y;
		width = 60;
		height = 120;
	}

	@Override
	public void damage(int amount) {
		health-=amount;
	}

	@Override
	public boolean isDead() {
		return health <= 0;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	
	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean topIntersect(int[][] blocks) {
		return (vy < 0 && (blocks[(int)x/15][(int)y/15] > 0 || blocks[(int)x/15+1][(int)y/15] > 0 || 
				blocks[(int)x/15+2][(int)y/15] > 0 || blocks[(int)x/15+3][(int)y/15] > 0));
	}

	@Override
	public boolean bottomIntersect(int[][] blocks) {
		return (vy >= 0 && (blocks[(int)x/15][(int)y/15+height/15] > 0 || blocks[(int)x/15+1][(int)y/15+height/15] > 0 || 
				blocks[(int)x/15+2][(int)y/15+height/15] > 0 || blocks[(int)x/15+3][(int)y/15+height/15] > 0));
	}

	@Override
	public boolean rightIntersect(int[][] blocks) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leftIntersect(int[][] blocks) {
		// TODO Auto-generated method stub
		return false;
	}

}
