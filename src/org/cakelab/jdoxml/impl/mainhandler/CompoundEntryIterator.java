package org.cakelab.jdoxml.impl.mainhandler;

import java.util.List;
import java.util.ListIterator;

import org.cakelab.jdoxml.api.ICompound;

public class CompoundEntryIterator implements ListIterator<ICompound> {
	private MainHandler m_mainHandler;
	private ListIterator<CompoundEntry> iterator;
	private CompoundEntry current;

	public CompoundEntryIterator(MainHandler m, List<CompoundEntry> list) {
		iterator = list.listIterator();
		current = null;
		m_mainHandler = m;
	}


	public ICompound current() {
		CompoundEntry ch = current;
		return ch != null ? m_mainHandler.compoundById(ch.id) : null;
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	public ICompound next() {
		current = iterator.next();
		return current();
	}

	public boolean hasPrevious() {
		return iterator.hasPrevious();
	}

	public ICompound previous() {
		current = iterator.previous();
		return current();
	}

	public int nextIndex() {
		return iterator.nextIndex();
	}

	public int previousIndex() {
		return iterator.previousIndex();
	}

	public void remove() {
		iterator.remove();
	}

	public void set(ICompound e) {
		throw new UnsupportedOperationException();
	}

	public void add(ICompound e) {
		throw new UnsupportedOperationException();
	}


}