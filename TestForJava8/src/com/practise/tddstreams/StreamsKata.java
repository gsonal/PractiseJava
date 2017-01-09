package com.practise.tddstreams;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

public class StreamsKata {

	public List<String> convertToUpper(List<String> inputList) {
		return inputList.stream() // Convert collection to Stream
                .map(String::toUpperCase) // Convert each element to upper case
                .collect(toList()); // Collect results to a new list
	}

	public List<String> filterThreeCharWords(List<String> input) {
		return input.stream()
				.filter(term -> term.length() < 4)
				.collect(toList());
	}

	public List<String> joinCollection(List<List<String>> listOfLists) {
		return listOfLists.stream()
				.flatMap(value -> value.stream())
				.collect(toList());
	}

	public Person getOldestPerson(List<Person> persons) {
		return persons.stream()
				.max(Comparator.comparing(Person::getAge))
				.get();
	}

	public String getYoungestPerson(List<Person> persons) {
		return persons.stream()
				.min(Comparator.comparing(Person::getAge))
				.get().getName();
	}

	public Integer calculateSum(List<Integer> numbers) {
		return numbers.stream()
				.reduce(0, (total, eachNumber) -> total + eachNumber);
	}

	public List<String> getKidNames(List<Person> persons) {
		return persons.stream()
				.filter(person -> person.getAge() < 18)
				.map(Person::getName)
				.collect(toList());
	}

	public IntSummaryStatistics getStats(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .summaryStatistics();
    }

	public Map<Boolean, List<Person>> partitionAdults(List<Person> persons) {
		return persons.stream()
				.collect(partitioningBy(person -> person.getAge() >= 18));
	}

	public String namesToString(List<Person> persons) {
		return persons.stream()
				.map(person -> person.getName())
				.collect(joining(", ", "Names: ", ".")); // joining(delimiter, prefix, suffix)
	}

}
