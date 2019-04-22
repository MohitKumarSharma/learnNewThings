package game.player;

import java.util.Queue;

import game.common.Coordinate;
import game.ship.BattleShipContainer;

public class Player {
	private String playerName;
	private BattleShipContainer battleShipContainer;
	private Queue<Coordinate> targetLocations;
	private boolean isMissileFinished;
	
	public Player(String _playerName, BattleShipContainer _battleShipContainer, Queue<Coordinate> _targetLocations) {
		this.playerName = _playerName;
		this.battleShipContainer = _battleShipContainer;
		this.targetLocations = _targetLocations;
	}
	
	public Coordinate attack() {
		Coordinate coords = this.targetLocations.poll();
		
		if ((this.targetLocations.size() == 0) || coords == null) {
			this.isMissileFinished = true;
		}
		
		return coords;
	}

	public boolean handleAttack(Coordinate _coords) {
		if (_coords == null) {
			return false;
		}
		
		return this.battleShipContainer.isHit(_coords);
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public BattleShipContainer getBattleShipContainer() {
		return battleShipContainer;
	}

	public Queue<Coordinate> getTargetLocations() {
		return targetLocations;
	}

	public boolean isMissileFinished() {
		return isMissileFinished;
	}
	
}
