package hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreeterIntTest {

    private Greeter greeter = new Greeter();

    @Test
    public void everything_works() {
        //when
        String result = greeter.sayHello("Anna");

        //then
        assertEquals("Hello, Anna, welcome! Your name is 4 long", result);
    }

}
