package test.test;

import org.junit.Test;

/**
 * Created by jason on 15/12/11.
 */
public class Test1 {

    @Test
    public void test() {
        Customer customer = new Customer("jason");

        Movie movie = new Movie("港囧", 1);
        Rental rental = new Rental(movie, 10);

        customer.addRental(rental);
        System.out.println(customer.statement());
    }

}
