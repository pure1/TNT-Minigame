/*  
 * Copyright 2014 Oliver Strik <pure1.github.io>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 *
 *
 *
 *
 * If my code looks messy or something like that, it's my code,
 * it's like handwriting, We all code differently and this is how I code.
 * If there is anything that really could be done better, I welcome suggestions.
 * 
 */

package io.github.pure1.tntminigame;

import io.github.pure1.tntminigame.listeners.BlockListener;
import io.github.pure1.tntminigame.listeners.PlayerListener;
import io.github.pure1.tntminigame.arena.ArenaHandler;
import io.github.pure1.tntminigame.commands.TntMinigameCommand;
import io.github.pure1.plugin.utils.ConfigAccessor;
import io.github.pure1.plugin.utils.Metrics;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.WorldEdit;

public class TntMinigame extends JavaPlugin {

	/* update [0.0.3]:
	 * + arenas, they are makeable but as of yet do nothing.
	 * + more or less completed the arena handler.
	 * 
	 * update [0.0.2]:
	 * + all admin command stubs + permissions.
	 * 
	 * update [0.0.1]:
	 * + Base plugin files.
	 * 
	 */

	/* TODO
	 * - Create required classes. [X]
	 * - Get Basic functionality. [ ]
	 * - Complete Lobbies.        [ ]
	 */

	
	
	/*
	 * SET TRUE ON RELEASE COMPILE
	 */
	public static final boolean released = false;

	public final Logger logger = Logger.getLogger("Minecraft");
		
	public static ConfigAccessor config;
	public static ConfigAccessor arena;
	
	private static WorldEdit worldEdit;
	private PlayerListener playerListener;
	private BlockListener blockListener;
	
	private ArenaHandler arenaHandler;
	
	private TntMinigameCommand TntMinigameCommand;
	
	
	/**
	 * on Enable.
	 */
	@Override
	public void onEnable() {
		config = new ConfigAccessor(this, "config.yml");
		arena = new ConfigAccessor(this, "arena.yml");
		initConfig();
		init();
		registerListeners();
		registerCommands();
		registerManagers();
		Metrics();
		
	}

	/** 
	 * Initialise Listeners, Handlers and Commands
	 */
	public void init(){
		setWorldEdit(WorldEdit.getInstance());
		playerListener = new PlayerListener(this);
		blockListener = new BlockListener(this);
		setArenaHandler(new ArenaHandler(this));
		TntMinigameCommand = new TntMinigameCommand(this);
	}
	
	/**
	 * Register Listeners.
	 */
	public void registerListeners(){
		getServer().getPluginManager().registerEvents(playerListener, this);
		getServer().getPluginManager().registerEvents(blockListener, this);
	}
	
	/** 
	 * Register Commands.
	 */
	public void registerCommands(){
		getCommand("tntminigame").setExecutor(TntMinigameCommand);
		getCommand("admintntminigame").setExecutor(TntMinigameCommand);
	}
	
	/** 
	 * Register Managers.
	 */
	public void registerManagers(){
		
	}
	
	/** 
	 * Metrics. 
	 */
	public void Metrics(){
		if (released) {
			try {
				Metrics metrics = new Metrics(this);
				metrics.start();
			} catch (IOException e) {
			}
		}
	}
	
	/** 
	 * Initalize Config. 
	 */
	public void initConfig(){
		config.saveDefaultConfig();
		config.getConfig();
		config.saveConfig();
		arena.saveDefaultConfig();
		arena.getConfig();
		arena.saveConfig();
	}
	
	/**
	 * On Disable.
	 */
	@Override
	public void onDisable() {
	}

	/**
	 * @return the arenaHandler
	 */
	public ArenaHandler getArenaHandler() {
		return arenaHandler;
	}

	/**
	 * @param arenaHandler the arenaHandler to set
	 */
	public void setArenaHandler(ArenaHandler arenaHandler) {
		this.arenaHandler = arenaHandler;
	}

	/**
	 * @return the worldEdit
	 */
	public WorldEdit getWorldEdit() {
		return worldEdit;
	}

	/**
	 * @param worldEdit the worldEdit to set
	 */
	public static void setWorldEdit(WorldEdit worldEdit) {
		TntMinigame.worldEdit = worldEdit;
	}
}
