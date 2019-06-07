package game.ship;

import game.common.Coordinate;

public class BattleShipTypeQ extends BattleShip{
	public BattleShipTypeQ(int _width, int _height, Coordinate _coords) {
		super(_width, _height, _coords);
		
		this.initCells(2);
	}
}
