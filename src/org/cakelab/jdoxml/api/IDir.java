package org.cakelab.jdoxml.api;
/** \brief public interface to a directory in the object model. */
public interface IDir extends ICompound
{
    ICompoundIterator nestedCompounds();
}