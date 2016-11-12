package org.cakelab.jdoxml.api;
/** The public interface to a struct in the object model. 
 */
public interface IStruct extends ICompound
{
    ICompoundIterator nestedCompounds();
    IRelatedCompoundIterator baseCompounds();
    IRelatedCompoundIterator derivedCompounds();
    String locationFile();
    int locationLine();
    int locationBodyStartLine();
    int locationBodyEndLine();
}