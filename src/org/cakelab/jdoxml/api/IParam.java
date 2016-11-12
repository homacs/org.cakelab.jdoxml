package org.cakelab.jdoxml.api;
/** Representation of a parameter of a function. */
public interface IParam 
{
    ILinkedTextIterator type();
    String  declarationName();
    String  definitionName();
    String  attrib();
    String  arraySpecifier();
    ILinkedTextIterator defaultValue();
    IDocRoot briefDescription();
}
