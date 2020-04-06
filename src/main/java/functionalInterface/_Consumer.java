package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

	public static void main(String[] args) {
		Customer maria = new Customer("Maria", "99999");
		greetCustomer(maria);
		greetCustomerV2(maria, false);
		greetCustomerConsumer.accept(maria);
		greetCustomerConsumerV2.accept(maria, true);
		greetCustomerConsumerV2.accept(maria, false);

	}

	//non functional Consumer

	static void greetCustomer(Customer customer) {
		System.out.println("Hello " + customer.customerName
				+ " thanks for registering phone number " + customer.customerNumber);
	}

	static void greetCustomerV2(Customer customer, Boolean showPhoneNumber) {
		System.out.println("Hello " + customer.customerName
				+ " thanks for registering phone number "
				+ (showPhoneNumber ? customer.customerNumber : "********"));
	}

	//functional Consumer
	static Consumer<Customer> greetCustomerConsumer = customer ->
			System.out.println("Hello " + customer.customerName
					+ " thanks for registering phone number " + customer.customerNumber);

	//functional BiConsumer
	static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
			System.out.println("Hello " + customer.customerName
					+ " thanks for registering phone number "
					+ (showPhoneNumber ? customer.customerNumber : "********"));




	static class Customer {
		private final String customerName;
		private final String customerNumber;

		public Customer(String customerName, String customerNumber) {
			this.customerName = customerName;
			this.customerNumber = customerNumber;
		}
	}
}
