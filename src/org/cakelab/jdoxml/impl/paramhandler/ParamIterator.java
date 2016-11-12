package org.cakelab.jdoxml.impl.paramhandler;

import java.util.List;

import org.cakelab.jdoxml.api.IParam;
import org.cakelab.jdoxml.api.IParamIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class ParamIterator extends BaseIterator<IParam> implements IParamIterator {
	public ParamIterator(List<ParamHandler> list) {
		super(list);
	}
}