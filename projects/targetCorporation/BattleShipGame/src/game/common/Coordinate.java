package game.common;

public class Coordinate {
	private int x;
	private int y;
	
	//  TODO may have anotther consturctr.
	public Coordinate(char _x, char _y) {
		this.x = (int)(_x - 48);
		this.y = (int)(_y - 64);
	}
	
	public Coordinate(String _coordStr) {
		this(_coordStr.charAt(1), _coordStr.charAt(0));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public char getYInChar() {
		return (char)(y + 64);
	}

	@Override
	public String toString() {
		return String.valueOf((char)(y + 64)) + String.valueOf(x);
				//"Coordinate [_x=" + x + ", _y=" + y + "]";
	}
	
	
	
}
