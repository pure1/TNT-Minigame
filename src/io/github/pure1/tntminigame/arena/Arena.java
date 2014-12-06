package io.github.pure1.tntminigame.arena;

import java.util.ArrayList;
import java.util.Map;

import org.bukkit.entity.Player;

import com.sk89q.worldedit.Location;

public class Arena {

	private String name;
	private Location loc1, loc2;
	private Boolean pRandom, eRandom, walls;
	private Map<String, Object> eLoc, pLoc;
	private boolean running;
	/**
	 * @param arena - the arena name
	 * @param loc1 - the first corner
	 * @param loc2 - the second corner
	 * @param playerRandom - are the players randomly spawned?
	 * @param playerLocations - locations to spawn players.
	 * @param entityRandom - are the entities randomly spawned?
	 * @param entityLocation - locations to spawn entities.
	 * @param walls - trap players with virtual walls.
	 */
	public Arena(String arena, Location loc1, Location loc2, boolean playerRandom, Map<String, Object> playerLocations,
			boolean entityRandom, Map<String, Object> entityLocations, boolean walls) {
		setName(arena);
		setLoc1(loc1);
		setLoc2(loc2);
		setpRandom(playerRandom);
		setpLoc(playerLocations);
		seteRandom(entityRandom);
		seteLoc(entityLocations);
		setWalls(walls);
		setRunning(false);
	}
	
	public void start(ArrayList<Player> players){
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
	 * @return the pRandom
	 */
	public Boolean getpRandom() {
		return pRandom;
	}
	/**
	 * @param pRandom the pRandom to set
	 */
	public void setpRandom(Boolean pRandom) {
		this.pRandom = pRandom;
	}
	/**
	 * @return the eRandom
	 */
	public Boolean geteRandom() {
		return eRandom;
	}
	/**
	 * @param eRandom the eRandom to set
	 */
	public void seteRandom(Boolean eRandom) {
		this.eRandom = eRandom;
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
	 * @return the eLoc
	 */
	public Map<String, Object> geteLoc() {
		return eLoc;
	}
	/**
	 * @param eLoc the eLoc to set
	 */
	public void seteLoc(Map<String, Object> eLoc) {
		this.eLoc = eLoc;
	}
	/**
	 * @return the pLoc
	 */
	public Map<String, Object> getpLoc() {
		return pLoc;
	}
	/**
	 * @param pLoc the pLoc to set
	 */
	public void setpLoc(Map<String, Object> pLoc) {
		this.pLoc = pLoc;
	}
	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}
	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

}
