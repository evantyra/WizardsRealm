package wizardsRealm;

public interface Block {
	public void draw(int x, int y, int durability, boolean above, boolean below, boolean left, boolean right);
	public boolean destroy(int health);
	public boolean blockLeft(int[][] blocks, int i, int j);
	public boolean blockRight(int[][] blocks, int i, int j);
	public boolean blockAbove(int[][] blocks, int i, int j);
	public boolean blockBelow(int[][] blocks, int i, int j);
}
