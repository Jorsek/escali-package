<?xml version="1.0" encoding="UTF-8"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2" xmlns:sqf="http://www.schematron-quickfix.com/validator/process" xml:lang="en">
    <sch:pattern>
        <sch:rule context="*">
            <sch:assert test="true()" xml:lang="en" diagnostics="diagn1_de diagn1_fr">Error message.</sch:assert>
            
        </sch:rule>
    </sch:pattern>
    <sch:pattern>
        <sch:rule context="*">
            <sch:assert test="true()" xml:lang="en" diagnostics="diagn2_de diagn2_fr" sqf:fix="fixId1 fixId2">Error message 2.</sch:assert>
            <sqf:fix id="fixId1">
                <sqf:description>
                    <sqf:title>QuickFix description 1</sqf:title>
                </sqf:description>
            </sqf:fix>
            <sqf:fix id="fixId2">
                <sqf:description>
                    <sqf:title ref="fixDesc2_de fixDesc2_fr">QuickFix description 2</sqf:title>
                </sqf:description>
            </sqf:fix>
        </sch:rule>
    </sch:pattern>
    <sch:diagnostics>
        <sch:diagnostic id="diagn1_de" xml:lang="de">Fehlermeldung 1</sch:diagnostic>
        <sch:diagnostic id="diagn2_de" xml:lang="de">Fehlermeldung 2</sch:diagnostic>
        
        <sch:diagnostic id="fixDesc2_de" xml:lang="de">QuickFix Beschreibung 2</sch:diagnostic>
        
        <sch:diagnostic id="diagn1_fr" xml:lang="fr">Message d'erreur 1</sch:diagnostic>
        <sch:diagnostic id="diagn2_fr" xml:lang="fr">Message d'erreur 2</sch:diagnostic>
        <sch:diagnostic id="fixDesc2_fr" xml:lang="fr">Description de QuickFix 2</sch:diagnostic>
        
    </sch:diagnostics>
</sch:schema>
