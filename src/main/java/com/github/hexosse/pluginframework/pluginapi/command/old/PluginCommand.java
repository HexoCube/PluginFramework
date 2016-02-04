package com.github.hexosse.pluginframework.pluginapi.command.old;

/*
 * Copyright 2015 hexosse
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import com.github.hexosse.pluginframework.pluginapi.PluginObject;
import com.github.hexosse.pluginframework.pluginapi.Plugin;
import org.bukkit.command.CommandSender;

/**
 * The class that all command object belonging to this plugin should extend.
 *
 * @author <b>hexosse</b> (<a href="https://github.comp/hexosse">hexosse on GitHub</a>))
 */
public abstract class PluginCommand<PluginClass extends Plugin> extends PluginObject<PluginClass>
{
    /**
     * @param plugin The plugin that this object belong to.
     */
    public PluginCommand(PluginClass plugin)
    {
        super(plugin);
    }

    /**
     * Abstarct metode
     *
     * @param sender Sender executing the command.
     */
    abstract public void execute(CommandSender sender);
}
