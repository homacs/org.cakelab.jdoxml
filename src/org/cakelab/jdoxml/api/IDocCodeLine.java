package org.cakelab.jdoxml.api;
public interface IDocCodeLine extends IDoc
{
    int lineNumber();
    String refId();
    IDocIterator codeElements();
}