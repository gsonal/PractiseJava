package com.practise;

import java.util.HashMap;
import java.util.Map;

public class LambaExprnTest {
	 public static void main(String args[]){
		 LambaExprnTest tester = new LambaExprnTest();
			
	      //with type declaration
	      MathOperation addition = (int a, int b) -> a + b;
			
	      //with out type declaration
	      MathOperation subtraction = (a, b) -> a - b;
			
	      //with return statement along with curly braces
	      MathOperation multiplication = (int a, int b) -> { return a * b; };
			
	      //without return statement and without curly braces
	      MathOperation division = (int a, int b) -> a / b;
			
	      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
	      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
			
	      //with parenthesis
	      GreetingService greetService1 = message -> System.out.println("Hello " + message);
			
	      //without parenthesis
	      GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
			
	      greetService1.sayMessage("AAA");
	      greetService2.sayMessage("BBB");
	      
	      //iterate on collections
	      Map<Integer, String> testMap = new HashMap<>();
	      testMap.put(111, "First");
	      testMap.put(222, "Second");
	      testMap.put(333, "Third");
	      //for
	   }
		
	   interface MathOperation {
	      int operation(int a, int b);
	   }
		
	   interface GreetingService {
	      void sayMessage(String message);
	   }
		
	   private int operate(int a, int b, MathOperation mathOperation){
	      return mathOperation.operation(a, b);
	   }
}
