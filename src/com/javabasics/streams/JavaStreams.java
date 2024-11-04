package com.javabasics.streams;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class JavaStreams {

	// Count the number of names starting with alphabet K in list

	@Test
	public void regularWay() {

		List<String> nameStrings = new ArrayList<String>();

		int count = 0;

		nameStrings.add("Suja");

		nameStrings.add("Kankana");

		nameStrings.add("Nimesh");

		nameStrings.add("Krishanu");

		for (int i = 0; i < nameStrings.size(); i++) {
			String actualString = nameStrings.get(i);
			if (actualString.startsWith("K")) {
				count++;
			}
		}
		System.out.println("Using regular way: " + count);
	}

	@Test
	public void optimizedWay() {
		
		List<String> nameStrings = new ArrayList<String>();

		nameStrings.add("Suja");

		nameStrings.add("Kankana");

		nameStrings.add("Nimesh");

		nameStrings.add("Krishanu");

		Long count = nameStrings.stream().filter(s -> s.startsWith("K")).count();

		System.out.println("Using optimized way: " + count);
	}

}
