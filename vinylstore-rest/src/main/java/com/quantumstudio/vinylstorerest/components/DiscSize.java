package com.quantumstudio.vinylstorerest.components;

public enum  DiscSize {
	small (17.5),
	medium (20),
	large (25);

	private final double discSize;

	DiscSize(double discSize) {
		this.discSize = discSize;
	}
}
