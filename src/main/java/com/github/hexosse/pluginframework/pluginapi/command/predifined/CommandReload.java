package com.github.hexosse.pluginframework.pluginapi.command.predifined;

/*
 * Copyright 2016 Hexosse
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.github.hexosse.pluginframework.pluginapi.Plugin;
import com.github.hexosse.pluginframework.pluginapi.PluginCommand;
import com.github.hexosse.pluginframework.pluginapi.command.CommandError;
import com.github.hexosse.pluginframework.pluginapi.command.CommandInfo;
import org.bukkit.plugin.PluginManager;

/**
 * @author <b>hexosse</b> (<a href="https://github.comp/hexosse">hexosse on GitHub</a>))
 */
public class CommandReload<PluginClass extends Plugin> extends PluginCommand<PluginClass>
{
	public CommandReload(PluginClass plugin, String permission)
	{
		super("reload", plugin);
		this.setPermission(permission);
		this.setDescription("reload the plugin");
	}

	/**
	 * Executes the given command, returning its success
	 *
	 * @param commandInfo Info about the command
	 *
	 * @return true if a valid command, otherwise false
	 */
	@Override
	public boolean onCommand(CommandInfo commandInfo)
	{
		PluginManager pm = this.plugin.getServer().getPluginManager();

		// Disable the plugin
		pm.disablePlugin(this.plugin);

		// Re-enable the plugin
		pm.enablePlugin(this.plugin);

		// Reload hard dependencies
		for(org.bukkit.plugin.Plugin plugin : pm.getPlugins())
		{
			if(plugin != null && plugin.getDescription() != null && plugin.isEnabled() && plugin.getDescription().getDepend() != null)
			{
				for(String depend : plugin.getDescription().getDepend())
				{
					if(depend.equalsIgnoreCase(this.plugin.getName()))
					{
						pm.disablePlugin(plugin);
						pm.enablePlugin(plugin);
					}
				}
			}
		}


		this.plugin.getPluginLogger().info("Reloaded");

		return true;
	}

	@Override
	public void onCommandHelp(CommandError error, CommandInfo commandInfo)
	{
		super.onCommandHelp(error, commandInfo);
	}
}
