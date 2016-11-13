package org.cakelab.jdoxml.api;

import java.util.ListIterator;

public interface IDocIterator
{
    IDoc toFirst();
    IDoc toLast();
    IDoc toNext();
    IDoc toPrev();
    IDoc current();
    void release();
}