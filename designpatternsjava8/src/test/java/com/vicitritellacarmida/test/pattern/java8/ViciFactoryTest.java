package com.vicitritellacarmida.test.pattern.java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vicitritellacarmida.patterns.java8.factory.ViciComputer;
import com.vicitritellacarmida.patterns.java8.factory.ViciComputerFactory;
import com.vicitritellacarmida.patterns.java8.factory.ViciComputerSpecs;
import com.vicitritellacarmida.patterns.java8.factory.ViciComputerSpecs.ComputerSpecsBuilder;
import com.vicitritellacarmida.patterns.java8.factory.ViciComputer.ComputerModel;

@Test(enabled = true)
public class ViciFactoryTest {

	private static final Logger LOG = LoggerFactory.getLogger(ViciFactoryTest.class);
	
	public void createHomeComputer() {
		ViciComputer computer = ViciComputerFactory.create(ComputerModel.HOME);
		ViciComputerSpecs spec = computer.getSpecs();
		ViciComputerSpecs stdSpec = ComputerSpecsBuilder.buildStandardSpec();
		System.out.println(spec.getCores()+" "+stdSpec.getCores());
		Assert.assertEquals(spec, stdSpec, "Unexpected specs");
	}
	
	public void createServerComputerLambda() {
		ViciComputer computer = ViciComputerFactory.createLambda(ComputerModel.SERVER);
		ViciComputerSpecs spec = computer.getSpecs();
		ViciComputerSpecs exSpec = ComputerSpecsBuilder.buildExtendedSpec();
		System.out.println(spec.getCores()+" "+exSpec.getCores());
		Assert.assertEquals(spec, exSpec,
				"Unexpected specs");
	}

}
