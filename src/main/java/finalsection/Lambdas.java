package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
	public static void main(String[] args) {
		Function<String, String> upperCaseName = name -> name.toUpperCase();

		Function<String, String> logicUpperCaseName = name -> {
			//logic
			if (name.isBlank()) throw new IllegalArgumentException();
			return name.toUpperCase();
		};

		BiFunction<String, Integer, String> biFuctionLogicUpperCaseName = (name, age) -> {
			//logic
			if (name.isBlank()) throw new IllegalArgumentException();
			System.out.println(age);
			return name.toUpperCase();
		};

		System.out.println(biFuctionLogicUpperCaseName.apply("alex", 20));
	}
}
