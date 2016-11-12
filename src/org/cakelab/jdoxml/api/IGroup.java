package org.cakelab.jdoxml.api;
/** The public interface to a group in the object model. 
 */
public interface IGroup extends ICompound
{
    ICompoundIterator nestedCompounds();
    // group:
    //  Title()
    //  innerFile()
    //  innerPage()
}