package com.vicitritellacarmida.patterns.java8.factory;

public abstract class ViciComputer {
	
	public enum ComputerModel{
		HOME,SERVER;
	}
	
	protected ViciComputerSpecs specs;
	
	public ViciComputer(ViciComputerSpecs spec) {
		this.specs = spec;
	}

	public ViciComputerSpecs getSpecs() {
		return specs;
	}

	
}
