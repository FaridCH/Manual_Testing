package fr.uha.ensisa.gl.manualtesting.ControllerTest;
import org.junit.Test;

import fr.uha.ensisa.gl.manualtesting.Controller.Controller;
import junit.framework.TestCase;

/*
 *Ceci est un exemple de test évalue notre classe Controlleur avec Junit!
 * 
 * On donne un nom à notre page et teste si le nom donné est celui qui
 * retourné par la méthode getPageTitle!!!
 * 
 * et Ca fonctionne
 * */
 
public class TestController extends TestCase {
	@Test
    public void testControl()
    {
    	Controller cont = new Controller();
    	cont.setPageTitle("Hello World");
        assertEquals("Hello World", cont.getPageTitle());
    }
}