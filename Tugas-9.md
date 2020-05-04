# Case
Sebuah antena pada bidang kartesian dapat mengcover area sekelilingnya 1 area. Aplikasi akan mencatat semua area yang dicover oleh 2 atau lebih antena.

## Sample input
```text
Banyak antena = 3
Antenna-1
Input coordinat X : 1
Input coordinat Y : 1

Antenna-2
Input coordinat X : 0
Input coordinat Y : 0

Antenna-3
Input coordinat X : 2
Input coordinat Y : 2
```

## Sample output
```text
Multiple coverage area : (1,2) (1,1) (2,1) (2,2) (0,1) (1,0) (0,0) 
```

## Code
### Main
```java
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
```
### Class object antenna
```java
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
```
### Class detector
```java
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
```