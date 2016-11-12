package org.cakelab.jdoxml.api;
public interface IDocMarkup extends IDoc
{
    enum Markup 
    { 
		Normal         (0x000),
		Bold           (0x001),
		Emphasis       (0x002),
		ComputerOutput (0x004),
		Subscript      (0x008),
		Superscript    (0x010),
		SmallFont      (0x020),
		Center         (0x040),
		Preformatted   (0x080),
		Heading        (0x100);
    	
    	private int value;

		Markup(int value) {
    		this.value = value;
    	}
		
		public int value() {
			return value;
		}
    };
}