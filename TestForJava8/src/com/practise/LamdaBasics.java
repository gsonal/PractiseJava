package com.practise;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import com.practise.tddstreams.Person;

//As per Java Brains tutorial
public class LamdaBasics {

	
	public static void main(String args[]) {
		//aBlockOfCode = () -> System.out.println("Hello World!!!");
		
		//printGreeting(() -> System.out.println("Hello World!!!"));
		
		
		addFunction addition = (int x, int y) -> {
			return (x+y);
		};
		
		//As long as return type and parameter types matches, same interface can be reused for defining any lambda expression
		addFunction subtraction = (int x, int y) -> x - y;
		
		addFunction safeDivision = (x, y) -> {
			if(y != 0) {
				return (x / y);
			}
			return 0;
		};
		
		System.out.println(addition.add(4, 2));
		System.out.println(subtraction.add(4, 2));
		System.out.println(safeDivision.add(4, 2));
		
		printOutput((x, y) -> x+y);
		
		//print names beginning with C
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Charles", 46));
		persons.add(new Person("John", 53));
		persons.add(new Person("Charlie", 38));
		
		List<Person> newListOfPerons = persons.stream()
		.filter(p -> p.getName().startsWith("C"))
		.collect(toList());	
		
		printList(newListOfPerons);
		
		//sort persons list - desc order of Name
		printList(persons.stream()
				.sorted((p1, p2) -> p2.getName().compareTo(p1.getName()))
				.collect(toList()));
		
	}
	
	public static void printOutput(addFunction foo) {
		System.out.println(foo.add(4, 2));
	}
	
	private static void printList(List<Person> people) {
		people.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
	}

}

//A functional interface must have exactly one abstract method
@FunctionalInterface
interface addFunction {
	int add(int a, int b);
}

