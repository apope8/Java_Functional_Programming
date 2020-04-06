package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
	public static void main(String[] args) {
		System.out.println("Non functional");
		System.out.println(isPhoneNumberValid("07000000000"));
		System.out.println(isPhoneNumberValid("09000000000"));
		System.out.println(isPhoneNumberValid("0900000000"));

		System.out.println("----------");

		System.out.println("functional");

		System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
		System.out.println(isPhoneNumberValidPredicate.test("09000000000"));
		System.out.println(isPhoneNumberValidPredicate.test("0900000000"));

		System.out.println("-----------");
		System.out.println("Contains");
		System.out.println(containsNumber3.test("07000000000"));
		System.out.println(containsNumber3.test("03000000000"));

		System.out.println("-----------");
		System.out.println("Joining Predicates");

		System.out.println("Is phone number valid and contains the number 3: " + isPhoneNumberValidPredicate.and(containsNumber3).test("07000000001"));
		System.out.println("Is phone number valid and contains the number 3: " + isPhoneNumberValidPredicate.and(containsNumber3).test("0700000000"));
		System.out.println("Is phone number valid and contains the number 3: " + isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003"));
		System.out.println("Is phone number valid and contains the number 3: " + isPhoneNumberValidPredicate.and(containsNumber3).test("0300000000"));

		System.out.println("Is phone number valid or contains the number 3: " + isPhoneNumberValidPredicate.or(containsNumber3).test("0300000000"));

	}

	// non functional
	static boolean isPhoneNumberValid (String phoneNumber){
		return phoneNumber.startsWith("07") && (phoneNumber.length() == 11);
	}

	//functional

	static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
			phoneNumber.startsWith("07") && phoneNumber.length() == 11;

	static Predicate<String> containsNumber3 = phoneNumber ->
			phoneNumber.contains("3");
}
