<?xml version="1.0" encoding="UTF-8"?>
<es:escali-reports xmlns="http://www.w3.org/1999/xhtml" xmlns:sch="http://purl.oclc.org/dsdl/schematron" xmlns:sqf="http://www.schematron-quickfix.com/validator/process" xmlns:es="http://www.escali.schematron-quickfix.com/">
    <es:meta queryBinding="xslt2" title="Schematron unit test" phase="phase2"/>
    <es:pattern>
        <es:rule>
            <es:assert location="/*:root[namespace-uri()=''][1]/*:t2[namespace-uri()=''][1]/*:ph[namespace-uri()=''][1]/text()[1]" roleLabel="error" test="false()" substring="0 3">
                <es:text>Bad content: "bar"</es:text>
                <sqf:fix role="replace" fixId="replace" title='Replace "bar".'/>
                <sqf:fix role="delete" fixId="delete" title='Delete phrase.'/>
                <sqf:fix role="add" fixId="add" title='Add marker around the phrase.'/>
            </es:assert>
        </es:rule>
    </es:pattern>
</es:escali-reports>

