package org.cakelab.jdoxml.api;
/** The public interface to a Java/IDL public interface in the object model. 
 */
public interface IInterface extends ICompound
{
    IRelatedCompoundIterator baseCompounds();
    IRelatedCompoundIterator derivedCompounds();
}