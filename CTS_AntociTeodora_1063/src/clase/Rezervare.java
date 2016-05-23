package clase;

import java.util.Date;

import interfete.ModRezervare;

public class Rezervare {
	
	private ModRezervare mod;

	private TipEveniment tip;
	private int numarSala;
	private int numarInvitati;
	private Date dataRezervare;
	private int oraInceput;
	private int oraSfarsit;
	private int pretPersoana;

	

	public Rezervare(ModRezervare mod, TipEveniment tip, int numarSala, int numarInvitati, Date dataRezervare,
			int oraInceput, int oraSfarsit) {
		super();
		this.mod = mod;
		this.tip = tip;
		this.numarSala = numarSala;
		this.numarInvitati = numarInvitati;
		this.dataRezervare = dataRezervare;
		this.oraInceput = oraInceput;
		this.oraSfarsit = oraSfarsit;
	}

	public Rezervare() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumarSala() {
		return numarSala;
	}
	public void setNumarSala(int numarSala) {
		this.numarSala = numarSala;
	}
	public Date getDataRezervare() {
		return dataRezervare;
	}
	public void setDataRezervare(Date dataRezervare) {
		this.dataRezervare = dataRezervare;
	}

	public int getOraInceput() {
		return oraInceput;
	}

	public void setOraInceput(int oraInceput) {
		this.oraInceput = oraInceput;
	}

	public int getOraSfarsit() {
		return oraSfarsit;
	}

	public void setOraSfarsit(int oraSfarsit) {
		this.oraSfarsit = oraSfarsit;
	}

	public int getNumarInvitati() {
		return numarInvitati;
	}

	public void setNumarInvitati(int numarInvitati) {
		this.numarInvitati = numarInvitati;
	}

	public TipEveniment getTip() {
		return tip;
	}

	public void setTip(TipEveniment tip) {
		this.tip = tip;
	}
	
	public ModRezervare getMod() {
		return mod;
	}

	public void setMod(ModRezervare mod) {
		this.mod = mod;
	}

	public void rezerva()
	{
		if(mod!=null)
			mod.executa();
		else System.out.println("Stil nedetectat!");
	}
	
	public int getPretPersoana() {
		return pretPersoana;
	}

	public void setPretPersoana(int pretPersoana) {
		if(pretPersoana>0)
			this.pretPersoana = pretPersoana;
		else throw new IllegalArgumentException();
	}
	//functie de rezervare in functie de mod 
	
	public boolean checkModTelefonic()
	{
		ModRezervare m=new R_Telefonic();
		if(this.mod==m)
			if(this.numarSala>=1 && this.numarSala<=6)
				return true;
		return false;
	}
	
	public boolean checkModEmail()
	{
		ModRezervare m=new R_Email();
		if(this.mod==m)
			if(this.numarSala>=7 && this.numarSala<=12)
				return true;
		return false;
	}
	
	//functie de conditie de minim la nunta > 80 invitati
	
	public String checkNrInvitati80()
	{
		if(this.tip==TipEveniment.nunta)
			if(this.numarInvitati>80)
				return "accept nunta";
			else return "resping nunta";
		else return "Evenimentul nu este nunta.";
	}
	
	//verificare durata eveniment
	public int durataEveniment()
	{
		return this.oraSfarsit - this.oraInceput;
	}
	
	// verificare de conditie de minim la botez > 50 invitati
	public String checkNrInvitati50()
	{
		if(this.tip==TipEveniment.botez)
			if(this.numarInvitati>50)
				return "accept botez";
			else return "resping botez";
		else return "Evenimentul nu este botez.";
	}
	
	// verificare de conditie de minim la aniversare > 25 invitati
		public String checkNrInvitati25()
		{
			if(this.tip==TipEveniment.aniversare)
				if(this.numarInvitati>25)
					return "accept aniversare";
				else return "resping aniversare";
			else return "Evenimentul nu este aniversare.";
		}
		
	//functie calcul inchiriere
		public int calculRezervare()
		{
			return this.numarInvitati*this.pretPersoana;
		}
		
	//adaos in functie de tip eveniment
		public float calculAdaos()
		{
			switch(this.tip){
			case nunta:
				return (float) (this.pretPersoana*1.1); // nunta costa cu 10% mai mult
				
			case botez:
				return (float) (this.pretPersoana*1.15); // botezul costa cu 15% mai mult
				
			case aniversare:
				return (float) (this.pretPersoana*1.4); // aniversare costa cu 40% mai mult
				
			case banchet:
				return (float) (this.pretPersoana*1.05); // banchetul costa cu 5% mai mult
			}
			return (float) this.pretPersoana;
		}
		
}
	
	
