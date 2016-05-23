package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clase.Eveniment;
import clase.EvenimentFactory;
import clase.EvenimentPrivat;
import clase.Invitat;
import clase.Organizator;
import clase.OrganizatorBuilder;
import clase.R_Email;
import clase.R_Telefonic;
import clase.Rezervare;
import clase.RezervariEveniment;
import clase.SalonEvenimente;
import clase.TipEveniment;
import interfete.IEveniment;
import interfete.ModRezervare;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// SINGLETON
		System.out.println(" --- SINGLETON --- ");
		SalonEvenimente s1=SalonEvenimente.getInstance("Ambassador Events",5,"Bvd Magheru, Nr. 34, Bucuresti");
		System.out.println(s1.toString());
		
		SalonEvenimente s2=SalonEvenimente.getInstance("Magic Place",3,"Bvd. 1 Decembrie 1918, nr.15, Bucuresti");
		System.out.println(s2.toString());
		
		//FACTORY
		EvenimentFactory EF=new EvenimentFactory();
		try {
			IEveniment even=EF.createObject(TipEveniment.nunta);
			System.out.println(even.descriere());
			even=EF.createObject(TipEveniment.aniversare);
			System.out.println(even.descriere());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//BUILDER
		System.out.println(" --- BUILDER --- ");
		Organizator org=new Organizator();
		System.out.println(org.toString());
		
		Organizator org1=new OrganizatorBuilder().setAnActivitate(2003).setGen('M').build();
		System.out.println(org1.toString());
		
		//OBSERVER
		System.out.println(" --- OBSERVER --- ");
		
		Eveniment ev=new Eveniment();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			ev.setDataEv(dateformat.parse("2/10/2016"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ev.setNrInvitati(10);
		ev.setNrSala(4);
		ev.setOraInceput(15);
		ev.setOraSfarsit(20);
		
		ArrayList <String> lista=new ArrayList<>();
		lista.add("Alin");
		lista.add("Teodora");
		lista.add("Mircea");
		lista.add("Mihai");
		lista.add("Flavia");
		lista.add("Oana");
		lista.add("Horia");
		lista.add("Liviu");
		lista.add("Radu");
		lista.add("Crina");
		
		ArrayList <String> lista1=new ArrayList<>();
		lista1.add("Brinza");
		lista1.add("Antoci");
		lista1.add("Diaconu");
		lista1.add("Remus");
		lista1.add("Popescu");
		lista1.add("Roman");
		lista1.add("Brenciu");
		lista1.add("Cotfas");
		lista1.add("Grigorovici");
		lista1.add("Musuroi");
		
		ArrayList <String> listaCNP=new ArrayList<>();
		listaCNP.add("29202714005669");
		listaCNP.add("19202825575609");
		listaCNP.add("27502594785637");
		listaCNP.add("39402034065655");
		listaCNP.add("29202004655634");
		listaCNP.add("28202404435622");
		listaCNP.add("56902504995657");
		listaCNP.add("47601204045600");
		listaCNP.add("29002154015623");
		listaCNP.add("19102664005612");
		
		for(int i=0;i<ev.nrInvitati;i++)
		{
			Invitat inv=new Invitat(lista.get(i),lista1.get(i),listaCNP.get(i));
			ev.addInvitat(inv);
		}
		
		System.out.println(ev.descriere());
		System.out.println("Situatie invitati : ");
		ev.situatieInvitati(" participa la eveniment.");
		
		//PROTOTYPE
		
		System.out.println(" --- PROTOTYPE --- ");
		
		Eveniment evClone=ev.copie();
		System.out.println(evClone.descriere());
		evClone.setNrInvitati(40);
		evClone.setNrSala(8);
		
		//ADAPTER
		
		System.out.println(" --- ADAPTER --- ");
		
		EvenimentPrivat evPrivat=new EvenimentPrivat(ev);
		System.out.println(evPrivat.freeEntrance());
		
		EvenimentPrivat evP1=new EvenimentPrivat(evClone);
		System.out.println(evP1.TicketOnly());
		
		// STRATEGY
		System.out.println(" --- STRATEGY --- ");
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d=new Date();
		try {
			d=df.parse("2/10/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModRezervare mod=new R_Email();
		Rezervare rez=new Rezervare(mod,TipEveniment.banchet, 4,500,d,20,5);
		rez.rezerva();
		
		mod=new R_Telefonic();
		Rezervare rez1=new Rezervare(mod,TipEveniment.aniversare, 5,100,d,16,21);
		rez1.rezerva();
		
		//FLYWEIGHT
		System.out.println(" --- FLYWEIGHT --- ");
		
		Rezervare r1=new Rezervare(mod,TipEveniment.botez,1,50,d,18,22);
		Rezervare r2=new Rezervare(mod,TipEveniment.nunta,2,150,d,16,3);
		Rezervare r3=new Rezervare(mod,TipEveniment.nunta,3,200,d,20,24);
		
		RezervariEveniment rezervari = new RezervariEveniment();
		Eveniment e1=rezervari.getEveniment(TipEveniment.botez);
		e1.setNrSala(1);
		
		Eveniment e2=rezervari.getEveniment(TipEveniment.nunta);
		e2.setNrSala(2);
		
		Eveniment e3=rezervari.getEveniment(TipEveniment.nunta);
		e3.setNrSala(3);
		
		
		e1.rezervareEveniment(r1);
		e2.rezervareEveniment(r2);
		e3.rezervareEveniment(r3);
		
		System.out.println("S-au realizat "+ rezervari.getHashEvenimente() + " tipuri de evenimente evenimente.");
		
	}

}
