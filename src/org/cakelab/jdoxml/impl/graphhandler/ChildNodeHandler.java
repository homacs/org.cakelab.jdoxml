package org.cakelab.jdoxml.impl.graphhandler;

import java.util.ArrayList;
import java.util.List;

import org.cakelab.jdoxml.api.IChildNode;
import org.cakelab.jdoxml.api.IEdgeLabelIterator;
import org.cakelab.jdoxml.api.INode;
import org.cakelab.jdoxml.impl.Log;
import org.cakelab.jdoxml.impl.basehandler.BaseHandler;
import org.cakelab.jdoxml.impl.basehandler.IBaseHandler;
import org.xml.sax.Attributes;

public class ChildNodeHandler extends BaseHandler<ChildNodeHandler> implements IChildNode {
	private IBaseHandler m_parent;
	private String m_id;
	private NodeRelation m_relation;
	private String m_relationString;
	List<EdgeLabelHandler> m_edgeLabels = new ArrayList<EdgeLabelHandler>();
	private GraphHandler m_graph;

	public ChildNodeHandler(IBaseHandler parent, GraphHandler gh) {
		m_parent = parent;
		m_graph = gh;
		addEndHandler("childnode", this, "endChildNode");
		addStartHandler("edgelabel", this, "startEdgeLabel");
	}

	public void startChildNode(Attributes attrib) {
		Log.debug(2, "startChildNode\n");
		m_id = attrib.getValue("refid");
		m_relationString = attrib.getValue("relation");
		m_relation = GraphHandler.s_edgeRelationMapper.stringToNodeRelation(m_relationString);
		m_parent.setDelegate(this);
	}

	public void endChildNode() {
		Log.debug(2, "endChildNode\n");
		m_parent.setDelegate(null);
	}

	public void startEdgeLabel(Attributes attrib) {
		EdgeLabelHandler elh = new EdgeLabelHandler(this);
		elh.startEdgeLabel(attrib);
		m_edgeLabels.add(elh);
	}

	public IEdgeLabelIterator edgeLabels() {
		return new EdgeLabelIterator(this);
	}

	public INode node() {
		return m_graph.getNodeById(m_id);
	}

	public NodeRelation relation() {
		return m_relation;
	}

	public String relationString() {
		return m_relationString;
	}

}