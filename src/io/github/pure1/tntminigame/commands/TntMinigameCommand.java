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
 */

package io.github.pure1.tntminigame.commands;

import io.github.pure1.tntminigame.TntMinigame;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TntMinigameCommand implements CommandExecutor{

	private TntMinigame plugin;

	public TntMinigameCommand(TntMinigame tntminigame) {
		plugin = tntminigame;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tntminigame")){
			TntMinigame(sender, args);
		}else{}

		return false;
	}

	private void TntMinigame(CommandSender sender, String[] args) {
		
	}
}
