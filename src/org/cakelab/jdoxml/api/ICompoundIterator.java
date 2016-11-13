package org.cakelab.jdoxml.api;

import java.util.ListIterator;

public interface ICompoundIterator extends ListIterator<ICompound>
{
    void toFirst();
    void toLast();
    void toNext();
    void toPrev();
    ICompound current();
}