package org.cakelab.jdoxml.impl.dochandler;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class DocSectionParaIterator extends BaseIterator<IDoc> implements IDocIterator
{
    public DocSectionParaIterator(DocSectionHandler handler) {
      super(handler.m_paragraphs);
     }
}