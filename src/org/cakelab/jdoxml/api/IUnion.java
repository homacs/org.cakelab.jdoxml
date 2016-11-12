package org.cakelab.jdoxml.api;
/** The public interface to a union in the object model. 
 */
public interface IUnion extends ICompound
{
    ICompoundIterator nestedCompounds();
}