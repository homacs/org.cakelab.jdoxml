package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.api.IDocTocItem;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class TocListIterator extends BaseIterator<IDocTocItem> implements IDocIterator
{
    public TocListIterator(TocListHandler handler) {
    	super(handler.m_children);    	
    }
}