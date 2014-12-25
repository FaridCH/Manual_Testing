package fr.uha.ensisa.gl.manualtesting;

import junit.framework.TestCase;

public class SomeClassTest extends TestCase
{
    public void testDoSomething()
    {
        SomeClass sc = new SomeClass();
        assertEquals("Hello world !", sc.saySomething());
    }
}
