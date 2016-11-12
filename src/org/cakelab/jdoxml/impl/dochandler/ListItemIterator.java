package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.api.IDocPara;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class ListItemIterator extends BaseIterator<IDocPara> implements IDocIterator
{
    ListItemIterator(ListItemHandler handler) {
    	super(handler.m_children);
    }

}