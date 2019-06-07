package game.ship;

import java.util.Arrays;

import game.common.Coordinate;

public abstract class BattleShip {
	private int width;
	private int height;
	private Coordinate coords;
	
	protected int [][]cells;
	private int cellsValue;
	
	public BattleShip(int _width, int _height, Coordinate _coords) {
		this.width = _width;
		this.height = _height;
		this.coords = _coords;
		
		cells = new int[this.height][this.width];
	}
	
	protected void initCells(int _cellValue) {
		for (int i = 0; i < this.getHeight(); i++) {
			for (int j = 0; j < this.getWidth(); j++) {
				this.cells[i][j] = _cellValue;
			}
		}
		
		cellsValue = _cellValue*this.height*this.width;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Coordinate getCoords() {
		return this.coords;
	}
	
	public int getX() {
		return this.coords.getX();
	}

	public int getY() {
		return this.coords.getY();
	}
	
	public boolean isDestroyed() {
		if (this.cellsValue == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean handleAttack(Coordinate _cords) {
		int tempX = _cords.getX() - this.coords.getX();
		int tempY = _cords.getY() - this.coords.getY();
		
		if ( 0 > tempX || tempX >= this.width) {
			return false;
		}
		
		if ( 0 > tempY|| tempY >= this.height) {
			return false;
		}
		
		if (cells[tempY][tempX] <= 0) {
			// Cell is already destroyed.
			return false;
		}
		
		cells[tempY][tempX] -= 1; // reducing the value after hit
		cellsValue--;
		
		return true;
		
	}

	@Override
	public String toString() {
		return "BattleShip [width=" + width + ", height=" + height + ", coords=" + coords + ", cells="
				+ Arrays.toString(cells) + "]";
	}
	
	
	
}
