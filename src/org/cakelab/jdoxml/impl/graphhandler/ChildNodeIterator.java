package org.cakelab.jdoxml.impl.graphhandler;

import org.cakelab.jdoxml.api.IChildNode;
import org.cakelab.jdoxml.api.IChildNodeIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class ChildNodeIterator extends BaseIterator<IChildNode> implements IChildNodeIterator {
	public ChildNodeIterator(NodeHandler handler) {
		super(handler.m_children);
	}
}