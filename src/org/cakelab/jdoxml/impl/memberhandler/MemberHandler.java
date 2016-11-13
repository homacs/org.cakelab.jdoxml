package org.cakelab.jdoxml.impl.memberhandler;

import java.util.ArrayList;
import java.util.List;

import org.cakelab.jdoxml.api.*;
import org.cakelab.jdoxml.impl.Log;
import org.cakelab.jdoxml.impl.StringDecode;
import org.cakelab.jdoxml.impl.basehandler.BaseHandler;
import org.cakelab.jdoxml.impl.basehandler.IBaseHandler;
import org.cakelab.jdoxml.impl.compoundhandler.CompoundHandler;
import org.cakelab.jdoxml.impl.dochandler.DocHandler;
import org.cakelab.jdoxml.impl.linkedtexthandler.LinkedTextHandler;
import org.cakelab.jdoxml.impl.linkedtexthandler.LinkedTextIterator;
import org.cakelab.jdoxml.impl.mainhandler.MainHandler;
import org.cakelab.jdoxml.impl.paramhandler.ParamHandler;
import org.cakelab.jdoxml.impl.paramhandler.ParamIterator;
import org.cakelab.jdoxml.impl.sectionhandler.SectionHandler;
import org.xml.sax.Attributes;

public class MemberHandler extends BaseHandler<MemberHandler> implements IDefine, IProperty, IVariable, ITypedef,
		IFunction, ISignal, IPrototype, IFriend, IDCOP, ISlot, IEnum, IEnumValue {

	static MemberTypeMap s_typeMap;

	public static void memberhandler_init() {
		s_typeMap = new MemberTypeMap();
	}

	public static void memberhandler_exit() {
		s_typeMap = null;
	}

	// XML elements:
	// -----------------
	private List<ParamHandler> m_templateParams = new ArrayList<ParamHandler>(); // templateparamlist
	private List<ILinkedText> m_type = new ArrayList<ILinkedText>(); // type
	private String m_definition; // definition
	private String m_argsstring; // argsstring
	private String m_name; // name
	private String m_read; // read
	private String m_write; // write
	private MemberReference m_reimplements; // reimplements
	private List<MemberReference> m_reimplementedBy = new ArrayList<MemberReference>(); // reimplementedby
	private List<ParamHandler> m_params = new ArrayList<ParamHandler>(); // param
	private List<MemberHandler> m_enumValues = new ArrayList<MemberHandler>(); // enumvalue
	private List<ILinkedText> m_initializer = new ArrayList<ILinkedText>(); // initializer
	private List<ILinkedText> m_exception = new ArrayList<ILinkedText>(); // exceptions
	private DocHandler m_brief; // briefdescription
	private DocHandler m_detailed; // detaileddescription
	private DocHandler m_inbody; // inbodydescription
	// location
	private String m_defFile; // - file
	private int m_defLine; // - line
	private String m_bodyFile; // - bodyfile
	private int m_bodyStart; // - bodystart
	private int m_bodyEnd; // - bodyend
	private List<MemberReference> m_references = new ArrayList<MemberReference>(); // references
	private List<MemberReference> m_referencedBy = new ArrayList<MemberReference>(); // referencedby

	// XML attributes:
	// ---------------
	private MemberKind m_kind; // kind
	private String m_kindString; // kind as a string
	private String m_id; // id
	private String m_protection; // prot
	private boolean m_isStatic; // static
	private boolean m_isConst; //
	private boolean m_isExplicit; // explicit
	private boolean m_isInline; // inline
	private String m_virtualness; // virt
	private boolean m_isVolatile; // volatile
	private boolean m_isMutable; // mutable
	private boolean m_isReadable; // readable
	private boolean m_isWritable; // writable

	private CompoundHandler m_compound;
	private SectionHandler m_section;
	private String m_typeString;
	private LinkedTextHandler m_linkedTextHandler;
	private boolean m_insideTemplateParamList;
	private boolean m_hasTemplateParamList;
	private IBaseHandler m_parent;

	public MemberHandler(IBaseHandler parent) {
		m_brief = null;
		m_detailed = null;
		m_inbody = null;
		m_compound = null;
		m_section = null;
		m_parent = parent;
		// printf("MemberHandler() %p\n",this);
		addEndHandler("memberdef", this, "endMember");

		addStartHandler("templateparamlist", this, "startTemplateParamList");
		addEndHandler("templateparamlist", this, "endTemplateParamList");

		addStartHandler("type", this, "startType");

		addStartHandler("definition", this, "startDefinition");
		addEndHandler("definition", this, "endDefinition");

		addStartHandler("argsstring", this, "startArgsString");
		addEndHandler("argsstring", this, "endArgsString");

		addStartHandler("name", this, "startName");
		addEndHandler("name", this, "endName");

		addStartHandler("read", this, "startRead");
		addEndHandler("read", this, "endRead");

		addStartHandler("write", this, "startWrite");
		addEndHandler("write", this, "endWrite");

		addStartHandler("reimplements", this, "startReimplements");
		addEndHandler("reimplements", this, "endReimplements");

		addStartHandler("reimplementedby", this, "startReimplementedBy");
		addEndHandler("reimplementedby", this, "endReimplementedBy");

		addStartHandler("param", this, "startParam");

		addStartHandler("enumvalue", this, "startEnumValue2");
		addEndHandler("enumvalue", this, "endMember");

		addStartHandler("initializer", this, "startInitializer");
		addStartHandler("exceptions", this, "startException");

		addStartHandler("briefdescription", this, "startBriefDesc");

		addStartHandler("detaileddescription", this, "startDetailedDesc");

		addStartHandler("inbodydescription", this, "startInbodyDesc");

		addStartHandler("location", this, "startLocation");
		addEndHandler("location");

		addStartHandler("references", this, "startReferences");
		addEndHandler("references", this, "endReferences");

		addStartHandler("referencedby", this, "startReferencedBy");
		addEndHandler("referencedby", this, "endReferencedBy");

		m_reimplements = null;
		m_linkedTextHandler = null;
		m_defLine = 0;
		m_bodyStart = 0;
		m_bodyEnd = 0;
		m_insideTemplateParamList = false;
		m_hasTemplateParamList = false;
	}

	public void startMember(Attributes attrib) {
		m_parent.setDelegate(this);
		m_kindString = attrib.getValue("kind");
		// printf("startMember kindString=`%s'\n",m_kindString);
		m_kind = s_typeMap.map(m_kindString);
		m_id = attrib.getValue("id");
		m_protection = attrib.getValue("prot");
		m_isStatic = "yes".equals(attrib.getValue("static"));
		m_isConst = "yes".equals(attrib.getValue("const"));
		m_isExplicit = "yes".equals(attrib.getValue("explicit"));
		m_isInline = "yes".equals(attrib.getValue("inline"));
		m_virtualness = attrib.getValue("virt");
		m_isVolatile = "yes".equals(attrib.getValue("volatile"));
		m_isMutable = "yes".equals(attrib.getValue("mutable"));
		m_isReadable = "yes".equals(attrib.getValue("readable"));
		m_isWritable = "yes".equals(attrib.getValue("writable"));

		Log.debug(2, "member kind=`%s' id=`%s' prot=`%s' virt=`%s'\n", m_kindString, m_id, m_protection, m_virtualness);
	}

	public void startEnumValue(Attributes attrib) {
		m_parent.setDelegate(this);
		m_kindString = "enumvalue";
		// printf("startEnumValue kindString=`%s'\n",m_kindString);
		m_kind = s_typeMap.map(m_kindString);
		m_id = attrib.getValue("id");
		m_protection = attrib.getValue("prot");
		m_isStatic = false;
		m_isConst = false;
		m_isExplicit = false;
		m_isInline = false;
		m_virtualness = "non-public";
		m_isVolatile = false;
		m_isMutable = false;
		m_isReadable = false;
		m_isWritable = false;
		Log.debug(2, "member kind=`%s' id=`%s' prot=`%s' virt=`%s'\n", m_kindString, m_id, m_protection, m_virtualness);
	}

	public void startEnumValue2(Attributes attrib) {
		MemberHandler mh = new MemberHandler(this);
		mh.startEnumValue(attrib);
		m_enumValues.add(mh);
	}

	public void startBriefDesc(Attributes attrib) {
		DocHandler docHandler = new DocHandler(this);
		docHandler.startDoc(attrib);
		m_brief = docHandler;
	}

	public void startDetailedDesc(Attributes attrib) {
		DocHandler docHandler = new DocHandler(this);
		docHandler.startDoc(attrib);
		m_detailed = docHandler;
	}

	public void startInbodyDesc(Attributes attrib) {
		DocHandler docHandler = new DocHandler(this);
		docHandler.startDoc(attrib);
		m_inbody = docHandler;
	}

	public void startLocation(Attributes attrib) {
		m_defFile = attrib.getValue("file");
		m_bodyFile = attrib.getValue("bodyfile");
		String s;
		s = attrib.getValue("line");
		m_defLine = StringDecode.toInt(s, 0);
		s = attrib.getValue("bodystart");
		m_bodyStart = StringDecode.toInt(s, 0);
		s = attrib.getValue("bodyend");
		m_bodyEnd = StringDecode.toInt(s, 0);
	}

	public void startReferences(Attributes attrib) {
		MemberReference mr = new MemberReference();
		mr.m_memId = attrib.getValue("refid");
		m_references.add(mr);
		m_curString = "";
	}

	public void endReferences() {
		m_references.get(m_references.size() - 1).m_name = m_curString;
	}

	public void startReferencedBy(Attributes attrib) {
		MemberReference mr = new MemberReference();
		mr.m_memId = attrib.getValue("refid");
		m_referencedBy.add(mr);
		m_curString = "";
	}

	public void endReferencedBy() {
		m_referencedBy.get(m_referencedBy.size() - 1).m_name = m_curString;
	}

	public void startReimplements(Attributes attrib) {
		m_reimplements = new MemberReference();
		m_reimplements.m_memId = attrib.getValue("refid");
		m_curString = "";
	}

	public void endReimplements() {
		m_reimplements.m_name = m_curString;
	}

	public void startReimplementedBy(Attributes attrib) {
		MemberReference mr = new MemberReference();
		mr.m_memId = attrib.getValue("refid");
		m_reimplementedBy.add(mr);
		m_curString = "";
	}

	public void endReimplementedBy() {
		m_reimplementedBy.get(m_reimplementedBy.size() - 1).m_name = m_curString;
	}

	public void endMember() {
		m_parent.setDelegate(null);
	}

	public void startType(Attributes attrib) {
		Log.debug(2, "startType!\n");

		m_linkedTextHandler = new LinkedTextHandler(this, m_type);
		m_linkedTextHandler.start("type");
	}

	public void startInitializer(Attributes attrib) {
		Log.debug(2, "startInitializer!\n");

		m_linkedTextHandler = new LinkedTextHandler(this, m_initializer);
		m_linkedTextHandler.start("initializer");
	}

	public void startException(Attributes attrib) {
		Log.debug(2, "startException!\n");

		m_linkedTextHandler = new LinkedTextHandler(this, m_exception);
		m_linkedTextHandler.start("exceptions");
	}

	public void startName(Attributes attrib) {
		m_curString = "";
	}

	public void endName() {
		m_name = m_curString.trim();
		Log.debug(2, "member name=`%s'\n", m_name);
	}

	public void startRead(Attributes attrib) {
		m_curString = "";
	}

	public void endRead() {
		m_read = m_curString.trim();
		Log.debug(2, "member read=`%s'\n", m_read);
	}

	public void startWrite(Attributes attrib) {
		m_curString = "";
	}

	public void endWrite() {
		m_write = m_curString.trim();
		Log.debug(2, "member write=`%s'\n", m_write);
	}

	public void startDefinition(Attributes attrib) {
		m_curString = "";
	}

	public void endDefinition() {
		m_definition = m_curString.trim();
		Log.debug(2, "definition=%s\n", m_definition);
	}

	public void startArgsString(Attributes attrib) {
		m_curString = "";
	}

	public void endArgsString() {
		m_argsstring = m_curString.trim();
		Log.debug(2, "arggstring=%s\n", m_argsstring);
	}

	public void startParam(Attributes attrib) {
		ParamHandler paramHandler = new ParamHandler(this);
		paramHandler.startParam(attrib);
		if (m_insideTemplateParamList) {
			m_templateParams.add(paramHandler);
		} else {
			m_params.add(paramHandler);
		}
	}

	public void startTemplateParamList(Attributes attrib) {
		m_insideTemplateParamList = true;
		m_hasTemplateParamList = true;
	}

	public void endTemplateParamList() {
		m_insideTemplateParamList = false;
	}

	public void initialize(MainHandler mh) {

		for (MemberReference mr : m_references) {
			mr.initialize(mh);
		}

		for (MemberReference mr : m_referencedBy) {
			mr.initialize(mh);
		}

		for (MemberReference mr : m_reimplementedBy) {
			mr.initialize(mh);
		}

		if (m_reimplements != null)
			m_reimplements.initialize(mh);

	}

	public void setCompoundHandler(CompoundHandler c) {
		m_compound = c;
	}

	public ICompound compound() {
		return m_compound.toICompound();
	}

	public void setSectionHandler(SectionHandler c) {
		m_section = c;
	}

	public ISection section() {
		return m_section;
	}

	public IMemberIterator enumValues() {
		return new MemberIterator(m_enumValues);
	}

	public ILinkedTextIterator type() {
		return new LinkedTextIterator(m_type);
	}

	public String typeString() {
		MemberHandler that = (MemberHandler) this;
		that.m_typeString = LinkedTextHandler.toString(m_type);
		return m_typeString;
	}

	public IParamIterator parameters() {
		return new ParamIterator(m_params);
	}

	public IParamIterator templateParameters() {
		return m_hasTemplateParamList ? new ParamIterator(m_templateParams) : null;
	}

	public IMemberReferenceIterator references() {
		return new MemberReferenceIterator(m_references);
	}

	public IMemberReferenceIterator referencedBy() {
		return new MemberReferenceIterator(m_referencedBy);
	}

	public ILinkedTextIterator initializer() {
		return new LinkedTextIterator(m_initializer);
	}

	public ILinkedTextIterator exceptions() {
		return new LinkedTextIterator(m_exception);
	}

	public IMemberReferenceIterator reimplementedBy() {
		return new MemberReferenceIterator(m_reimplementedBy);
	}

	public IDocRoot briefDescription() {
		return m_brief;
	}

	public IDocRoot detailedDescription() {
		return m_detailed;
	}

	public IDocRoot inbodyDescription() {
		return m_inbody;
	}

	public MemberKind kind() {
		return m_kind;
	}

	public String kindString() {
		return m_kindString;
	}

	public String id() {
		return m_id;
	}

	public String protection() {
		return m_protection;
	}

	public String virtualness() {
		return m_virtualness;
	}

	public String name() {
		return m_name;
	}

	public String readAccessor() {
		return m_read;
	}

	public String writeAccessor() {
		return m_write;
	}

	public String definition() {
		return m_definition;
	}

	public String argsstring() {
		return m_argsstring;
	}

	public boolean isConst() {
		return m_isConst;
	}

	public boolean isVolatile() {
		return m_isVolatile;
	}

	public boolean isStatic() {
		return m_isStatic;
	}

	public boolean isExplicit() {
		return m_isExplicit;
	}

	public boolean isInline() {
		return m_isInline;
	}

	public boolean isMutable() {
		return m_isMutable;
	}

	public boolean isReadable() {
		return m_isReadable;
	}

	public boolean isWritable() {
		return m_isWritable;
	}

	public String bodyFile() {
		return m_bodyFile;
	}

	public int bodyStart() {
		return m_bodyStart;
	}

	public int bodyEnd() {
		return m_bodyEnd;
	}

	public String definitionFile() {
		return m_defFile;
	}

	public int definitionLine() {
		return m_defLine;
	}

	public IMemberReference reimplements() {
		return m_reimplements;
	}

}