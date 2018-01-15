<?xml version="1.0" encoding="UTF-8"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2" xmlns:sqf="http://www.schematron-quickfix.com/validator/process" xml:lang="en">
    <sch:pattern xml:lang="en">
        <sch:rule context="*">
            <sch:assert test="true()" sqf:fix="fixId"> Assertion message. </sch:assert>

            <sqf:fix id="fixId">
                <sqf:description>
                    <sqf:title>QuickFix</sqf:title>
                </sqf:description>
            </sqf:fix>
        </sch:rule>
    </sch:pattern>
</sch:schema>
