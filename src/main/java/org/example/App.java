package org.example;

import org.testng.annotations.BeforeTest;

/**
 * Hello world!
 *
 */
public class App 
{
	@BeforeTest
    public static void baseUrl()
    {
        System.out.println( "Welcome to Rest API testing!" );
    }
}
