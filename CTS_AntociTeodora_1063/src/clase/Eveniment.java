package clase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import interfete.IEveniment;

public class Eveniment implements IEveniment{
	public String codEv;
	public int nrSala;
	public int nrInvitati;
	public Date dataEv;
	public int oraInceput;
	public int oraSfarsit;
	
	private ArrayList<Invitat> listaInvitati = new ArrayList <>();
	

	public Eveniment() {
		super();
		nrSala=1;
		nrInvitati=100;
		oraInceput=18;
		oraSfarsit=23;
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataEv = dateformat.parse("01/01/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Eveniment(int nrSala, int nrInvitati, Date dataEv, int oraInceput, int oraSfarsit,
			ArrayList<Invitat> listaInvitati) {
		super(); 
		this.nrSala = nrSala;
		this.nrInvitati = nrInvitati;
		this.dataEv = dataEv;
		this.oraInceput = oraInceput;
		this.oraSfarsit = oraSfarsit;
		this.listaInvitati = listaInvitati;
	}
	
	
	public void setNrSala(int nrSala) {
		if(nrSala>0)
			this.nrSala = nrSala;
		else throw new IllegalArgumentException();
	}

	public void setNrInvitati(int nrInvitati) {
		if(nrInvitati>=10&&nrInvitati<=300)
			this.nrInvitati = nrInvitati;
		else throw new IllegalArgumentException();
	}

	public void setDataEv(Date dataEv) {
		if(dataEv!=null)
			this.dataEv = dataEv;
		else throw new IllegalArgumentException();
	}

	public void setOraInceput(int oraInceput) {
		if(oraInceput >= 12)
			this.oraInceput = oraInceput;
		else throw new IllegalArgumentException();
	}

	public void setOraSfarsit(int oraSfarsit) {
		if(oraSfarsit<5 || oraSfarsit>12)
			this.oraSfarsit = oraSfarsit;
		else throw new IllegalArgumentException();
	}

	public void setListaInvitati(ArrayList<Invitat> listaInvitati) {
		if(listaInvitati.size()>1)
			this.listaInvitati = listaInvitati;
		else throw new IllegalArgumentException();
	}

	public String getCodEv() {
		return codEv;
	}

	public void setCodEv(String codEv) {
		this.codEv = codEv;
	}
	public void addInvitat(Invitat invitat)
	{
		if(invitat!=null)
			this.listaInvitati.add(invitat);
		else throw new IllegalArgumentException();
	}
	
	public String deschisPublic()
	{
		return "Evenimentul din data de " + this.dataEv.toString() + " din sala "+this.nrSala+" este deschis publicului.";
	}
	
	public String bazaBilet() {
		return "Intrarea la evenimentul din data de " + this.dataEv.toString() + " din sala "+this.nrSala+" se realizeaza pe baza de invitatie / bilet.";
	}
	public void rezervareEveniment(Rezervare r)
	{
		if(r!=null)
			System.out.println("S-a realizat o rezervare a salii " + r.getNumarSala() + " pe data de " + r.getDataRezervare().toString() + " incepand cu ora " +
							r.getOraInceput() + " pana la ora " + r.getOraSfarsit() + " .");
		else throw new IllegalArgumentException();
	}
	
	public void situatieInvitati(String mesaj)
	{
		if(mesaj.length()>=15 && mesaj.length()<=30)
			for(int i=0;i<this.listaInvitati.size();i++){
				System.out.println("Invitatul " + listaInvitati.get(i).getNume() + " " + listaInvitati.get(i).getPrenume());
				this.listaInvitati.get(i).update(mesaj);
			}
		else throw new IllegalArgumentException();
	}

	@Override
	public String descriere() {
		return "Evenimentul din data de " + this.dataEv.toString() + " va incepe la ora " + this.oraInceput
				 + " si se va incheia la ora "+ this.oraSfarsit + ", gazduind in sala " + this.nrSala + " ," + this.nrInvitati + " invitati.";
	}

	@Override
	public Eveniment copie() {
		return this;
	}

	//verificare nr sala
	public boolean checkNrSala()
	{
		if(this.nrSala>=1 && this.nrSala<=12)
			return true;
		return false;
	}
	
	//verificare nr invitati
	public boolean checkNrInvitati()
	{
		if(this.nrInvitati<10)
			return true;
		return false;
	}
	
	//verificare data
	public boolean checkData()
	{
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Date d;
		try {
			d = sdf.parse("2016/01/01");
			if(this.dataEv.after(d))
				return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return false;
	}
	//verificare ora incepere
	public boolean checkOraIncepere()
	{
		if(this.oraInceput>=23)
			return true;
		return false;
	}
	//verificare ora sfarsit
	public boolean checkOraSfarsit()
	{
		if(this.oraSfarsit<13)
			return true;
		return false;
	}
	//verificare interval timp
	public boolean checkOre()
	{
		boolean ok=true;
		if(this.oraInceput>=12 && this.oraInceput<=23){
			if(this.oraSfarsit<=this.oraInceput && this.oraSfarsit<=23)
				ok=false;
		}
		else ok=false;
		return ok;
	}
	
	//creare cod eveniment - nrsala + nrinvitati
	public String compunereCodEveniment()
	{
		if(this.nrSala>=1 && this.nrSala<=9)
			this.codEv="s0"+this.nrSala +"-"+ this.nrInvitati;
		else this.codEv=this.nrSala +"-"+ this.nrInvitati;
		return this.codEv;
	}
	
	//functie calcul medie varsta invitati
	public float calculMedieVarsta()
	{
		float suma=0;
		for(int i=0;i<this.listaInvitati.size();i++)
			suma+=this.listaInvitati.get(i).calculVarsta();
		return suma/this.listaInvitati.size();
	}
}
