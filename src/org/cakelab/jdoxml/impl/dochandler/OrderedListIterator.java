package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.api.IDocListItem;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class OrderedListIterator extends  BaseIterator<IDocListItem> implements IDocIterator
{
    OrderedListIterator(OrderedListHandler handler) {
      super(handler.m_children);
    }
}