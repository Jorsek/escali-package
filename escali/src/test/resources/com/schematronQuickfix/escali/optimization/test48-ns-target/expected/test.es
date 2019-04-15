<?xml version="1.0" encoding="UTF-8"?>
<es:escali-reports xmlns:es="http://www.escali.schematron-quickfix.com/"
    xml:base="file:/C:/Users/Nico/Work/Java2/escali-main-package/escali/target/test-classes/com/schematronQuickfix/escali/optimization/test01-trivial-delete/input/trivial-delete.xml" xmlns:sqf="http://www.schematron-quickfix.com/validator/process">
    <es:meta activePatterns="pattern1"
        instance="#IGNORED#"
        phase="#ALL"
        schema=""
        title="Schematron unit test - sch:ns in target attribute">
        <es:title>Schematron unit test - sch:ns in target attribute</es:title>
        <es:schema>#IGNORED#</es:schema>
        <es:instance>#IGNORED#</es:instance>
        <es:phase id="#ALL" isActive="yes" isDefault="true"/>
        <es:ns-prefix-in-attribute-values uri="foo.com" prefix="foo"/>
    </es:meta>
    <es:pattern>
        <es:meta id="pattern1" phases="#ALL"/>
        <es:rule>
            <es:meta context="foo:foo" id="w20aab3b1" roleLabel="error">
                <sqf:fix id="replaceBar">
                    <sqf:replace match="foo:bar" node-type="element" target="foo:baz" select="'baz-content'"/>
                </sqf:fix>
            </es:meta>
            <es:report id="w41aab1_w20aab3b1b1"
                location="/*:root[namespace-uri()='foo.com'][1]/*:foo[namespace-uri()='foo.com'][1]"
                roleLabel="error"
                test="foo:bar">
                <es:text>Foo should not contain bar.</es:text>
                <sqf:fix fixId="replaceBar" title="Replace bar by baz." id="replaceBar_w41aab1_w20aab3b1b1">
                    <sqf:call-fix ref="replaceBar"/>
                </sqf:fix>
            </es:report>
        </es:rule>
    </es:pattern>
</es:escali-reports>