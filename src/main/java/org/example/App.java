package org.example;

import org.testng.annotations.BeforeTest;

/**
 * 
 *
 */
public class BaseTest 
{
    @BeforeTest
    public static void baseUrl()
    {
        System.out.println( "Welcome to Rest API testing!" );
    }
}
