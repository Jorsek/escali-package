<?xml version="1.0" encoding="UTF-8"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2"
    xmlns:sqf="http://www.schematron-quickfix.com/validator/process">
    <sch:title>Schematron unit test - trivial delete</sch:title>
    <sch:pattern id="pattern1">
        <sch:rule context="foo">
            <sch:assert test=". != ''" sqf:fix="deleteFoo">Foo should not be empty.</sch:assert>
            <sqf:fix id="deleteFoo">
                <sqf:description>
                    <sqf:title>Delete foo</sqf:title>
                </sqf:description>
                <sqf:delete/>
            </sqf:fix>
        </sch:rule>
    </sch:pattern>
</sch:schema>