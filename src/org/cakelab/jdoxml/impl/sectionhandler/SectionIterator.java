package org.cakelab.jdoxml.impl.sectionhandler;

import java.util.List;

import org.cakelab.jdoxml.api.ISection;
import org.cakelab.jdoxml.api.ISectionIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class SectionIterator extends BaseIterator<ISection> implements ISectionIterator {
	public SectionIterator(List<SectionHandler> list) {
		super(list);
	}
}