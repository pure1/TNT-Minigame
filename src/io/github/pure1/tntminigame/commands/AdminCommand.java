package io.github.pure1.tntminigame.commands;

import org.bukkit.command.CommandSender;

public abstract class AdminCommand{

	/* commands:
	 * 
	 * admin
	 * 
	 * 
	 * permissions:
	 * 
	 * tntminigame.admin
	 * tntminigame.arena
	 * tntminigame.arena.list
	 * tntminigame.arena.make
	 * tntminigame.arena.set
	 * tntminigame.arena.del
	 * tntminigame.lobby
	 * tntminigame.lobby.make
	 * tntminigame.lobby.set
	 * tntminigame.lobby.del
	 * 
	 * 
	 */
	
	/* admin
	 * 	arena {arena}
	 * 		list
	 * 		make [name]
	 * 		set
	 * 			player-spawn [spawn id]
	 * 			player-random [True/False]
	 * 			entity-spawn [spawn id] [entity id]
	 * 			entity-random [True/False]
	 * 			virtual-walls [True/False]
	 * 		del
	 * 			arena
	 * 			player-spawn [id] {all}
	 * 			entity-spawn [id] {all}
	 * 			
	 * 			
	 * 	lobby
	 *		make [arena name]
	 *		set
	 *			link [arena name]
	 *    		max-players [integer]
	 *    		min-players [integer]
	 *    		game-time [integer]
	 *    		lobby-time [integer]
	 * 		del
	 * 			link
	 * 			lobby
	 */
	
	public static void command(CommandSender sender, String[] args) {
		if(args.length  == 0){
			adminHelp(sender);
		}else if(args.length < 2){
			switch(args[0].toLowerCase()){
			case "arena":
				arenaHelp(sender);
				break;
			case "lobby":
				lobbyHelp(sender);
				break;
			default:
				commandError(sender);
				adminHelp(sender);
				break;
			}
		}else if(args.length > 1){
			switch(args[0].toLowerCase()){
			case "arena":
				arena(sender, args);
				break;
			case "lobby":
				lobby(sender, args);
				break;
			default:
				commandError(sender);
				adminHelp(sender);
				break;
			}
		}else{
			commandError(sender);
			adminHelp(sender);
		}
//			arenaHelp(sender);
//			arenaMakeHelp(sender);
//			arenaSetHelp(sender);
//			arenaDelHelp(sender);
//			lobbyHelp(sender);
//			lobbyMakeHelp(sender);
//			lobbySetHelp(sender);
//			lobbyDelHelp(sender);
	}

	private static void adminHelp(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin"))return;
		//TODO
	}
	
	private static void lobby(CommandSender sender, String[] args) {
		if(!sender.hasPermission("tntminigame.admin.lobby"))return;
		if(args.length > 1){
			switch(args[1].toLowerCase()){
			case "make":
				lobbyMake(sender, args);
			case "set":
				lobbySet(sender, args);
			case "del":
				lobbyDel(sender, args);
			}
		}else{
			lobbyHelp(sender);
		}
	}

	private static void lobbyHelp(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin.lobby"))return;
		//TODO
	}
	
	private static void lobbyMake(CommandSender sender, String[] args) {
		if(!sender.hasPermission("tntminigame.admin.lobby.make"))return;		
		if(args.length > 2){
			//TODO
		}else{
			lobbyMakeHelp(sender);
		}
	}

	private static void lobbyMakeHelp(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin.lobby.make"))return;
		//TODO
	}


	private static void lobbySet(CommandSender sender, String[] args) {
		if(!sender.hasPermission("tntminigame.admin.lobby.set"))return;
		if(args.length < 3){
			lobbySetHelp(sender);
		}else{
			/*TODO*/;
		}
	}


	private static void lobbySetHelp(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin.lobby.set"))return;
		//TODO
	}
	
	private static void lobbyDel(CommandSender sender, String[] args) {
		if(!sender.hasPermission("tntminigame.admin.lobby.del"))return;
		if(args.length < 3){
			lobbyDelHelp(sender);
		}else{
			//TODO;
		}
	}

	private static void lobbyDelHelp(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin.lobby.del"))return;
		//TODO
	}
	
	
	
	
	private static void arena(CommandSender sender, String[] args) {
		if(!sender.hasPermission("tntminigame.admin.arena"))return;
		if(args.length > 1){
			switch(args[1].toLowerCase()){
			case "list":
				arenaList(sender);
			case "make":
				arenaMake(sender, args);
			case "set":
				arenaSet(sender, args);
			case "del":
				arenaDel(sender, args);
			}
		}
	}

	private static void arenaHelp(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin.arena"))return;
		//TODO
	}
	
	private static void arenaList(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin.arena.list"))return;
		//TODO
	}
	
	private static void arenaMake(CommandSender sender, String[] args) {
		if(!sender.hasPermission("tntminigame.admin.arena.make"))return;
		if(args.length < 2){
			arenaMakeHelp(sender);
		}else{
			//TODO
		}
	}
	
	private static void arenaMakeHelp(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin.arena.make"))return;
		//TODO
	}

	private static void arenaSet(CommandSender sender, String[] args) {
		if(!sender.hasPermission("tntminigame.admin.arena.set"))return;
		if(args.length < 2){
			arenaSetHelp(sender);
		}else{
			//TODO
		}
	}
	
	private static void arenaSetHelp(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin.arena.set"))return;
		//TODO
	}

	private static void arenaDel(CommandSender sender, String[] args) {
		if(!sender.hasPermission("tntminigame.admin.arena.del"))return;
		if(args.length < 2){
			arenaDelHelp(sender);
		}else{
			//TODO
		}
	}
	
	private static void arenaDelHelp(CommandSender sender) {
		if(!sender.hasPermission("tntminigame.admin.arena.del"))return;
		//TODO
	}


	private static void commandError(CommandSender sender) {
		
	}
}
