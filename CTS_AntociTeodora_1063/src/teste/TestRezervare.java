package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import clase.R_Email;
import clase.R_Telefonic;
import clase.Rezervare;
import clase.TipEveniment;
import interfete.ModRezervare;
import junit.framework.TestCase;

public class TestRezervare extends TestCase {
	Rezervare rez;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	//verificare modul telefonic - sala
	
	public void testModTel()
	{
		ModRezervare mod=new R_Telefonic();
		Date d=new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d=dateformat.parse("19/05/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rez=new Rezervare(mod,TipEveniment.aniversare,7,100,d,18,22);
		assertEquals(false, rez.checkModTelefonic());
	}
	
	//verificare modul email - sala
	
	public void testModEmail()
	{
		ModRezervare mod=new R_Email();
		Date d=new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d=dateformat.parse("19/05/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rez=new Rezervare(mod,TipEveniment.nunta,1,200,d,16,23);
		assertEquals(false, rez.checkModEmail());
	}
	
	//verificare tip nunta - 80 invitati
	public void testNunta80()
	{
		ModRezervare mod=new R_Email();
		Date d=new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d=dateformat.parse("19/05/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rez=new Rezervare(mod,TipEveniment.aniversare,1,200,d,16,23);
		assertEquals("Evenimentul nu este nunta.", rez.checkNrInvitati80());
	}
	
	//test ore si durate rezervare
	
	public void testDurataNegativa()
	{
		ModRezervare mod=new R_Telefonic();
		Date d=new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d=dateformat.parse("19/05/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rez=new Rezervare(mod,TipEveniment.banchet,1,110,d,18,14);
		assertEquals(-4, rez.durataEveniment());
	}
	
	public void testDurataMare()
	{
		ModRezervare mod=new R_Telefonic();
		Date d=new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d=dateformat.parse("19/05/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rez=new Rezervare(mod,TipEveniment.banchet,1,110,d,12,23);
		assertEquals(11, rez.durataEveniment());
	}

	//verificare tip botez - 50 invitati
		public void testBotez50()
		{
			ModRezervare mod=new R_Email();
			Date d=new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				d=dateformat.parse("19/05/2016");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rez=new Rezervare(mod,TipEveniment.botez,1,200,d,16,23);
			assertEquals("accept botez", rez.checkNrInvitati50());
		}
		
	//verficare tip aniversare - 25 de invitati
		public void testAniversare25()
		{
			ModRezervare mod=new R_Telefonic();
			Date d=new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				d=dateformat.parse("19/05/2016");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rez=new Rezervare(mod,TipEveniment.aniversare,6,15,d,14,20);
			assertEquals("resping aniversare", rez.checkNrInvitati25());
		}
		
		//verificare setter pret
		
		public void testSetPret()
		{
			
			ModRezervare mod=new R_Telefonic();
			Date d=new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				d=dateformat.parse("19/05/2016");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
			rez=new Rezervare(mod,TipEveniment.aniversare,6,15,d,14,20);
			try{
				rez.setPretPersoana(-13);
				fail("Pretul este pozitiv.");
			}catch(IllegalArgumentException ex){
				System.out.println("Pretul de inchiriere este nepozitiv.");
			}
		}
		
		//verificari functia calcul rezervare
		public void testCalculRez()
		{
			ModRezervare mod=new R_Email();
			Date d=new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				d=dateformat.parse("19/05/2016");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rez=new Rezervare(mod,TipEveniment.botez,1,125,d,16,23);
			rez.setPretPersoana(20);
			assertEquals(rez.calculRezervare(),1250*2,0.1);
		}
		
		public void tetCalculRezGet()
		{
			ModRezervare mod=new R_Email();
			Date d=new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				d=dateformat.parse("19/05/2016");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rez=new Rezervare(mod,TipEveniment.aniversare,1,100,d,16,23);
			rez.setPretPersoana(18);
			assertEquals(rez.calculRezervare(), rez.getNumarInvitati()*rez.getPretPersoana(),0.1);
		}
		
		public void testCalculRezInv()
		{
			ModRezervare mod=new R_Email();
			Date d=new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				d=dateformat.parse("19/05/2016");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rez=new Rezervare(mod,TipEveniment.aniversare,1,100,d,16,23);
			rez.setPretPersoana(18);
			assertEquals(rez.calculRezervare()/rez.getNumarInvitati(), rez.getPretPersoana(),0.1);
		}
		
		//void test Adaos
		
		public void testAdaos()
		{
			ModRezervare mod=new R_Email();
			Date d=new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				d=dateformat.parse("19/05/2016");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rez=new Rezervare(mod,TipEveniment.aniversare,1,100,d,16,23);
			rez.setPretPersoana(20);
			assertEquals(rez.calculAdaos(), 20*1.4, 0.1);
		}
		
}
