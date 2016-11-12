package org.cakelab.jdoxml.impl.linkedtexthandler;

import java.util.List;

import org.cakelab.jdoxml.api.ILinkedText;
import org.cakelab.jdoxml.api.ILinkedTextIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class LinkedTextIterator extends BaseIterator<ILinkedText> implements ILinkedTextIterator {
	public LinkedTextIterator(List<ILinkedText> list) {
		super(list);
	}
}