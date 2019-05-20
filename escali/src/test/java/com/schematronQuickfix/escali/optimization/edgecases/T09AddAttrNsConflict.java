package com.schematronQuickfix.escali.optimization.edgecases;

import com.schematronQuickfix.escali.control.Config;
import com.schematronQuickfix.escali.quickfix.FixingTestBase;
import org.junit.Test;

public class T09AddAttrNsConflict extends FixingTestBase {



    @Override
	public String getFolder() {
		return "test09-add-attr-ns-conflict";
	}


	@Override
	public String getSchemaPath() {
		return "input/add-attr-ns-conflict.sch";
	}

	@Override
	public String getInstancePath() {
		return "input/add-attr-ns-conflict.xml";
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
	public void test_1(){
		doTest(new ExecutionSetup(1, "addAttr"));
	}

}
