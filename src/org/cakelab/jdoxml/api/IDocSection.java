package org.cakelab.jdoxml.api;
public interface IDocSection extends IDoc
{
    String id(); 
    int level();
    IDocTitle title();
    IDocIterator paragraphs();
    IDocIterator subSections();
    IDocInternal internal();
}