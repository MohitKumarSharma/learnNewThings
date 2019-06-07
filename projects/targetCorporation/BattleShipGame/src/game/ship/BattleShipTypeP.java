package game.ship;

import game.common.Coordinate;

public class BattleShipTypeP extends BattleShip {
	
	public BattleShipTypeP(int _width, int _height, Coordinate _coords) {
		super(_width, _height, _coords);
		
		this.initCells(1);
	}
	
}
