package com.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PractiseJava8 {

	public static void main(String[] args) {
		/*List<String> myList = new ArrayList<>();
        myList.add("Hello java");
        myList.add("See Java world");
        myList.add("Java 8");
        
        //myList.forEach(System.out::println);
        myList.stream()
            .filter(string -> string.contains("Java"))
            .forEach(System.out::println);
        
        List<Integer> sizes = myList.stream().map(value -> value.length()).collect(Collectors.toList());
        System.out.println(sizes);

        
        Collections.sort(myList, ((s1, s2) -> s1.compareTo(s2)));
        myList.stream().forEach(System.out::println);*/
        
       /* int x=0, y=10, z=0;
        
        z=y/x;
        System.out.println("division by 0");*/
        
		int []a = {1,2,3};
		System.out.print(a instanceof Object);
	}

	
}
