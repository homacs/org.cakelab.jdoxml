package org.cakelab.jdoxml.impl;

public class StringDecode {

	public static int toInt(String value) {
		if (value != null) {
			return Integer.decode(value);
		}
		return -1;
	}

}
