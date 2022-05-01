package org.cakelab.jdoxml.impl.dochandler;

import java.util.ArrayList;
import java.util.List;

import org.cakelab.jdoxml.api.IDocPara;
import org.cakelab.jdoxml.api.IDocXRefSect;
import org.cakelab.jdoxml.api.IDocXRefTitle;
import org.cakelab.jdoxml.impl.Log;
import org.cakelab.jdoxml.impl.basehandler.BaseHandler;
import org.cakelab.jdoxml.impl.basehandler.IBaseHandler;
import org.xml.sax.Attributes;

/* \brief Node representing a simple section with an unnumbered header.
 *
 */
// children: title, para
public class XRefSectHandler extends BaseHandler<XRefSectHandler> implements IDocXRefSect {
	private IBaseHandler m_parent;
	private List<ParagraphHandler> paragraphs = new ArrayList<ParagraphHandler>();
	private String m_typeString;
	private XRefTitleHandler m_title;
	private Types m_type;

	public XRefSectHandler(IBaseHandler parent) {
		m_parent = parent;
		m_title = null;
		addStartHandler("xreftitle", this, "startTitle");
		addStartHandler("xrefdescription");
		addEndHandler("xrefdescription");
		addStartHandler("para", this, "startParagraph");
//		addEndHandler("para", this, "endParagraph");
		addEndHandler("xrefsect", this, "end");
	}

	public void start(Attributes attrib) {
		Log.debug(2, "start xref section\n");
		m_parent.setDelegate(this);
	}

	public void end() {
		m_type = Types.valueOf(m_title.text());
		Log.debug(2, "end xref section (%s)\n", m_type);
		m_parent.setDelegate(null);
	}

	public void startTitle(Attributes attrib) {
		assert (m_title == null);
		m_title = new XRefTitleHandler(this);
		m_title.startTitle(attrib);
	}

	public void startParagraph(Attributes attrib) {
		ParagraphHandler para = new ParagraphHandler(this);
		para.startParagraph(attrib);
		paragraphs.add(para);
	}

	public Kind kind() {
		return Kind.XRefSect;
	}

	public Types type() {
		return m_type;
	}

	public String typeString() {
		return m_typeString;
	}

	public IDocXRefTitle title() {
		return m_title;
	}

	public IDocPara description() {
		return ParagraphHandler.join(paragraphs);
	}

}