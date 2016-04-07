package test;

/**
 * Created by jason on 15/10/9.
 */
public class BookProxyTest {

    public static void main (String[] args) {

        BookProxy bookProxy = new BookProxy();
        Book book = (Book) bookProxy.bind(new BookImpl());
        book.addBook("jason");
    }
}
