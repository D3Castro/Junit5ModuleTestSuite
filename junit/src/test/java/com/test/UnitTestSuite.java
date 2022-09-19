package com.test;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.test")
@IncludeClassNamePatterns({".*Test"})
public class UnitTestSuite {

}
