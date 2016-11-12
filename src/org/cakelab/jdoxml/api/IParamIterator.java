package org.cakelab.jdoxml.api;
public interface IParamIterator
{
    IParam toFirst();
    IParam toLast();
    IParam toNext();
    IParam toPrev();
    IParam current();
    void release();
}