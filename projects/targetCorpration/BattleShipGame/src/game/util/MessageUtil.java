package game.util;

import game.common.Coordinate;

public class MessageUtil {

	public static String constructHitOrMissMSG(String _playerName, Coordinate _coords, boolean isHit) {
		return _playerName  + " fires a missile with target " + _coords +  " which " + (isHit ? "hit": "missed");
	}
	
	public static String constructWinningMessage(String _playerName) {
		return _playerName + " won the battle";
	}
	
	public static String constructNoMissileMsg(String _playerName) {
		return _playerName + " has no more missiles left";
	}
	
}
