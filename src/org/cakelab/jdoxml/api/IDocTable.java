package org.cakelab.jdoxml.api;
public interface IDocTable extends IDoc
{
    IDocIterator rows();
    int numColumns();
    String caption();
}