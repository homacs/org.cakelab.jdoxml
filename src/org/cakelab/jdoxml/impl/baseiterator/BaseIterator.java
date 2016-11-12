package org.cakelab.jdoxml.impl.baseiterator;

import java.util.List;
import java.util.ListIterator;


public class BaseIterator<T> 
{

	private List<? extends T> list;
	private int current;
	
	public BaseIterator(List<? extends T> list) {
		this.list = list;
		current = 0;
    }
    public T toFirst() {
    	current = 0;
    	return current();
    }
    public T toLast()  {
    	current = list.size()-1;
    	return current(); 
    }
    public T toNext()  { 
    	current++;
    	return current();
    }
    public T toPrev()  { 
    	current--;
    	return current(); 
    }
    public T current() {
    	T result;
    	try {
    		result = list.get(current); 
    	} catch (IndexOutOfBoundsException e) {
    		result = null;
    	}
    	return result;
    }
	public void release() { 
	}
}