package io.github.pure1.tntminigame.lobby;

import java.util.ArrayList;
import java.util.Map;

import org.bukkit.entity.Player;

import com.sk89q.worldedit.Location;

public class lobby {

	private String name;
	private Location loc1, loc2;
	private Boolean walls;
	private ArrayList<Player> Players;
	
	public lobby(){
		//TODO
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the loc1
	 */
	public Location getLoc1() {
		return loc1;
	}

	/**
	 * @param loc1 the loc1 to set
	 */
	public void setLoc1(Location loc1) {
		this.loc1 = loc1;
	}

	/**
	 * @return the loc2
	 */
	public Location getLoc2() {
		return loc2;
	}

	/**
	 * @param loc2 the loc2 to set
	 */
	public void setLoc2(Location loc2) {
		this.loc2 = loc2;
	}

	/**
	 * @return the walls
	 */
	public Boolean getWalls() {
		return walls;
	}

	/**
	 * @param walls the walls to set
	 */
	public void setWalls(Boolean walls) {
		this.walls = walls;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return Players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		Players = players;
	}
}
