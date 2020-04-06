package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerRegistrationValidator.*;
import static combinatorPattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer(
				"Alice",
				"alice@gmail.com",
				"+089875408049",
				LocalDate.of(2000,1,1)
		);

//		System.out.println(new CustomerValidatorService().isValid(customer));

		//using combinator pattern

		ValidationResult result = isEmailValid()
				.and(isPhoneNumberValid())
				.and(isAnAdult())
				.apply(customer);

		System.out.println(result);

		if (result != SUCCESS){
			throw new IllegalStateException(result.name());
		}

		//We can store customer in DB


	}
}
