package com.enigma.tugas9_panel;

import java.util.ArrayList;

public class Antenna {
	private Integer coordinatX;
	private Integer coordinatY;
	private ArrayList<String> area;

	public Antenna(Integer coordinatX, Integer coordinatY) {
		super();
		this.coordinatX = coordinatX;
		this.coordinatY = coordinatY;
		this.area = coveringArea();
	}

	public ArrayList<String> coveringArea() {
		ArrayList<String> area = new ArrayList<String>(9);
		for (int x = this.coordinatX - 1; x <= this.coordinatX + 1; x++) {
			for (int y = this.coordinatY + 1; y >= this.coordinatY - 1; y--) {
				area.add("(" + x + "," + y + ")");
			}
		}
		return area;
	}

	@Override
	public String toString() {
		String output = "";
		for (String i : area) {
			output += i + " ";
		}
		return output;
	}

}
