package com.schematronQuickfix.escali.optimization.quickfix;

import com.schematronQuickfix.escali.control.Config;
import com.schematronQuickfix.escali.quickfix.FixingTestBase;
import org.junit.Test;

public class T52NsTriggersNullNsDecl extends FixingTestBase {

	@Override
	public String getFolder() {
		return "../test52-ns-triggers-null-ns-decl";
	}


	@Override
	public String getSchemaPath() {
		return "input/ns-triggers-null-ns-decl.sch";
	}

	@Override
	public String getInstancePath() {
		return "input/ns-triggers-null-ns-decl.xml";
	}


	@Override
	public Config getConfig() {
		Config config = super.getConfig();
		config.setInternalValidation(false);
		return config;
	}

	@Override
	public String getExpectedPrefix() {
		return "expected";
	}

	@Test
	public void test_1(){
		doTest(new ExecutionSetup(1, "replaceBar"));
	}
	
}