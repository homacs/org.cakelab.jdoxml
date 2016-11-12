package org.cakelab.jdoxml.api;
public interface ISectionIterator 
{
    ISection toFirst();
    ISection toLast();
    ISection toNext();
    ISection toPrev();
    ISection current();
    void release();
}