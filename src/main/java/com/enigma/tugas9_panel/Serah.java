package com.enigma.tugas9_panel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Serah {

	public static void main(String[] args) {
		Set<String> uji = new HashSet<String>();
		List<String> A = new ArrayList<String>();
		List<String> B = new ArrayList<String>();
		List<String> C = new ArrayList<String>();

		A.add("(0,0) ");
		A.add("(0,1) ");
		A.add("(0,2) ");
		A.add("(0,4) ");
		B.add("(0,1) ");
		B.add("(0,2) ");
		B.add("(0,6) ");
		B.add("(0,7) ");

		System.out.println();
		for (String string : A) {
			System.out.print(string + " ");
		}
		System.out.println();
		for (String string : B) {
			System.out.print(string + " ");
		}

		C = A;
		System.out.println();
		C.retainAll(B);
		System.out.println(A);
		System.out.println(B);
	}

}
