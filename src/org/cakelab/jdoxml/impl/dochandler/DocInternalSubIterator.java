package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class DocInternalSubIterator extends BaseIterator<IDoc> implements IDocIterator {
	public DocInternalSubIterator(DocInternalHandler handler) {
		super(handler.m_subsections);
	}
}