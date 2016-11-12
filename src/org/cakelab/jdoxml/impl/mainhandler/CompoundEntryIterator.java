package org.cakelab.jdoxml.impl.mainhandler;

import java.util.List;
import java.util.ListIterator;

import org.cakelab.jdoxml.api.ICompound;
import org.cakelab.jdoxml.api.ICompoundIterator;

public class CompoundEntryIterator implements ICompoundIterator {
	private MainHandler m_mainHandler;
	private ListIterator<CompoundEntry> iterator;
	private CompoundEntry current;
	private List<CompoundEntry> list;

	public CompoundEntryIterator(MainHandler m, List<CompoundEntry> list) {
		this.list = list;
		iterator = list.listIterator();
		m_mainHandler = m;
	}

	public void toFirst() {
		iterator = list.listIterator();
		if (iterator.hasNext()) {
			current = iterator.next();
		} else {
			current = null;
		}
	}

	public void toLast() {
		iterator = list.listIterator(list.size() - 1);
		if (iterator.hasNext()) {
			current = iterator.next();
			iterator.previous();
		} else {
			current = null;
		}
	}

	public void toNext() {
		if (iterator.hasNext()) {
			current = iterator.next();
		} else {
			current = null;
		}
	}

	public void toPrev() {
		if (iterator.hasPrevious()) {
			current = iterator.previous();
		} else {
			current = null;
		}
	}

	public ICompound current() {
		CompoundEntry ch = current;
		return ch != null ? m_mainHandler.compoundById(ch.id) : null;
	}

	public void release() {
	}

}