package org.cakelab.jdoxml.api;
public interface IDocInternal extends IDoc
{
    IDocIterator paragraphs();
    IDocIterator subSections();
}