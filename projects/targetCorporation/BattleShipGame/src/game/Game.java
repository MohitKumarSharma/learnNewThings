package game;

import java.util.ArrayList;
import java.util.List;

import game.common.Coordinate;
import game.player.Player;
import game.util.MessageUtil;

public class Game {
	private Player attacker, attackee;
	private List<String> eventMsgList;
	
	public Game(Player _attacker, Player _attackee) {
		this.attacker = _attacker;
		this.attackee = _attackee;
		
		this.eventMsgList = new ArrayList<>();
	}
	
	public void start() {
		this.nextMove();
	}
	
	public void nextMove() {
		while(attack()) {
			if (this.attackee.getBattleShipContainer().isDestroyed()) {
				this.declaredResult(this.attacker);
				
				return;
			}
		}
		
		if (this.isGameOver()) {
			this.declaredResult(null);
		
			return;
		}
		
		// Swap the attacker and attackee
		Player temp = this.attacker;
		this.attacker = this.attackee;
		this.attackee = temp;
		
		this.nextMove();
	}
	
	public void declaredResult(Player _player) {
		if (_player == null) {
			this.eventMsgList.add("Game ends in draw and peace is declared");
		} else {
			this.eventMsgList.add(MessageUtil.constructWinningMessage(_player.getPlayerName()));
		}
		
		for(String message: eventMsgList) {
			System.out.println(message);
		}
	}
	
	public boolean isGameOver() {
		if (this.attacker.isMissileFinished() && this.attackee.isMissileFinished()) {
			return true;
		}
		
		return false;
	}
	
	public boolean attack() {
		if (this.attacker.isMissileFinished()) {
			this.eventMsgList.add(MessageUtil.constructNoMissileMsg(this.attacker.getPlayerName()));
			
			return false;
		}
		
		Coordinate coords = this.attacker.attack();
		
		boolean isHit = this.attackee.handleAttack(coords);
		
		this.eventMsgList.add(MessageUtil.constructHitOrMissMSG(this.attacker.getPlayerName(), coords, isHit));
		
		return isHit;
	}
	
}
