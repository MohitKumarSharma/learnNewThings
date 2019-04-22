package game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import game.common.BattleArea;
import game.common.Coordinate;
import game.customException.InvalidArgumentException;
import game.player.Player;
import game.ship.BattleShip;
import game.ship.BattleShipContainer;
import game.ship.BattleShipTypeP;
import game.ship.BattleShipTypeQ;

public class Client1 {
	private static Scanner sc;
	private static BattleArea battleArea;
	
	public static void main(String[] args) throws InvalidArgumentException {
		sc = new Scanner(System.in);
		
		battleArea = takeBattleAreaInput();
		
		System.out.println("Enter number of battle ship for players");
		
		int numberOfBattleShip = Integer.parseInt(sc.nextLine());
		
		BattleShipContainer battleShipContainer1 = new BattleShipContainer();
		BattleShipContainer battleShipContainer2 = new BattleShipContainer();
		
		takeBattleShipInput(numberOfBattleShip, battleShipContainer1, battleShipContainer2);
		
		Queue<Coordinate> targetLocations1 = takeTargetLocations("player 1");
		Queue<Coordinate> targetLocations2 = takeTargetLocations("player 2");
		
		Player player1 = new Player("player 1", battleShipContainer1, targetLocations1);
		Player player2 = new Player("player 2", battleShipContainer2, targetLocations2);
		
		Game game = new Game(player1, player2);
		
		game.start();
	}
	
	public static void takeBattleShipInput(int _numberOfBattleShip, BattleShipContainer _container1, BattleShipContainer _container2) throws InvalidArgumentException {
		String type;
		int width, height;
		Coordinate coordinate1, coordinate2;
		BattleShip ship1, ship2;
		
		for (int i = 0; i < _numberOfBattleShip; i++) {
			System.out.println("Enter type of battle ships");
			
			type = sc.nextLine();
			
			System.out.println("Dimenstion of ship");
			
			String dimStr = sc.nextLine();
			String dim[] = dimStr.split(" ");
			
			width = Integer.parseInt(dim[0]);
			height = Integer.parseInt(dim[1]);
			
			System.out.println("Location of battle ship " + (i + 1) + " for player 1:");
			coordinate1 = new Coordinate(sc.nextLine());
			
			System.out.println("Location of battle ship " + (i + 1) + " for player 2:");
			coordinate2 = new Coordinate(sc.nextLine());
			
			if (type.equals("P")) {
				ship1 = new BattleShipTypeP(width, height, coordinate1);
				ship2 = new BattleShipTypeP(width, height, coordinate2);
			} else if (type.equals("Q")){
				ship1 = new BattleShipTypeQ(width, height, coordinate1);
				ship2 = new BattleShipTypeQ(width, height, coordinate2);
			} else {
				throw new InvalidArgumentException(type + " type ship is not supported");
			}
			
			if (!battleArea.isValidBattleShip(ship1)) {
				throw new InvalidArgumentException(ship1 + " is not valid");
			}
			
			if (!battleArea.isValidBattleShip(ship2)) {
				throw new InvalidArgumentException(ship2 + " is not valid");
			}
			
			_container1.addBattleShip(ship1);
			_container2.addBattleShip(ship2);
		}
		
	}
	
	public static Queue<Coordinate> takeTargetLocations(String _playerName) throws InvalidArgumentException {
		System.out.println("Misslie target for " + _playerName);
		
		String missilesLine = sc.nextLine();
		
		Queue<Coordinate> targetLocations = new LinkedList<Coordinate>();
		Coordinate coords;
		
		String[] locations = missilesLine.split(" ");
		
		for (String location: locations) {
			if (location.isEmpty()) {
				continue;
			}
			
			coords = new Coordinate(location);
			
			if (!battleArea.isValidCords(coords)) {
				throw new InvalidArgumentException("Not valid coordinates " + coords);
			}
			targetLocations.add(coords);
		}
		
		return targetLocations;
	}
	
	public static BattleArea takeBattleAreaInput() {
		System.out.println("Enter area boundary");
		
		String areaLine = sc.nextLine();
		
		String[] battleDim = areaLine.split(" ");
		
		int width = Integer.parseInt(battleDim[0]);
		int height = battleDim[1].charAt(0) - 64;
		
		return new BattleArea(width, height);
	}
}
