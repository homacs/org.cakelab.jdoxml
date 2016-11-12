package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

class RowIterator extends BaseIterator<IDoc> implements IDocIterator {
	public RowIterator(RowHandler handler) {
		super(handler.m_children);
	}
}