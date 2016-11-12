package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class ParameterItemIterator extends BaseIterator<IDoc> implements IDocIterator
{
    ParameterItemIterator(ParameterItemHandler handler) { 
      super(handler.m_parameters);
    }
}