package org.cakelab.jdoxml.api;
public interface IRelatedCompoundIterator 
{
    IRelatedCompound toFirst();
    IRelatedCompound toLast();
    IRelatedCompound toNext();
    IRelatedCompound toPrev();
    IRelatedCompound current();
    void release();
}