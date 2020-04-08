package hello;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class GreeterTest {

	@Mock
	private Counter counter;

	@InjectMocks
	private Greeter greeter = new Greeter();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void greets_one_symbol_name() {
	    //given
		when(counter.count("aaa")).thenReturn(1);

		//when
        String result = greeter.sayHello("aaa");

        //then
		assertEquals("Wow that's a short name, aaa, welcome!", result);
	}

    @Test
    public void greets_normal_symbol_name() {
        //given
        when(counter.count("aaa")).thenReturn(15);

        //when
        String result = greeter.sayHello("aaa");

        //then
        assertEquals("Hello, aaa, welcome! Your name is 15 long", result);
    }

    @Test
    public void greets_edge_symbol_name() {
        //given
        when(counter.count("aaa")).thenReturn(19);

        //when
        String result = greeter.sayHello("aaa");

        //then
        assertEquals("Hello, aaa, welcome! Your name is 19 long", result);
    }

    @Test
    public void greets_max_symbol_name() {
        //given
        when(counter.count("aaa")).thenReturn(10000);

        //when
        String result = greeter.sayHello("aaa");

        //then
        assertEquals("Who are you :o", result);
    }


    @Test
    public void greets_negative_symbol_name() {
        //given
        when(counter.count("aaa")).thenReturn(-100);

        //when
        String result = greeter.sayHello("aaa");

        //then
        assertEquals("Who are you :o", result);
    }


    @Test
    public void greets_fails_gracefully() {
        //given
        when(counter.count(anyString())).thenThrow(new RuntimeException("everything is on fire"));

        //when
        String result = greeter.sayHello("aaa5555555");

        //then
        assertEquals("Oops", result);
    }

}
