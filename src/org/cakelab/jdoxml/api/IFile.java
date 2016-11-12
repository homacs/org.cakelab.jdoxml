package org.cakelab.jdoxml.api;
/** The public interface to a file in the object model. 
 */
public interface IFile extends ICompound
{
    IGraph includeDependencyGraph();
    IGraph includedByDependencyGraph();
    IDocProgramListing source();
    ICompoundIterator nestedCompounds();

    IIncludeIterator includes();
    IIncludeIterator includedBy();

    //  ICompound *innerNamespaces()
    //  ICompoundIterator *innerClasses()
}