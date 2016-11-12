package org.cakelab.jdoxml.api;
public interface IMemberReferenceIterator 
{
    IMemberReference toFirst();
    IMemberReference toLast();
    IMemberReference toNext();
    IMemberReference toPrev();
    IMemberReference current();
    void release();
}