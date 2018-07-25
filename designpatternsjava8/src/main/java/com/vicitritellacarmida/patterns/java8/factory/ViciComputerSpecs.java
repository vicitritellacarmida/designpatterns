package com.vicitritellacarmida.patterns.java8.factory;

import java.util.Optional;
import java.util.stream.IntStream;

public class ViciComputerSpecs {
	
	private int cores;
	
	private int disks;
	
	private long memory;


	
	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + cores;
		result = prime * result + disks;
		result = prime * result + (int) (memory ^ (memory >>> 32));
		return result;*/
		return IntStream.of(cores, disks, (int)(memory^(memory>>>32))).reduce(1,(hashcode, field) -> 31 * hashcode + field);
	}



	@Override
	public boolean equals(Object obj) {
		/*if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViciComputerSpecs other = (ViciComputerSpecs) obj;
		if (cores != other.cores)
			return false;
		if (disks != other.disks)
			return false;
		if (memory != other.memory)
			return false;
		return true;*/
		return Optional.ofNullable(obj)
				.filter(o -> this.getClass() == o.getClass())
				.map(Object::hashCode)
				.map(Integer.valueOf(hashCode())::equals)
				.orElse(Boolean.FALSE);
	}



	@Override
	public String toString() {
		return "ViciComputerSpecs [cores=" + cores + ", disks=" + disks + ", memory=" + memory + "]";
	}



	public int getCores() {
		return cores;
	}



	public int getDisks() {
		return disks;
	}



	public long getMemory() {
		return memory;
	}


	private ViciComputerSpecs(ComputerSpecsBuilder builder) {
		this.cores = builder.cores;
		this.disks = builder.disks;
		this.memory = builder.memory;
	}
	
	public static class ComputerSpecsBuilder{
		private int cores = 1;
		private int disks = 1;
		private long memory = 2;
		
		public ComputerSpecsBuilder withCores(int cores) {
			this.cores = cores;
			return this;
		}
		
		public ComputerSpecsBuilder withDisks(int disks) {
			this.disks = disks;
			return this;
		}

		public ComputerSpecsBuilder withMemory(long memory) {
			this.memory = memory;
			return this;
		}
		
		public ViciComputerSpecs build() {
			return new ViciComputerSpecs(this);
		}
		
		public ComputerSpecsBuilder initFromSpec(ViciComputerSpecs specs) {
			this.cores = specs.getCores();
			this.disks = specs.getDisks();
			this.memory = specs.getMemory();
			return this;
		}
		
		public static ViciComputerSpecs buildStandardSpec() {
			return new ComputerSpecsBuilder()
					.withCores(4)
					.withDisks(2)
					.withMemory(8)
					.build();
		}
		
		public static ViciComputerSpecs buildExtendedSpec() {
			return new ComputerSpecsBuilder()
					.withCores(8)
					.withDisks(4)
					.withMemory(16)
					.build();
		}
	}

}
