package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

	public static void main(String[] args) {
		int increment = incrementByOne(0);
		System.out.println(increment);

		//Functional Style
		int increment2 = incrementByOneFunction.apply(2);

		System.out.println(increment2);

		int  multiply = multiplyBy10Function.apply(increment2);
		System.out.println(multiply);

		//And then allows you to link functions together
		Function<Integer, Integer> addByOneAndThenMultiplyByTen = incrementByOneFunction.andThen(multiplyBy10Function);
		System.out.println(addByOneAndThenMultiplyByTen.apply(4));

		//BiFunction
		System.out.println(incrementByOneAndMultiplyBiFunction.apply(4,100));



	}

	//Functions
	static int incrementByOne(int number) {
		return number + 1;
	}

	//Can be wrote as
	//value to take in, value to return
	static Function<Integer, Integer> incrementByOneFunction =
			number -> ++number;

	//And Then
	static Function<Integer, Integer> multiplyBy10Function =
			number -> number * 10;

	//BiFunction
	static int incrementByOneAndMultiply(int num, int numToMultiply){
		return (num + 1) * numToMultiply;
	}
	// value to  take in, value to take in, value to return
	static BiFunction<Integer, Integer,Integer> incrementByOneAndMultiplyBiFunction =
			(numberToIncrementByOne, numberToMultiplyBy)
					-> (++numberToIncrementByOne) * numberToMultiplyBy;
}
