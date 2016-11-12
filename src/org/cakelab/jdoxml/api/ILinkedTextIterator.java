package org.cakelab.jdoxml.api;
/** Iterates over a list of ILinkedText fragments.
 */
public interface ILinkedTextIterator 
{
    ILinkedText toFirst();
    ILinkedText toLast();
    ILinkedText toNext();
    ILinkedText toPrev();
    ILinkedText current();
    void release();
}