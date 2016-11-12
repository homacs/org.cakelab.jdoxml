package org.cakelab.jdoxml.api;
public interface IDocParameterList extends IDoc
{
    enum Types { Param, RetVal, Exception };
    Types sectType();
    IDocIterator params();
}