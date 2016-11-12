package org.cakelab.jdoxml.impl.memberhandler;

import java.util.List;

import org.cakelab.jdoxml.api.IMember;
import org.cakelab.jdoxml.api.IMemberIterator;
import org.cakelab.jdoxml.impl.baseiterator.BaseIterator;

public class MemberIterator extends BaseIterator<IMember> implements IMemberIterator {
	public MemberIterator(List<MemberHandler> list) {
		super(list);
	}
}