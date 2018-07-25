package com.vicitritellacarmida.patterns.java8.factory;

import java.util.Optional;

import com.vicitritellacarmida.patterns.java8.factory.ViciComputerSpecs.ComputerSpecsBuilder;

public class ViciServerComputer extends ViciComputer{

	public ViciServerComputer() {
		super(ComputerSpecsBuilder.buildExtendedSpec());
	}
	
	public ViciServerComputer(ViciComputerSpecs spec) {
		super(Optional.ofNullable(spec).orElseGet(ComputerSpecsBuilder::buildExtendedSpec));
	}
	
}
