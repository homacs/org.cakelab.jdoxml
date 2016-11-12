package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

class DocSectionSubIterator extends BaseIterator<IDoc> implements IDocIterator
{
    public DocSectionSubIterator(DocSectionHandler handler) {
      super(handler.m_subsections);
    }
}