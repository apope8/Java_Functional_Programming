package Optionals;

import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		Object value = Optional.ofNullable(null)
				.orElseGet(() -> "default value");

		System.out.println("--Passing in null--");
		System.out.println(value);

		Object value1 = Optional.ofNullable("Hello")
				.orElseGet(() -> "default value");

		System.out.println("--Passing in value--");
		System.out.println(value1);

		Object value2 = Optional.ofNullable("Hello, I'm not null. Change value to null to see exception")
				.orElseThrow(() -> new IllegalStateException("exception"));

		System.out.println("--Throw Exception if null--");
		System.out.println(value2);

		System.out.println("--If Present--");
		Optional.ofNullable("john@gmail.com")
				.ifPresent(email -> System.out.println("Sending email to " + email));

		System.out.println("--If Present or Else, passing null--");
		Optional.ofNullable(null)
				.ifPresentOrElse(email -> System.out.println("Sending email to " + email)
				, () -> {
							System.out.println("cannot send email");
						});



	}
}
