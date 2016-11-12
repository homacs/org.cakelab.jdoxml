package org.cakelab.jdoxml.api;
public interface IChildNode
{
    enum NodeRelation { 
    	PublicInheritance, 
    	ProtectedInheritance,
    	PrivateInheritance, 
    	Usage, 
    	TemplateInstance;
    	
    	public int value() {
    		return ordinal();
    	}
	};
    INode node();
    NodeRelation relation();
    String relationString();
    IEdgeLabelIterator edgeLabels();
}