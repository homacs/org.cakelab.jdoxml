package org.cakelab.jdoxml.impl.dochandler;

import java.util.ArrayList;
import java.util.List;

import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.api.IDocRow;
import org.cakelab.jdoxml.impl.basehandler.BaseHandler;
import org.cakelab.jdoxml.impl.basehandler.IBaseHandler;
import org.xml.sax.Attributes;

/** Node representing an entry in the table row.
 *
 */
// children: entry
public class RowHandler extends BaseHandler<RowHandler> implements IDocRow {
	private IBaseHandler m_parent;
	List<EntryHandler> m_children = new ArrayList<EntryHandler>();

	public RowHandler(IBaseHandler parent) {
		m_parent = parent;
		addEndHandler("row", this, "endRow");
		addStartHandler("entry", this, "startEntry");
	}

	public void startRow(Attributes attrib) {
		m_parent.setDelegate(this);
	}

	public void endRow() {
		m_parent.setDelegate(null);
	}

	public void startEntry(Attributes attrib) {
		EntryHandler eh = new EntryHandler(this);
		eh.startEntry(attrib);
		m_children.add(eh);
	}

	public IDocIterator entries() {
		return new RowIterator(this);
	}

	public Kind kind() {
		return Kind.Row;
	}

}