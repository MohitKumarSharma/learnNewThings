package game.ship;

import java.util.ArrayList;
import java.util.List;

import game.common.Coordinate;

/**
 * It holds list of battle ship.
 * 
 * @author Mohit K
 *
 */
public class BattleShipContainer {
	List<BattleShip> battleShips;
	
	public BattleShipContainer() {
		this.battleShips = new ArrayList<BattleShip>();
	}
	
	public void addBattleShip(BattleShip _ship) {
		this.battleShips.add(_ship);
	}
	
	public boolean isHit(Coordinate _cords) {
		for (BattleShip ship: this.battleShips) {
			if (ship.handleAttack(_cords)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isDestroyed() {
		for (BattleShip ship: this.battleShips) {
			if (!ship.isDestroyed()) {
				return false;
			}
		}
		
		return true;
	}
}
