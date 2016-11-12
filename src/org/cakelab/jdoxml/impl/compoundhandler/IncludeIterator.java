package org.cakelab.jdoxml.impl.compoundhandler;

import java.util.List;

import org.cakelab.jdoxml.api.IInclude;
import org.cakelab.jdoxml.api.IIncludeIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

class IncludeIterator extends BaseIterator<IInclude> implements IIncludeIterator
{
    IncludeIterator(List<? extends IInclude> list) { 
    	super(list);
    }
}