package com.vicitritellacarmida.patterns.java8.factory;

import java.util.EnumMap;
import java.util.function.Supplier;

import com.vicitritellacarmida.patterns.java8.factory.ViciComputer.ComputerModel;

public final class ViciComputerFactory {
	
	public static ViciComputer create(ComputerModel model) {
		ViciComputer computer = null;
		switch(model) {
		case HOME:
			computer = new ViciHomeComputer();
			break;
		case SERVER:
			computer = new ViciServerComputer();
			break;
		default:
			throw new IllegalStateException("Model " + model + " is not available yet!");
		}
		return computer;
	}
	
	private static final EnumMap<ComputerModel, Supplier<ViciComputer>> customComputers = new EnumMap<>(ComputerModel.class);

	static {
		customComputers.put(ComputerModel.HOME, ViciHomeComputer::new);
		customComputers.put(ComputerModel.SERVER, ViciServerComputer::new);
	}
	
	public static ViciComputer createLambda(ComputerModel model) {
		return customComputers.get(model).get();
	}
}
