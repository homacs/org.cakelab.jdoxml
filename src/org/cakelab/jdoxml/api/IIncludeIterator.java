package org.cakelab.jdoxml.api;
public interface IIncludeIterator
{
    IInclude toFirst();
    IInclude toLast();
    IInclude toNext();
    IInclude toPrev();
    IInclude current();
    void release();
}