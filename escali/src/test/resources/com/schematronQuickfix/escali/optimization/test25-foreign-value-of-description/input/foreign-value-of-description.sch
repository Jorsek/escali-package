<?xml version="1.0" encoding="UTF-8"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2"
    xmlns:sqf="http://www.schematron-quickfix.com/validator/process" xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <sch:title>Schematron unit test - basic replace</sch:title>
    <sch:pattern id="pattern1">
        <sch:rule context="foo">
            <sch:assert test=". != ''" sqf:fix="replaceFoo">Foo should not be empty.</sch:assert>
            <sqf:fix id="replaceFoo">
                <sqf:description>
                    <sqf:title>Replace <sch:value-of select="name()"/> by bar</sqf:title>
                </sqf:description>
                <sqf:replace node-type="element" target="baz" select="string(../bar)"/>
            </sqf:fix>
        </sch:rule>
    </sch:pattern>
</sch:schema>