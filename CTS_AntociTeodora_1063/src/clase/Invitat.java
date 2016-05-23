package clase;

import interfete.IObserver;

public class Invitat implements IObserver{

	private String nume;
	private String prenume;
	private String CNP;
	private int varsta;
	
	public Invitat(String nume,String prenume,String CNP) {
		super();
		this.nume = nume;
		this.prenume=prenume;
		this.CNP=CNP;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		if(prenume!=null)
			this.prenume = prenume;
		else throw new IllegalArgumentException();
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		if(cNP.length()==13)
			CNP = cNP;
		else throw new IllegalArgumentException();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		if(nume!=null)
			this.nume = nume;
		else throw new IllegalArgumentException();
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	@Override
	public void update(String mesaj) {
		// TODO Auto-generated method stub
		if(mesaj.length()<70)
			System.out.println(mesaj);
		else
			throw new IllegalArgumentException();
	}

	//verificare CNP lungime
	public boolean checkCNPLungime()
	{
		boolean ok=false;
		if(this.CNP.length()==13)
			ok=true;
		else System.out.println("CNP-ul nu are 13 cifre!!");
		return ok;
	}
	
	//verificare CNP spatii
	public boolean checkCNPSpatii()
	{
		boolean ok=true;
		char[] cnp=this.CNP.toCharArray();
		for(int i=0;i<cnp.length && ok==true;i++)
			if(cnp[i]==' ')
				ok=false;
		return ok;
	}
	
	//verificare CNP - contine doar cifre
	public boolean checkCNPCifre()
	{
		boolean ok=true;
		char[] cnp=this.CNP.toCharArray();
		for(int i=0;i<cnp.length && ok==true;i++)
			if(!Character.isDigit(cnp[i]))
				ok=false;
		return ok;
	}
	
	//verificare CNP - validitate 1->4
	public boolean checkCNPValid()
	{
		boolean ok=true;
		int cifra;
		char[] cnp=this.CNP.toCharArray();
		cifra=cnp[0]-'0';
		if(cifra==0 || cifra>4)
			ok=false;
		return ok;
	}
	
	//verificare nume - litera mare
	public boolean checkNumeUpper()
	{
		char[] Nume=this.nume.toCharArray();
		if(Nume[0]>'A'&&Nume[0]<'Z')
			return true;
		return false;
	}
	
	//verificare mesaj - contine spatii
	
	public boolean checkMesajSpatii(String mesaj)
	{
		boolean ok=false;
		char[] m=mesaj.toCharArray();
		for(int i=0;i<m.length && ok==false;i++)
			if(m[i]==' ')
				ok=true;
		return ok;
	}
	//verificare an < 98 - ca varsta sa fie peste 18 ani
	public boolean checkCNP18()
	{
		int an;
		an=(this.CNP.charAt(1)-'0')*10 + (this.CNP.charAt(2)-'0');
		if(an<=98 && an>17)
			return true;
		return false;
	}
	
	//functie calcul varsta
	public int calculVarsta()
	{
		int varsta;
		int an_nastere;
		an_nastere=(this.CNP.charAt(1)-'0')*10 + (this.CNP.charAt(2)-'0');
		varsta= 2016 - (19*100 + an_nastere);
		return varsta;
	}
	
	//functie compunere informatii invitat
	public String compunereInvitat()
	{
		return this.nume + " " + this.prenume + " " + this.calculVarsta() + " ani.";
	}
}
