package org.cakelab.jdoxml.api;
public interface IDocIterator 
{
    IDoc toFirst();
    IDoc toLast();
    IDoc toNext();
    IDoc toPrev();
    IDoc current();
    void release();
}