package com.schematronQuickfix.escali.optimization.quickfix;

import com.schematronQuickfix.escali.control.Config;
import com.schematronQuickfix.escali.quickfix.FixingTestBase;
import org.junit.Test;

public class T42CallFixGlobalPendings extends FixingTestBase {

	@Override
	public String getFolder() {
		return "../test42-call-fix-global-pendings";
	}


	@Override
	public String getSchemaPath() {
		return "input/call-fix-global-pendings.sch";
	}

	@Override
	public String getInstancePath() {
		return "input/call-fix-global-pendings.xml";
	}

	@Override
	public Config getConfig() {
		Config config = super.getConfig();
		return config;
	}

	@Override
	public String getExpectedPrefix() {
		return "expected";
	}

	@Test
	public void test(){
		doTest(new ExecutionSetup(1, "addChilds"));
		
	}

}
