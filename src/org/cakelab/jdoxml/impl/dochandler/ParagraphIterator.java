package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

class ParagraphIterator extends BaseIterator<IDoc> implements IDocIterator
{
    ParagraphIterator(ParagraphHandler handler) {
    	super(handler.m_children);
    }
}