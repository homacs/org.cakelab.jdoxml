package org.cakelab.jdoxml.impl.graphhandler;

import org.cakelab.jdoxml.api.INode;
import org.cakelab.jdoxml.api.INodeIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class NodeIterator extends BaseIterator<INode> implements INodeIterator {
	public NodeIterator(GraphHandler handler) {
		super(handler.m_nodes);
	}
}