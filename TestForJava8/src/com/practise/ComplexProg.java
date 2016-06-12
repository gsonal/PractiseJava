package com.practise;

import java.util.List;
import java.util.function.Predicate;

public class ComplexProg {

	/*private void psvm() {
		List persons = populatePersons();

		// print all persons using lambdas
		persons.forEach( ( s ) -> {
		    System.out.println( s );
		} );

		// using an instantiated predicate
		Predicate spanish = p -> {
		    return Country.SPAIN.equals( p.getCountry() );
		};
		persons.stream().filter( spanish ).forEach( ( person ) -> {
		    System.out.println( person );
		} );

		// using Lambdas directly for filtering the spanish ones
		persons.stream().filter( person -> {
		    return Country.SPAIN.equals( person.getCountry() );
		} ).forEach( ( eachPerson ) -> {
		    System.out.println( eachPerson );
		} );

		// using Lambdas directly for filtering the chinesse ones that love to eat
		persons.stream().filter( person -> {
		    return Country.CHINA.equals( person.getCountry() ) && Hobbie.EAT.equals( person.getFavouriteAction() );
		} ).forEach( ( eachPerson ) -> {
		    System.out.println( eachPerson );
		} );

		// using Lambdas directly for filtering the chinesse ones that love to eat
		persons.stream().filter( person -> {
		    return Country.CHINA.equals( person.getCountry() ) && Hobbie.EAT.equals( person.getFavouriteAction() );
		} ).forEach( ( eachPerson ) -> {
		    System.out.println( eachPerson );
		} );

		Predicate germans = person -> {
		    return Country.GERMANY.equals( person.getCountry() );
		};

		Predicate dancers = person -> {
		    return Hobbie.DANCE.equals( person.getFavouriteAction() );
		};

		// combining different predicates is also possible
		persons.stream().filter( germans.and( dancers ) ).forEach( ( eachPerson ) -> {
		    System.out.println( eachPerson );
		} );

		// using streams and filters is possible to get statistics directly like number of Persons
		// based of different criteria
		persons.stream().filter( germans.and( dancers ) ).count();

		// oldest person
		System.out.println( "oldest one: "
		    + persons.stream().filter( germans.and( dancers ) ).max( ( p1, p2 ) -> p1.getAge() - p2.getAge() ) );    

	}*/
}
