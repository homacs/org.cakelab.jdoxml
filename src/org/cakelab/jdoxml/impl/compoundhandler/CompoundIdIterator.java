package org.cakelab.jdoxml.impl.compoundhandler;

import java.util.List;

import org.cakelab.jdoxml.api.ICompound;
import org.cakelab.jdoxml.api.ICompoundIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;
import org.cakelab.jdoxml.impl.mainhandler.MainHandler;

class CompoundIdIterator implements ICompoundIterator

{
	private MainHandler m_mainHandler;
	private BaseIterator<String> iterator;

	CompoundIdIterator(MainHandler m, List<String> list) {
		iterator = new BaseIterator<String>(list);
		m_mainHandler = m;
	}

	public void toFirst() {
		iterator.toFirst();
	}

	public void toLast() {
		iterator.toLast();
	}

	public void toNext() {
		iterator.toNext();
	}

	public void toPrev() {
		iterator.toPrev();
	}

	public ICompound current() {
		String id = iterator.current();
		return id != null ? m_mainHandler.compoundById(id) : null;
	}

	public void release() {
	}

}