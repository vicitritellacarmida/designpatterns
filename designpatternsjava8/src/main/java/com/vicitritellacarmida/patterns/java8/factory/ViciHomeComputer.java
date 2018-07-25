package com.vicitritellacarmida.patterns.java8.factory;

import java.util.Optional;

import com.vicitritellacarmida.patterns.java8.factory.ViciComputerSpecs.ComputerSpecsBuilder;

public class ViciHomeComputer extends ViciComputer{

	public ViciHomeComputer() {
		super(ComputerSpecsBuilder.buildStandardSpec());
	}
	
	public ViciHomeComputer(ViciComputerSpecs spec) {
		// ini artinya menjaga kalo spec nya nilai null jadi ga akan npe lagi. orelseget kalo ga dapeting nilai si optional, maka panggil method yg build standard spec
		super(Optional.ofNullable(spec).orElseGet(ComputerSpecsBuilder::buildStandardSpec));
	}
}
