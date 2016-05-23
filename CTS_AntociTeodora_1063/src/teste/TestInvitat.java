package teste;

import clase.Invitat;
import junit.framework.TestCase;

public class TestInvitat extends TestCase {
	
	Invitat invitat;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	//teste CNP
	
	public void testCNPLungime()
	{
		invitat=new Invitat("Alin","Brinza","1234567891022");
		assertEquals(true,invitat.checkCNPLungime());
	}
	
	public void testCNPSpatii()
	{
		invitat=new Invitat("Teodora","Antoci","123 45678 1022");
		assertEquals(false,invitat.checkCNPSpatii());
	}
	
	public void testCNPCifre()
	{
		invitat=new Invitat("Teodora","Antoci","1234567891022");
		assertEquals(true,invitat.checkCNPCifre());
	}
	

	public void testCNPValid()
	{
		invitat=new Invitat("Teodora","Antoci","9234567891022");
		assertEquals(false,invitat.checkCNPValid());
	}
	
	//test Nume
	public void testSetNumeNull()
	{
		invitat=new Invitat("Elena","Mora","73210927");
		try{
			invitat.setNume(null);
			fail("Nu s-a generat exceptie pentru nume NULL!");
		}catch(IllegalArgumentException ex){
			System.out.println("S-a introdus nume NULL");
		}
	}
	
	public void testNumeUpper()
	{
		invitat=new Invitat("teodora","Antoci","9234567891022");
		assertEquals(false,invitat.checkNumeUpper());
	}
	//test prenume
	public void testSetPrenumeNull()
	{
		invitat=new Invitat("Elena","Mora","73210927");
		try{
			invitat.setPrenume(null);
			fail("Nu s-a generat exceptie pentru prenume NULL!");
		}catch(IllegalArgumentException ex){
			System.out.println("S-a introdus prenume NULL");
		}
	}
	
	//test cnp 13 cifre setter
	
	public void testSetCNP()
	{
		invitat=new Invitat("Elena","Mora","73210927");
		try{
			invitat.setCNP("2103478");
			fail("Nu s-a generat exceptie pentru CNP cu mai mult sau mai putin de 13 cifre!");
		}catch(IllegalArgumentException ex){
			System.out.println("S-a introdus CNP corect.");
		}
	}
	
	//test mesaj metoda update
	
	public void testUpdateMesaj()
	{
		invitat=new Invitat("Elena","Mora","73210927");
		try{
			invitat.update("Merg la petrecere si ma distrez dupa ce termin cu licenta si proiectele.");
			fail("Sirul are limita de caractere.");
		}catch(IllegalArgumentException ex){
			System.out.println("Sirul depaseste limita de caractere.");
		}
	}
	
	//test mesaj Update - contine spatii
	public void testMesajSpatii()
	{
		invitat=new Invitat("teodora","Antoci","9234567891022");
		assertEquals(false,invitat.checkMesajSpatii("hflsdc"));
	}
	
	//test CNP minim 18 ani
	public void test18Ani()
	{
		invitat=new Invitat("teodora","Antoci","19234567891022");
		assertEquals(true, invitat.checkCNP18());
	}
	
	//testare functia calcul varsta
	public void testCalculVarsta()
	{
		invitat=new Invitat("teodora","Antoci","19234567891022");
		assertEquals(24, invitat.calculVarsta());
	}
	
	//testare functie compunere
	public void testCompInvitat()
	{
		invitat=new Invitat("Antoci","Teodora","194003234820321");
		assertEquals(invitat.compunereInvitat(), "Antoci Teodora 22 ani.");
	}
}


