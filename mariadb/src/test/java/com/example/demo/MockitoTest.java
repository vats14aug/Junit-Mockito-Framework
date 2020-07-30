package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.service.PartialMocking;
import com.example.service.UserServiceImpl;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.example.service.*")

public class MockitoTest {
	
	

    @Test
    public void mockFinalMethods() throws Exception
    {
	UserServiceImpl mock = mock(UserServiceImpl.class);
	when(mock.helloMethod()).thenReturn("Hello E2 Info!");
    String welcome = mock.helloMethod();
    assertEquals("Hello E2 Info!", welcome);
    
    String test=mock.testMethod();
	/*
	 * this will be null because we have used "mock" functionality, i.e we need to
	 * give "when" and "then" for every method, if we are not giving then it'll take
	 * the value as null.
	 */
    assertNull(test);
    }

    @Test

    public void partialMockTest() throws Exception { 
    	
    String returnValue;
    spy(PartialMocking.class);
    
    /*
 	* Mocking Static Methods
 	*/
    when(PartialMocking.staticMethod()).thenReturn("I am a static mock method.");
    returnValue = PartialMocking.staticMethod();
    assertEquals("I am a static mock method.", returnValue);

    PartialMocking collaborator = new PartialMocking();
    PartialMocking mock = spy(collaborator);

    /*
 	* Mocking Final Methods
 	*/
    when(mock.finalMethod()).thenReturn("I am a final mock method.");
    returnValue = mock.finalMethod();
    //verify(mock).finalMethod();
    assertEquals("I am a final mock method.", returnValue);

    /*
     * This is an example of partial mock i.e spy, we have used spy so it'll return the exact value of the function.
     */
    String test=mock.testMethod();
    assertEquals("Hello Test World!", test);
    
    
    /*
 	* Mocking Private Methods
 	*/
    when(mock, "privateMethod").thenReturn("I am a private mock method.");
    returnValue = mock.privateMethodCaller();
    assertEquals("I am a private mock method. Welcome to the Java world.", returnValue);}
    



}


