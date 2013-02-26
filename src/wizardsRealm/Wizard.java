package wizardsRealm;

public interface Wizard {
	public void draw();
	public void update(int delta);
	public void damage(int amount);
	public boolean isDead();
	public float getX();
	public float getY();
	public void setX(float x);
	public void setY(float y);
	public int getWidth();
	public int getHeight();
	public boolean topIntersect(int[][] blocks);
	public boolean bottomIntersect(int[][] blocks);
	public boolean rightIntersect(int[][] blocks);
	public boolean leftIntersect(int[][] blocks);
}
