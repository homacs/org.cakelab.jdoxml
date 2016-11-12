package org.cakelab.jdoxml.impl.memberhandler;

import java.util.List;

import org.cakelab.jdoxml.api.IMemberReference;
import org.cakelab.jdoxml.api.IMemberReferenceIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class MemberReferenceIterator extends BaseIterator<IMemberReference> implements IMemberReferenceIterator {
	public MemberReferenceIterator(List<MemberReference> list) {
		super(list);
	}
}