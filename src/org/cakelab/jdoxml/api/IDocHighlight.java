package org.cakelab.jdoxml.api;
public interface IDocHighlight extends IDoc
{
    enum HighlightKind 
    { 
    	Invalid,
    	Comment, 
    	Keyword, 
    	KeywordType, 
    	KeywordFlow, 
    	CharLiteral, 
    	StringLiteral, 
    	Preprocessor;
    	public int value() {
    		return ordinal();
    	}
    };
    HighlightKind highlightKind();
    IDocIterator  codeElements();
}