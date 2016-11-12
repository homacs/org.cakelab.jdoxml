package org.cakelab.jdoxml.impl;

public class Log {

	private static int s_debugLevel = 0;
	
	public static void debug(int level, String format, Object ... args) {
		if (level<=s_debugLevel) {
			System.err.printf(format, args);
		}
	}
	public static void setDebugLevel(int level)
	{
	  s_debugLevel = level;
	}

}
