package teste;

import clase.Organizator;
import junit.framework.TestCase;

public class TestOrganizator extends TestCase {
	Organizator org;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	//test adresa mail @
	public void testAdresa()
	{
		org=new Organizator();
		assertEquals(true, org.checkAdresa());
	}
	
	//test adresa mail .
	public void testAdresaPunct()
	{
		org=new Organizator();
		assertEquals(true, org.checkAdresaPunct());
	}
	
	//test numePren contine spatiu
	public void testNumePrenSpatiu()
	{
		org=new Organizator();
		assertEquals(true, org.checkNumePrenSpatiu());
	}
	
	//test functie calcul experienta
	public void testExperienta()
	{
		org=new Organizator();
		org.setAnActivitate(2007);
		assertEquals(org.calculExperienta(), 2016-2007);
	}
	
	//test functie - gen-experienta
	public void testGenExperienta()
	{
		org=new Organizator();
		org.setAnActivitate(2011);
		org.setGen('M');
		assertEquals("M - experienta insuficienta", org.checkGenExperienta());
	}
	//test functie adaugare review
	public void testAddReview()
	{
		org=new Organizator();
		org.addReview((float) 3.5);
		org.addReview((float) 5.2);
		assertEquals(2, org.getReviewOrg().size());
	}
	
	//test functie add review negativ
	public void testAddReviewNeg()
	{
		org=new Organizator();
		try{
			org.addReview((float)-1.2); 
			fail("Adaugare review reusita.");
		}catch(IllegalArgumentException ex){
			System.out.println("Genereaza exceptie. Valoare review negativa");
		}
	}

	//test functie review maxim
	public void testMaxReview()
	{
		org=new Organizator();
		org.addReview((float) 3.5);
		org.addReview((float) 5.2);
		assertEquals(org.reviewMaxim(),(float)5.2);
	}
	
	//test functie email contie numePren
	public void testEmailNume()
	{
		org=new Organizator();
		org.setNumePren("TeoAntoci");
		assertEquals(org.emailContineNumePren(), "Verificare imposibila.NumePren eronat.");
	}
}
