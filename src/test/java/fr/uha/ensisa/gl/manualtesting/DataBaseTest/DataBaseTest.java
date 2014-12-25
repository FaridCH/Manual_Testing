package fr.uha.ensisa.gl.manualtesting.DataBaseTest;



import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;
import fr.uha.ensisa.gl.manualtesting.DataBase.DataBase;
import fr.uha.ensisa.gl.manualtesting.DataBase.Timer;
import fr.uha.ensisa.gl.manualtesting.Model.ManualTest;


public class DataBaseTest extends TestCase {

	DataBase db = new DataBase();
	
	@Test
	public void setUp()
	{
		db.clear();
	}
	
	public void testAdd()
	{
		ManualTest mtest = new ManualTest();
		db.add(mtest);
		assertEquals(mtest,db.get(0));
		assertEquals("L'element n'est pas ajouté !", 1,db.getAll().size());
	}
	
	@Test
	public void testDelete() 
	{
		ManualTest mtest = new ManualTest();
		db.add(mtest);
		db.delete(0);
		assertTrue("La liste de test est dèja vide !",db.getAll().isEmpty());
		db.delete(0);
	}
	
	@Test
	public void testGet() 
	{
		ManualTest mtest = new ManualTest();
		ManualTest mtest1 = new ManualTest();
		db.add(mtest); 
		mtest1=db.get(0);
		assertEquals(mtest1,db.get(0));
		assertEquals(null,db.get(1));
	}
	
	@Test
	public void testContient()
	{
		ManualTest mtest = new ManualTest();
		ManualTest mtest1 = new ManualTest();
		ManualTest mtest3 = new ManualTest();
		db.add(mtest);
		db.add(mtest1);
		assertTrue(db.contient(mtest1));
		assertFalse(db.contient(mtest3));
		
	}
	
	@Test
	public void testHisto()
	{

		List<Timer> timer = DataBase.getHistorique();
		assertEquals(timer.isEmpty(),DataBase.getHistorique().isEmpty());
		}
}
