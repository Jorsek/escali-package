package com.schematronQuickfix.escali.optimization.edgecases;

import com.schematronQuickfix.escali.control.Config;
import com.schematronQuickfix.escali.quickfix.FixingTestBase;
import org.junit.Test;

public class T04DeprecatedSqfkeep extends FixingTestBase {



    @Override
	public String getFolder() {
		return "test04-deprecated-sqf-keep";
	}


	@Override
	public String getSchemaPath() {
		return "input/deprecated-sqf-keep.sch";
	}

	@Override
	public String getInstancePath() {
		return "input/deprecated-sqf-keep.xml";
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
		doTest(new ExecutionSetup(1, "unwrapBar"));
		
	}
	
}
