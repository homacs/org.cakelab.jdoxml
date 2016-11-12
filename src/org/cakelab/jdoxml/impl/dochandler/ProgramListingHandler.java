package org.cakelab.jdoxml.impl.dochandler;

import java.util.ArrayList;
import java.util.List;

import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.api.IDocProgramListing;
import org.cakelab.jdoxml.impl.Log;
import org.cakelab.jdoxml.impl.basehandler.BaseHandler;
import org.cakelab.jdoxml.impl.basehandler.IBaseHandler;
import org.xml.sax.Attributes;

/** Node representing a program listing
 *
 */
// children: codeline, linenumber
public class ProgramListingHandler extends BaseHandler<ProgramListingHandler> implements IDocProgramListing {
	private IBaseHandler m_parent;
	List<CodeLineHandler> m_children = new ArrayList<CodeLineHandler>();
	private boolean m_hasLineNumber;

	public ProgramListingHandler(IBaseHandler parent) {
		m_parent = parent;
		m_hasLineNumber = false;
		addEndHandler("programlisting", this, "endProgramListing");

		addStartHandler("linenumber", this, "startLineNumber");
		addStartHandler("codeline", this, "startCodeLine");
	}

	public void startProgramListing(Attributes attrib) {
		m_parent.setDelegate(this);
		Log.debug(2, "start programlisting\n");
	}

	public void endProgramListing() {
		Log.debug(2, "end programlisting\n");
		m_parent.setDelegate(null);
	}

	public void startLineNumber(Attributes attrib) {
		CodeLineHandler clh = new CodeLineHandler(this);
		m_children.add(clh);
		m_hasLineNumber = true;
		clh.startLineNumber(attrib);
	}

	public void startCodeLine(Attributes attrib) {
		CodeLineHandler clh = null;
		if (!m_hasLineNumber) {
			clh = new CodeLineHandler(this);
			m_children.add(clh);
		} else {
			clh = m_children.get(m_children.size() - 1);
		}
		assert (clh != null);
		clh.startCodeLine(attrib);
		m_hasLineNumber = false;
	}

	public IDocIterator codeLines() {
		return new ProgramListingIterator(this);
	}

	// IDocProgramListing
	public Kind kind() {
		return Kind.ProgramListing;
	}
}