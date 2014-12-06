package io.github.pure1.tntminigame.arena;

import io.github.pure1.plugin.utils.ConfigAccessor;
import io.github.pure1.tntminigame.TntMinigame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.Location;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.sk89q.worldedit.regions.Region;

public class ArenaHandler {

	private static HashMap<String, Arena> arenas;
	
	private static ConfigAccessor arenaConfig;
	private static TntMinigame tnt;
	/*
	 * Arena:
	 *		World: "World"
	 * 		Coords:
	 *   		x1: -11
	 *   		y1: -22
	 *   		z1: -33
	 *  		 x2: 11
	 *  		 y2: 22
	 *  		 z2: 33
	 *  	pRandom: true
	 * 		eRandom: true
	 * 		pLoc:
	 * 		eLoc:
	 * 		walls: true
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	/**
	 * Initialise ArenaHandler and load
	 * @param tnt
	 */
	public ArenaHandler(TntMinigame tnt){
		setTnt(tnt);
		setArenaConfig(TntMinigame.arena);
		setArenas(new HashMap<String, Arena>());
		loadArenas();
	}

	/**
	 * Loads all Arena Configs in the resource folder.
	 */
	private void loadArenas() {
		int a = Integer.parseInt(TntMinigame.config.getString("arenas"));
		ArrayList<String> nms = (ArrayList<String>) arenaConfig.getStringList("arenas");
		for(int i = 0; i < a; i++){
			Location loc1 = new Location((LocalWorld) Bukkit.getServer().getWorld(arenaConfig.getString(nms.get(i) + ".world")), 
					new Vector(arenaConfig.getInt(nms.get(i) + "location.x1"), 
							arenaConfig.getInt(nms.get(i) + "location.y1"),
							arenaConfig.getInt(nms.get(i) + "location.z1")));
			Location loc2 = new Location((LocalWorld) Bukkit.getServer().getWorld(arenaConfig.getString(nms.get(i) + ".world")), 
					new Vector(arenaConfig.getInt(nms.get(i) + "location.x2"), 
							arenaConfig.getInt(nms.get(i) + "location.y2"),
							arenaConfig.getInt(nms.get(i) + "location.z2")));
					
			
			addArena(nms.get(i), new Arena(nms.get(i), loc1, loc2, arenaConfig.getBoolean(nms.get(i) + ".prandom"),
					arenaConfig.getHashMap(nms.get(i)+".ploc"), arenaConfig.getBoolean(nms.get(i)+".erandom"),
					arenaConfig.getHashMap(nms.get(i)+".eloc"), arenaConfig.getBoolean(nms.get(i)+".walls")));
		}
	}

	/**
	 * Add an arena from its Arena instance
	 * @param name
	 * @param arena
	 */
	private void addArena(String name, Arena arena) {
		arenas.put(name, arena);
	}

	/**
	 * Add a key to the arenaConfigs HashMap.
	 * @param arena
	 * @param config
	 */
	
	public static boolean newArena(Player player, String name){
		try {
			Region sec = tnt.getWorldEdit().getSession(player.getName()).getSelection(tnt.getWorldEdit().getSession(player.getName()).getSelectionWorld());

			ArrayList<String> nms = (ArrayList<String>) arenaConfig.getStringList("arenas");
			
			arenaConfig.setString(name + ".world", sec.getWorld().getName()); 
			arenaConfig.setString(name + ".location.x1", ""+sec.getMaximumPoint().getBlockX());
			arenaConfig.setString(name + ".location.y1", ""+sec.getMaximumPoint().getBlockY());
			arenaConfig.setString(name + ".location.z1", ""+sec.getMaximumPoint().getBlockZ());
			arenaConfig.setString(name + ".location.x2", ""+sec.getMinimumPoint().getBlockX());
			arenaConfig.setString(name + ".location.y2", ""+sec.getMinimumPoint().getBlockY());
			arenaConfig.setString(name + ".location.z2", ""+sec.getMinimumPoint().getBlockZ());
			arenaConfig.setBoolean(name + ".prandom", true);
			arenaConfig.setString(name + ".ploc", "");
			arenaConfig.setBoolean(name + ".erandom", true);
			arenaConfig.setString(name + ".eloc", "");
			arenaConfig.setBoolean(name + ".walls", true);
			nms.add(name);
			arenaConfig.setStringList("arenas", nms);
			arenaConfig.saveConfig();
			int a = Integer.parseInt(TntMinigame.config.getString("arenas")) + 1;
			TntMinigame.config.setString("arenas", "" + a);
			return true;
		} catch (IncompleteRegionException e) {
			player.sendMessage("IncompleteRegion");
			
			return false;
		} catch (Exception e){
			player.sendMessage("some other error");
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	

	// Getters and Setters
	
	
	/** 
	 * Getter for tnt.
	 * @return
	 */
	public TntMinigame getTnt() {
		return tnt;
	}

	/**
	 * Setter for tnt.
	 * @param tnt
	 */
	public void setTnt(TntMinigame tnt) {
		ArenaHandler.tnt = tnt;
	}

	/**
	 * Getter for arenas.
	 * @return
	 */
	public static HashMap<String, Arena> getArenas() {
		return arenas;
	}
	
	/**
	 * setter for arenas.
	 * @param arenas
	 */
	public static void setArenas(HashMap<String, Arena> arenas) {
		ArenaHandler.arenas = arenas;
	}

	/**
	 * @return the arena
	 */
	public static ConfigAccessor getArenaConfig() {
		return arenaConfig;
	}

	/**
	 * @param arena the arena to set
	 */
	public static void setArenaConfig(ConfigAccessor arenaConfig) {
		ArenaHandler.arenaConfig = arenaConfig;
	}
}
