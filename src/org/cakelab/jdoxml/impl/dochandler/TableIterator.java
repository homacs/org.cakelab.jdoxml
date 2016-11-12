package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class TableIterator extends BaseIterator<IDoc> implements IDocIterator
{
    public TableIterator(TableHandler handler) {
      super(handler.m_children); 
    }
}