package org.cakelab.jdoxml.impl.dochandler;

import java.util.ArrayList;
import java.util.List;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocCopy;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.Log;
import org.cakelab.jdoxml.impl.basehandler.BaseHandler;
import org.cakelab.jdoxml.impl.basehandler.IBaseHandler;
import org.xml.sax.Attributes;

/** Node representing a copied piece of documentation.
 *
 */
public class CopyHandler extends BaseHandler<CopyHandler> implements IDocCopy {
	private IBaseHandler m_parent;
	List<IDoc> m_children = new ArrayList<IDoc>();

	CopyHandler(IBaseHandler parent)

	{
		m_parent = parent;
		addEndHandler("copydoc", this, "endCopy");

		addStartHandler("para", this, "startParagraph");
	}

	public void startCopy(Attributes attrib) {
		m_parent.setDelegate(this);
		Log.debug(2, "start copy handler\n");
	}

	public void endCopy() {
		Log.debug(2, "end copy handler\n");
		m_parent.setDelegate(null);
	}

	public void startParagraph(Attributes attrib) {
		ParagraphHandler parHandler = new ParagraphHandler(this);
		parHandler.startParagraph(attrib);
		m_children.add(parHandler);
	}

	public IDocIterator contents() {
		return new CopyIterator(this);

	}

	public Kind kind() {
		return Kind.Copy;
	}

}