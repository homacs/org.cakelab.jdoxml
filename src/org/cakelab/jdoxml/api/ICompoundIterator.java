package org.cakelab.jdoxml.api;
public interface ICompoundIterator 
{
    void toFirst();
    void toLast();
    void toNext();
    void toPrev();
    ICompound current();
    void release();
}