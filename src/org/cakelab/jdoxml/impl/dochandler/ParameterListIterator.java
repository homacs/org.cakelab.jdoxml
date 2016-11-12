package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class ParameterListIterator extends BaseIterator<IDoc> implements IDocIterator {
	public ParameterListIterator(ParameterListHandler handler) { 
      super(handler.m_paramItems);
    }
}