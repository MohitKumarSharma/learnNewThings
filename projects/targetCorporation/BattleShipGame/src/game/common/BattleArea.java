package game.common;

import game.ship.BattleShip;

public class BattleArea {
	private int width;
	private int height;
	
	public BattleArea(int _width, int _height) {
		this.width = _width;
		this.height = _height;
	}
	
	public boolean isValid() {
		if (1 > this.width || this.width > 9) {
			return false;
		}
		
		if (1 > this.height || this.height > 26) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidBattleShip(BattleShip _battleShip) {
		if (!this.isValidXCords(_battleShip.getX() + _battleShip.getWidth() - 1)) {
			return false;
		}
		
		if (!this.isValidYCords(_battleShip.getY() + _battleShip.getHeight() - 1)) {
			return false;
		}
		
		if (!this.isValidXCords(_battleShip.getX())) {
			return false;
		}
		
		if (!this.isValidYCords(_battleShip.getY())) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidXCords(int _x) {
		if ( 1 > _x || _x > this.width) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidYCords(int _y) {
		if ( 1 > _y || _y > this.height) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidCords(Coordinate _coords) {
		if (!this.isValidXCords(_coords.getX())) {
			return false;
		}
		
		return this.isValidYCords(_coords.getY());
	}

	@Override
	public String toString() {
		return "BattleArea [width=" + width + ", height=" + height + "]";
	}
	
	
}
