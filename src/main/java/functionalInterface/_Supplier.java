package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {

	public static void main(String[] args) {
		System.out.println(getDBConnectionURL());
		System.out.println(getDBConnectionURLSupplier.get());
	}

	//non functional
	static String getDBConnectionURL() {
		return "jdbc://localhost:5432/users";
	}

	//functional
	static Supplier<String> getDBConnectionURLSupplier = ()
			-> "jdbc://localhost:5432/users";

}
