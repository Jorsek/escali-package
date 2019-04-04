package com.schematronQuickfix.escali.optimization.schematron;

import com.schematronQuickfix.escali.control.Config;
import com.schematronQuickfix.escali.control.SVRLReport;
import com.schematronQuickfix.escali.schematron.ValidationTestBase;
import org.junit.Test;

public class T30ForeignXslVariable extends ValidationTestBase {



	@Override
	public String getFolder() {
		return "../test30-foreign-xsl-variable";
	}


	@Override
	public String getSchemaPath() {
		return "input/foreign-xsl-variable.sch";
	}

	@Override
	public String getInstancePath() {
		return "input/foreign-xsl-variable.xml";
	}

	@Override
	public Config getConfig() {
		Config config = super.getConfig();
		config.setInternalValidation(false);
		return config;
	}

	@Override
	public String getFormat() {
		return SVRLReport.ESCALI_FORMAT;
	}

	@Test
	public void test(){
		doTest();
		
	}
	
}
