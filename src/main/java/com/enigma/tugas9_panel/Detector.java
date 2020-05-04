package com.enigma.tugas9_panel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Detector {

	public static String getCoverage(ArrayList<Antenna> antennas) {
		Set<String> coverage = new HashSet<String>();
		List<String> temp = new ArrayList<String>();
		String output = "";

		for (int i = 0; i < antennas.size() - 1; i++) {
			for (int j = i + 1; j < antennas.size(); j++) {

				temp.addAll(antennas.get(i).coveringArea());
				temp.retainAll(antennas.get(j).coveringArea());
				coverage.addAll(temp);
			}
		}

		System.out.print("\nMultiple coverage area : ");

		for (String antenna : coverage) {
			output += antenna + " ";
		}

		return output;
	}
}