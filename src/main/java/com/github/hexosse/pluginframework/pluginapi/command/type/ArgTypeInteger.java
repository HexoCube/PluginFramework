package com.github.hexosse.pluginframework.pluginapi.command.type;

/*
 * Copyright 2016 hexosse
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

import org.bukkit.entity.Player;

/**
 * @author <b>hexosse</b> (<a href="https://github.comp/hexosse">hexosse on GitHub</a>))
 */
public class ArgTypeInteger implements ArgType<Integer>
{
	private ArgTypeInteger() {};
	private static ArgTypeInteger i = new ArgTypeInteger();
	public static ArgTypeInteger get() { return i; }

	@Override
	public boolean check(String integer)
	{
		return get(integer)!=null;
	}

	@Override
	public Integer get(String integer)
	{
		try
		{
			return Integer.parseInt(integer);
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
