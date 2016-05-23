package teste;

import java.util.ArrayList;

import clase.Eveniment;
import clase.Invitat;
import clase.Rezervare;
import junit.framework.TestCase;

public class TestEveniment extends TestCase {
	Eveniment ev;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	// verificare numar sala
	public void testNrSalaNenul()
	{
		ev=new Eveniment();
		try{
			ev.setNrSala(0);
			fail("Sala are un numar nenul.");
		}catch(IllegalArgumentException ex){
			System.out.println("Sala are valoare nula.");
		}
		
	}
	
	public void testNrSalaInterval()
	{
		ev=new Eveniment();
		ev.setNrSala(18);
		assertEquals(false, ev.checkNrSala());
	}
	
	// verificare numar invitati
	public void testNrInvitatiInterval()
	{
		ev=new Eveniment();
		try{
			ev.setNrInvitati(360);
			fail("Invitatii incap in sala.");
		}catch(IllegalArgumentException ex){
			System.out.println("Capacitatea salii este prea mica pentru numarul de invitati.");
		}
	}
	
	public void testNrInvitatiMic()
	{
		ev=new Eveniment();
		assertEquals(false, ev.checkNrInvitati());
	}
	//verificare data
	public void testData()
	{
		ev=new Eveniment();
		assertEquals(true,ev.checkData());
	}
	
	public void testSetDataNull()
	{
		ev=new Eveniment();
		try{
			ev.setDataEv(null);
			fail("Data evenimentului este valida.");
		}catch(IllegalArgumentException ex){
			System.out.println("S-a inserat o data nula.");
		}
	}
	
	//verificare ora incepere
	public void testOraIncepe()
	{
		ev=new Eveniment();
		assertEquals(false,ev.checkOraIncepere());
	}
	
	public void testSetOraIncepere()
	{
		ev=new Eveniment();
		try{
			ev.setOraInceput(11);
			fail("Ora incepere eveniment acceptata.");
		}catch(IllegalArgumentException ex){
			System.out.println("Ora inadecvata. Eveniment respins.");
		}
	}
	
	//verificare ora sfarsit
	public void testOraSfarsit()
	{
		ev=new Eveniment();
		assertEquals(false,ev.checkOraSfarsit());
	}
	
	public void testSetOraSfarsit()
	{
		ev=new Eveniment();
		try{
			ev.setOraSfarsit(7);
			fail("Ora incheiere eveniment acceptata.");
		}catch(IllegalArgumentException ex){
			System.out.println("Ora inadecvata. Eveniment respins.");
		}
	}
	
	//verificare interval timp
	
	public void testIntervalOre()
	{
		ev=new Eveniment();
		ev.setOraInceput(15);
		ev.setOraSfarsit(14);
		assertEquals(false,ev.checkOre());
	}
	
	//verificare adaugare invitat null
	
	public void testAddInvitat()
	{
		ev=new Eveniment();
		Invitat inv=null;
		try{
			ev.addInvitat(inv);
			fail("Nu se genereaza exceptie. Invitat agaugat.");
		}catch(IllegalArgumentException ex){
			System.out.println("Exceptie -> invitat null.");
		}
	}
	
	//verificare rezervare eveniment
	public void testRezEveniment()
	{
		ev=new Eveniment();
		Rezervare rez=null;
		try{
			ev.rezervareEveniment(rez);
			fail("Nu se genereaza exceptie. Rezervare efectuata.");
		}catch(IllegalArgumentException ex){
			System.out.println("Exceptie -> rezervare nula.");
		}
	}
	
	//verificare lista invitati
	
	public void testListaInvitati()
	{
		ev=new Eveniment();
		ArrayList<Invitat> lista=new ArrayList<>();
		Invitat inv=new Invitat("Teodora","Antoci","123435356467");
		lista.add(inv);
		try{
			ev.setListaInvitati(lista);
			fail("Setare lista invitati efectuata.");
		}catch(IllegalArgumentException ex){
			System.out.println("Setare lista invitati esuata.Lista are un singur element.");
		}
	}
	
	//verificare situatie invitati
	public void testSituatieInv()
	{
		ev=new Eveniment();
		try{
			ev.situatieInvitati("se distreaza");
			fail("Mesajul de descriere a situatiei se incadreaza in limite.");
		}catch(IllegalArgumentException ex){
			System.out.println("Exceptie - mesaj prea scurt / lung");
		}
	}
	
	//verificare functie compunere cod eveniment
	public void testCodEv()
	{
		ev=new Eveniment();
		ev.setNrSala(7);
		ev.setNrInvitati(54);
		assertEquals(ev.compunereCodEveniment(), "s07-54");
	}
	
	//verificare functie calcul varsta medie
	
	public void testVarstaMedie()
	{
		ev=new Eveniment();
		Invitat i1=new Invitat("Teo","Antoci","197236432976");
		Invitat i2=new Invitat("Teo","Antoci","182236432976");
		Invitat i3=new Invitat("Teo","Antoci","191236432976");
		ArrayList<Invitat> lista=new ArrayList<>();
		lista.add(i1);
		lista.add(i2);
		lista.add(i3);
		ev.setListaInvitati(lista);
		assertEquals(ev.calculMedieVarsta(), ((2016-1997)+(2016-1991)+(2016-1982))/3,0.1);
	}
}
