package org.cakelab.jdoxml.api;
public interface INode
{
    String id();
    String label();
    String linkId();
    IChildNodeIterator children();
}