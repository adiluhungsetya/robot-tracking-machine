package com.enigma.tugas9_panel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {
			System.out.print("Input the number of antenna : ");
			int totalAntenna = scan.nextInt();

			ArrayList<Antenna> antennas = new ArrayList<Antenna>(totalAntenna);

			for (int i = 0; i < totalAntenna; i++) {
				System.out.println("Antenna-" + (i + 1));
				System.out.print("Input coordinat X : ");
				int x = scan.nextInt();
				System.out.print("Input coordinat Y : ");
				int y = scan.nextInt();
				Antenna antenna = new Antenna(x, y);
				antennas.add(antenna);
				System.out.println(antenna.coveringArea() + "\n");
			}
			System.out.println(Detector.getCoverage(antennas));

		} catch (InputMismatchException e) {
			System.out.println("Input salah, masukkan angka! ");
		}
	}
}
