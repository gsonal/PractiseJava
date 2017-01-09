package com.practise.tddstreams;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/*
Katas from:
https://technologyconversations.com/2014/11/04/java-8-streams-micro-katas/
 */
public class StreamsKataShould {
	
	StreamsKata streamsKata;
	
	@Before
	public void doSetup() {
		streamsKata = new StreamsKata();
	}

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> inputWords = asList("My", "name", "is", "John", "Doe");
        List<String> expectedOutput = asList("MY", "NAME", "IS", "JOHN", "DOE");
        assertThat(streamsKata.convertToUpper(inputWords)).hasSameElementsAs(expectedOutput);
    }

    @Test
    public void transformShouldFilterCollection() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        assertThat(streamsKata.filterThreeCharWords(collection)).hasSameElementsAs(expected);
    }
    
    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertThat(streamsKata.joinCollection(collection)).hasSameElementsAs(expected);
    }
    
    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        List<Person> collection = getPersonsForTests();
        assertThat(streamsKata.getOldestPerson(collection)).isEqualToComparingFieldByField(new Person("Eva", 42));
    }
    
    @Test
    public void getYoungestPersonShouldReturnYoungestPerson() {
        List<Person> collection = getPersonsForTests();
        assertThat(streamsKata.getYoungestPerson(collection)).isEqualTo("Sara");
    }
    
    @Test
    public void transformShouldReturnSumOfAllNumbers() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        assertThat(streamsKata.calculateSum(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
    }
    
    @Test
    public void getKidNameShouldReturnNamesOfAllKids() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        assertThat(streamsKata.getKidNames(collection))
                .contains("Sara", "Anna")
                .doesNotContain("Viktor", "Eva");
    }
    
    @Test
    public void getStatsShouldReturnAverageAge() {
        assertThat(streamsKata.getStats(getPersonsForTests()).getAverage())
                .isEqualTo((double)(4 + 40 + 42) / 3);
        //getPersonsForTests().stream().iterator().forEachRemaining(action);
    }

    @Test
    public void getStatsShouldReturnNumberOfPeople() {
        assertThat(streamsKata.getStats(getPersonsForTests()).getCount())
                .isEqualTo(getPersonsForTests().stream()
                			.count()); //3
    }

    @Test
    public void getStatsShouldReturnMaximumAge() {
        assertThat(streamsKata.getStats(getPersonsForTests()).getMax())
                .isEqualTo(getPersonsForTests().stream()
	            			.max(Comparator.comparing(Person::getAge))
	            			.get().getAge()); //42
    }

    @Test
    public void getStatsShouldReturnMinimumAge() {
        assertThat(streamsKata.getStats(getPersonsForTests()).getMin())
                .isEqualTo(getPersonsForTests().stream()
                			.min(Comparator.comparing(Person::getAge))
                			.get().getAge()); //4
    }

    @Test
    public void getStatsShouldReturnSumOfAllAges() {
        assertThat((int) streamsKata.getStats(getPersonsForTests()).getSum())
                .isEqualTo(getPersonsForTests().stream()
                			.map(person->person.getAge())
                			.reduce(0, (sum, age)-> sum + age)); //40 + 42 + 4
    }
    
    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
    	Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
    	List<Person> collection = asList(sara, eva, viktor);
        Map<Boolean, List<Person>> result = streamsKata.partitionAdults(collection);
        assertThat(result.get(true)).hasSameElementsAs(asList(viktor, eva));
        assertThat(result.get(false)).hasSameElementsAs(asList(sara));
    }
    
    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        assertThat(streamsKata.namesToString(collection))
                .isEqualTo("Names: Sara, Viktor, Eva.");
    }
    
    private List<Person> getPersonsForTests() {
    	Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        return asList(sara, eva, viktor);
    }
    
}