package streams;

import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("John", MALE),
				new Person("Maria", FEMALE),
				new Person("Aisha", FEMALE),
				new Person("Alex", MALE)
//				new Person("Alice", PREFER_NOT_TO_SAY)
		);

		System.out.println("---------");
		System.out.println("Gender");
		System.out.println("---------");
		people.stream()
				.map(person -> person.gender)
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		System.out.println("---------");
		System.out.println("Name");
		System.out.println("---------");
		people.stream()
				.map(person -> person.name)
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		System.out.println("---------");
		System.out.println("Length");
		System.out.println("---------");

		people.stream()
				.map(person -> person.name)
				.mapToInt(String::length)
				.forEach(System.out::println);

		System.out.println("---------");
		System.out.println("All Match");
		System.out.println("---------");

		boolean containsOnlyFemales = people.stream()
				.allMatch(person -> FEMALE.equals(person.gender));

		System.out.println(containsOnlyFemales);


		System.out.println("---------");
		System.out.println("None Match");
		System.out.println("---------");

		boolean doesNotContainGender = people.stream()
				.noneMatch(person -> PREFER_NOT_TO_SAY.equals(person.gender));

		System.out.println(doesNotContainGender);

	}

	static class Person {
		private final String name;
		private final Gender gender;

		Person(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", gender=" + gender +
					'}';
		}
	}

	enum Gender {
		MALE, FEMALE, PREFER_NOT_TO_SAY
	}

}
