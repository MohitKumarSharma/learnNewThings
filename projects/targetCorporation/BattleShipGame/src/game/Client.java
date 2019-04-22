package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

import game.common.BattleArea;
import game.common.Coordinate;
import game.customException.InvalidArgumentException;
import game.player.Player;
import game.ship.BattleShip;
import game.ship.BattleShipTypeP;
import game.ship.BattleShipTypeQ;
import game.ship.BattleShipContainer;

/**
 * This class parse the input file for a game. create entity after parsing the input.
 * And starts the game.
 * 
 * I have created sample input file parallel to project with name BattleGameInput.txt. You may check.
 * 
 * @author Mohit K
 *
 */
public class Client {
	static BattleArea battleArea;
	
	public static void main(String[] args)   {
		//File inputFile = new File("G:\\thoughtWorks\\BattleGameInput.txt");
		
		if (args.length < 1) {
			System.out.println("Enter Battle game input file path");
			
			return;
		} 
		
		File battleInputFile = new File(args[0]);
		
		parseInputFile(battleInputFile);
	}
	
	/**
	 * Parse the input file line by line and create entity corresponding to them.
	 * 
	 * I have validated the inputs as per constraint, may be that would be over-doing.
	 * 
	 * @param _file
	 */
	public static void parseInputFile(File _file) {
		try (BufferedReader br = new BufferedReader(new FileReader(_file))){
			
			battleArea = parseBattleAreaLine(br.readLine());
			
			int numberOfShips = Integer.parseInt(br.readLine());
			
			BattleShipContainer battleShipContainer1 = new BattleShipContainer();
			BattleShipContainer battleShipContainer2 =  new BattleShipContainer();
			
			// Parse battle ship and add them into respective list.
			for (int i = 0; i < numberOfShips; i++) {
				parseBattleShipLine(br.readLine(), battleShipContainer1, battleShipContainer2);
			}
			
			// Parse the target points for respective player.
			Queue<Coordinate> tLocations1 = parseTargetLocations(br.readLine());
			Queue<Coordinate> tLocations2 = parseTargetLocations(br.readLine());
			
			// Create the player
			Player player1 = new Player("Player-1", battleShipContainer1, tLocations1);
			Player player2 = new Player("Player-2", battleShipContainer2, tLocations2);
			
			// Start the game.
			Game game = new Game(player1, player2);
			game.start();
			
		} catch (Exception e) {
			System.out.println("Exception Caught: ");
			
			e.printStackTrace();
			
			return;
		} 
	
	}
	
	public static BattleArea parseBattleAreaLine(String _bAreaLine) {
		String[] battleDim = _bAreaLine.split(" ");
		
		int width = Integer.parseInt(battleDim[0]);
		int height = battleDim[1].charAt(0) - 64;
		
		battleArea = new BattleArea(width, height);
		
		return battleArea;
	}
	
	public static void parseBattleShipLine(String _bShipLine, BattleShipContainer _ships1, BattleShipContainer _ships2) throws Exception {
		String[] parts = _bShipLine.split(" ");
		String type = parts[0];
		
		int width = Integer.parseInt(parts[1]);
		int height = Integer.parseInt(parts[2]);
		
		Coordinate coords1 = new Coordinate(parts[3]);
		Coordinate coords2 = new Coordinate(parts[4]);
		
		BattleShip ship1, ship2;
		
		if (type.equals("P")) {
			ship1 = new BattleShipTypeP(width, height, coords1);
			ship2 = new BattleShipTypeP(width, height, coords2);
		} else if (type.equals("Q")){
			ship1 = new BattleShipTypeQ(width, height, coords1);
			ship2 = new BattleShipTypeQ(width, height, coords2);
		} else {
			throw new InvalidArgumentException(type + " This type of battle ship is not supported ");
		}
		
		if (!battleArea.isValidBattleShip(ship1)) {
			throw new InvalidArgumentException("Battle ship coords not valid " + ship1);
		}
		
		if (!battleArea.isValidBattleShip(ship2)) {
			throw new InvalidArgumentException("Battle ship coords not valid " + ship2);
		}
		
		_ships1.addBattleShip(ship1);
		_ships2.addBattleShip(ship2);
		
	}
	
	public static Queue<Coordinate> parseTargetLocations(String _tLocations) throws Exception {
		Queue<Coordinate> targetLocations = new LinkedList<Coordinate>();
		Coordinate coords;
		
		String[] locations = _tLocations.split(" ");
		
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
}
