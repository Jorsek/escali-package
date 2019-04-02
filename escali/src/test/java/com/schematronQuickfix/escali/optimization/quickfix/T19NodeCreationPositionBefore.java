package com.schematronQuickfix.escali.optimization.quickfix;

import com.schematronQuickfix.escali.control.Config;
import com.schematronQuickfix.escali.quickfix.FixingTestBase;
import org.junit.Test;

public class T19NodeCreationPositionBefore extends FixingTestBase {



	@Override
	public String getFolder() {
		return "../test19-node-creation-position-before";
	}


	@Override
	public String getSchemaPath() {
		return "input/node-creation-position-before.sch";
	}
	@Override
	public String getInstancePath() {
		return "input/node-creation-position-before.xml";
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
	public void test(){
		doTest(new ExecutionSetup(1, "addBaz"));
		
	}
	
}
