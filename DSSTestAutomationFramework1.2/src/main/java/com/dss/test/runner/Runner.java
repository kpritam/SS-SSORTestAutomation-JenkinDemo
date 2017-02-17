package com.dss.test.runner;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class Runner {

	public void mainTest() throws Exception {
		List<XmlSuite> suites = XmlGenerator.createXML("SS,STAGE,CHFF,WINDOWS,RG");
		System.out.println("total suites = " + suites.size());
		int i = 1;
		for (XmlSuite each : suites) {
			File file = new File("TestNGRunTime" + i + ".xml");
			System.out.println("file" + file);
			FileWriter writer = new FileWriter(file);
			writer.write(each.toXml());
			writer.close();
			i++;

		}
		TestNG test = new TestNG();
		test.setXmlSuites(suites);
		test.run();
	}

}
