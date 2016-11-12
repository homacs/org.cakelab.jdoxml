package org.cakelab.jdoxml.api;
public interface IChildNodeIterator 
{
    IChildNode toFirst();
    IChildNode toLast();
    IChildNode toNext();
    IChildNode toPrev();
    IChildNode current();
    void release();
}