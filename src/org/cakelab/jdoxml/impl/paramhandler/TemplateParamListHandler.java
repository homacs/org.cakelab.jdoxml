package org.cakelab.jdoxml.impl.paramhandler;

import java.util.List;

import org.cakelab.jdoxml.impl.Log;
import org.cakelab.jdoxml.impl.basehandler.BaseHandler;
import org.cakelab.jdoxml.impl.basehandler.IBaseHandler;
import org.xml.sax.Attributes;

public class TemplateParamListHandler extends BaseHandler<TemplateParamListHandler> {
	protected IBaseHandler m_parent;
	protected List<ParamHandler> m_templateParams;

	public TemplateParamListHandler(IBaseHandler parent) {
		m_parent = parent;
		addStartHandler("param", this, "startParam");

		addEndHandler("templateparamlist", this, "endTemplateParamList");
	}

	public void startParam(Attributes attrib) {
		ParamHandler ph = new ParamHandler(this);
		ph.startParam(attrib);
		m_templateParams.add(ph);
	}

	public void endParam() {
	}

	public void startTemplateParamList(Attributes attrib) {
		m_parent.setDelegate(this);
		Log.debug(2, "templateparamlist\n");
	}

	public void endTemplateParamList() {
		m_parent.setDelegate(null);
	}

	public ParamIterator templateParams() {
		return new ParamIterator(m_templateParams);
	}

}