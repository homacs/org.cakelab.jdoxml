


function DEFINE_CLS_IMPL () {
	name=$1
	file=${name}.java
	
	rm -f $file

#cat > $file <<EOF
#package org.cakelab.doxml.impl.dochandler;#
#
#import org.cakelab.doxml.api.I${name};
#
#public class ${name}Impl extends DocImpl implements I${name} {
#}
#EOF

}


DEFINE_CLS_IMPL "DocPara"
DEFINE_CLS_IMPL "DocText"
DEFINE_CLS_IMPL "DocMarkupModifier"
DEFINE_CLS_IMPL "DocItemizedList"
DEFINE_CLS_IMPL "DocOrderedList"
DEFINE_CLS_IMPL "DocListItem"
DEFINE_CLS_IMPL "DocParameterList"
DEFINE_CLS_IMPL "DocParameterItem"
DEFINE_CLS_IMPL "DocParameter"
DEFINE_CLS_IMPL "DocTitle"
DEFINE_CLS_IMPL "DocSimpleSect"
DEFINE_CLS_IMPL "DocRef"
DEFINE_CLS_IMPL "DocVariableList"
DEFINE_CLS_IMPL "DocVariableListEntry"
DEFINE_CLS_IMPL "DocHRuler"
DEFINE_CLS_IMPL "DocLineBreak"
DEFINE_CLS_IMPL "DocULink"
DEFINE_CLS_IMPL "DocEMail"
DEFINE_CLS_IMPL "DocLink"
DEFINE_CLS_IMPL "DocProgramListing"
DEFINE_CLS_IMPL "DocCodeLine"
DEFINE_CLS_IMPL "DocHighlight"
DEFINE_CLS_IMPL "DocFormula"
DEFINE_CLS_IMPL "DocImage"
DEFINE_CLS_IMPL "DocDotFile"
DEFINE_CLS_IMPL "DocIndexEntry"
DEFINE_CLS_IMPL "DocTable"
DEFINE_CLS_IMPL "DocRow"
DEFINE_CLS_IMPL "DocEntry"
DEFINE_CLS_IMPL "DocSection"
DEFINE_CLS_IMPL "DocVerbatim"
DEFINE_CLS_IMPL "DocCopy"
DEFINE_CLS_IMPL "DocTocList"
DEFINE_CLS_IMPL "DocTocItem"
DEFINE_CLS_IMPL "DocAnchor"
DEFINE_CLS_IMPL "DocSymbol"
DEFINE_CLS_IMPL "DocInternal"
DEFINE_CLS_IMPL "DocRoot"