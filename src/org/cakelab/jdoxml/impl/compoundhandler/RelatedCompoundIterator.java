package org.cakelab.jdoxml.impl.compoundhandler;

import java.util.List;

import org.cakelab.jdoxml.api.IRelatedCompound;
import org.cakelab.jdoxml.api.IRelatedCompoundIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class RelatedCompoundIterator extends BaseIterator<IRelatedCompound> implements IRelatedCompoundIterator
{
    RelatedCompoundIterator(List<? extends IRelatedCompound> list) {
    	super(list);
    }
}