package com.schematronQuickfix.escali.optimization.schematron;

import com.schematronQuickfix.escali.control.Config;
import com.schematronQuickfix.escali.control.SVRLReport;
import com.schematronQuickfix.escali.schematron.ValidationTestBase;
import org.junit.Test;

public class T29ForeignLetinActionEl extends ValidationTestBase {



	@Override
	public String getFolder() {
		return "../test29-foreign-let-in-actionEl";
	}


	@Override
	public String getSchemaPath() {
		return "input/foreign-let-in-actionEl.sch";
	}

	@Override
	public String getInstancePath() {
		return "input/foreign-let-in-actionEl.xml";
	}

	@Override
	public Config getConfig() {
		Config config = super.getConfig();
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
