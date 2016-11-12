package org.cakelab.jdoxml.api;
public interface IEdgeLabelIterator 
{
    IEdgeLabel toFirst();
    IEdgeLabel toLast();
    IEdgeLabel toNext();
    IEdgeLabel toPrev();
    IEdgeLabel current();
    void release();
}