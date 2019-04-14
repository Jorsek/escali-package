package com.schematronQuickfix.escali.optimization.quickfix;

import com.schematronQuickfix.escali.control.Config;
import com.schematronQuickfix.escali.quickfix.FixingTestBase;
import org.junit.Test;

public class T05BasicUserentry extends FixingTestBase {



    @Override
	public String getFolder() {
		return "../test05-basic-userentry";
	}


	@Override
	public String getSchemaPath() {
		return "input/basic-userentry.sch";
	}

	@Override
	public String getInstancePath() {
		return "input/basic-userentry.xml";
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
		doTest(new ExecutionSetup(1, "addBar")
				.addUE("element", "USERENTRY_element")
		);
		
	}

	@Test
	public void test2(){
		doTest(new ExecutionSetup(1, "global_addBar")
				.addUE("element", "USERENTRY_element")
		);

	}
	
}
