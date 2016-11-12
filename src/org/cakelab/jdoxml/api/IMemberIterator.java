package org.cakelab.jdoxml.api;
public interface IMemberIterator 
{
    IMember toFirst();
    IMember toLast();
    IMember toNext();
    IMember toPrev();
    IMember current();
    void release();
}