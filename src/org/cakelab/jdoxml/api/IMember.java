package org.cakelab.jdoxml.api;
public interface IMember 
{
    enum MemberKind { 
    	Invalid,
    	Define,
    	Property,
    	Variable,
    	Typedef,
    	Enum,
    	Function,
    	Signal,
    	Prototype,
    	Friend,
    	DCOP,
    	Slot, 
        EnumValue;
    	public int value() {
    		return ordinal();
    	}
	}

    ICompound compound();
    ISection section();
    MemberKind kind();
    String  kindString();
    String  id();
    String  protection();
    String  virtualness();
    ILinkedTextIterator type();
    String  typeString();
    String  name();
    String  readAccessor();
    String  writeAccessor();
    String  definition();
    String  argsstring();
    boolean isConst();
    boolean isVolatile();
    boolean isStatic();
    boolean isExplicit();
    boolean isInline();
    boolean isMutable();
    boolean isReadable();
    boolean isWritable();
    IParamIterator parameters();
    IParamIterator templateParameters();
    ILinkedTextIterator initializer();
    ILinkedTextIterator exceptions();
    IMemberReferenceIterator references(); 
    IMemberReferenceIterator referencedBy();
    String bodyFile();
    int bodyStart();
    int bodyEnd();
    String  definitionFile();
    int definitionLine();
    IMemberReference reimplements();
    IMemberReferenceIterator reimplementedBy();
    IDocRoot briefDescription();
    IDocRoot detailedDescription();
    IDocRoot inbodyDescription();
}