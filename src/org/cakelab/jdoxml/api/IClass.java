package org.cakelab.jdoxml.api;
/** The public interface to a class in the object model. 
 */
public interface IClass extends ICompound
{
    IGraph inheritanceGraph();
    IGraph collaborationGraph();
    IRelatedCompoundIterator baseCompounds();
    IRelatedCompoundIterator derivedCompounds();
    ICompoundIterator nestedCompounds();
    IParamIterator templateParameters();
    String locationFile();
    int locationLine();
    String locationBodyFile();
    int locationBodyStartLine();
    int locationBodyEndLine();

    // TODO:
    // class:
    //  listOfAllMembers()
    //  protection()
    //  isAbstract()
}