package org.cakelab.jdoxml.api;
/** The public interface to a namespace in the object model. 
 */
public interface INamespace extends ICompound
{
    ICompoundIterator nestedCompounds();
}