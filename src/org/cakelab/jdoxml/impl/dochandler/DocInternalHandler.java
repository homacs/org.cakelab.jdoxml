package org.cakelab.jdoxml.impl.dochandler;

import java.util.List;

import org.cakelab.jdoxml.api.IDoc;
import org.cakelab.jdoxml.api.IDocInternal;
import org.cakelab.jdoxml.api.IDocIterator;
import org.cakelab.jdoxml.impl.Log;
import org.cakelab.jdoxml.impl.basehandler.BaseHandler;
import org.cakelab.jdoxml.impl.basehandler.IBaseHandler;
import org.xml.sax.Attributes;

public class DocInternalHandler extends BaseHandler<DocInternalHandler> implements IDocInternal {
	private IBaseHandler m_parent;
	List<IDoc> m_paragraphs;
	List<IDoc> m_subsections;
	private int m_level;

	public DocInternalHandler(IBaseHandler parent, int level) {
		m_parent = parent;
		m_level = level;
		addStartHandler("para", this, "startParagraph");
		String sectionKey;
		sectionKey = "sect" + (level + 1);
		addStartHandler(sectionKey, this, "startSubSection");
		addEndHandler("internal", this, "endInternal");
	}

	public void startInternal(Attributes attrib) {
		m_parent.setDelegate(this);
		Log.debug(2, "Start internal\n");
	}

	public void endInternal() {
		m_parent.setDelegate(null);
		Log.debug(2, "End internal\n");
	}

	public void startSubSection(Attributes attrib) {
		DocSectionHandler secHandler = new DocSectionHandler(this, m_level + 1);
		secHandler.startDocSection(attrib);
		m_subsections.add(secHandler);
	}

	public void startParagraph(Attributes attrib) {
		ParagraphHandler parHandler = new ParagraphHandler(this);
		parHandler.startParagraph(attrib);
		m_paragraphs.add(parHandler);
	}

	public IDocIterator paragraphs() {
		return new DocInternalParaIterator(this);
	}

	public IDocIterator subSections() {
		return new DocInternalSubIterator(this);
	}

	public Kind kind() {
		return Kind.Internal;
	}

}