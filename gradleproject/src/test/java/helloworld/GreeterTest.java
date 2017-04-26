package helloworld;

import javax.naming.InitialContext;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GreeterTest
{
	private Greeter greeter;
	
	@Before
	public void InitialContext()
	{
		greeter = new Greeter();
	}
	
	@Test
	public void testSayHello()
	{
		assertThat(greeter.sayHello()).isEqualTo("Hello world!");
	}
}
