package org.cakelab.jdoxml.api;
public interface INodeIterator 
{
    INode toFirst();
    INode toLast();
    INode toNext();
    INode toPrev();
    INode current();
    void release();
}