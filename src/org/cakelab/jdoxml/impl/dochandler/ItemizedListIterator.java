package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.api.IDocListItem;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class ItemizedListIterator extends BaseIterator<IDocListItem> implements IDocIterator {
	ItemizedListIterator(ItemizedListHandler handler) {
		super(handler.m_children);
	}
}