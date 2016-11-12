package org.cakelab.jdoxml.impl.graphhandler;

import org.cakelab.jdoxml.api.IEdgeLabel;
import org.cakelab.jdoxml.api.IEdgeLabelIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class EdgeLabelIterator extends BaseIterator<IEdgeLabel> implements IEdgeLabelIterator {
	public EdgeLabelIterator(ChildNodeHandler handler) {
		super(handler.m_edgeLabels);
	}
}