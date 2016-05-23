package clase;

import java.util.ArrayList;

public class Organizator {

	private String adresaEmail;
	private String numePren;
	private int anActivitate; // anul inceperii activitatii
	private char gen;
	
	ArrayList <Float> reviewOrg=new ArrayList<>();

	public Organizator(String adresaEmail, String numePren, int anActivitate, char gen) {
		super();
		this.adresaEmail = adresaEmail;
		this.numePren = numePren;
		this.anActivitate = anActivitate;
		this.gen = gen;
	}
	
	public Organizator()
	{
		this("antoci.teodoraF@yahoo.com","Antoci Teodora",2000,'F');
	}

	public String getAdresaEmail() {
		return adresaEmail;
	}

	public void setAdresaEmail(String adresaEmail) {
		this.adresaEmail = adresaEmail;
	}

	public String getNumePren() {
		return numePren;
	}

	public void setNumePren(String numePren) {
		this.numePren = numePren;
	}

	public int getAnActivitate() {
		return anActivitate;
	}

	public void setAnActivitate(int anActivitate) {
		this.anActivitate = anActivitate;
	}

	public char getGen() {
		return gen;
	}

	public void setGen(char gen) {
		this.gen = gen;
	}

	public ArrayList<Float> getReviewOrg() {
		return reviewOrg;
	}

	public void setReviewOrg(ArrayList<Float> reviewOrg) {
		this.reviewOrg = reviewOrg;
	}

	@Override
	public String toString() {
		return "Organizator [adresaEmail=" + adresaEmail + ", numePren=" + numePren + ", anActivitate=" + anActivitate
				+ ", gen=" + gen + ", reviewOrg=" + reviewOrg + "]";
	}
	
	//verificare adresa mail contine @
	public boolean checkAdresa()
	{
		if(this.adresaEmail.contains("@"))
			return true;
		return false;
	}
	
	//verificare adresa mail contine .
	public boolean checkAdresaPunct()
	{
		if(this.adresaEmail.contains("."))
			return true;
		return false;
	}
	
	//verificare numePren contine spatiu
	public boolean checkNumePrenSpatiu()
	{
		String[] sir=this.numePren.split(" ");
		if(sir.length>1)
			return true;
		return false;
	}
	
	//functie calcul experienta
	public int calculExperienta()
	{
		return 2016-this.anActivitate;
	}
	
	//functie verificare experienta F>=4, M>=6 
	public String checkGenExperienta()
	{
		if(this.gen=='F')
			if(this.calculExperienta()<4)
				return "F - experienta insuficienta";
			else return "F - experienta suficienta";
		else if(this.gen=='M')
				if(this.calculExperienta()<6)
					return "M - experienta insuficienta";
				else return "M - experienta suficienta";
		return "Gen incorect!";
	}
	
	//functie adaugare review
	public void addReview(float rev)
	{
		if(rev>=0)
			this.reviewOrg.add(rev);
		else throw new IllegalArgumentException();
	}
	
	//functie nota maxima
	public float reviewMaxim()
	{
		float max=0;
		for(int i=0;i<this.reviewOrg.size();i++)
			if(this.reviewOrg.get(i)>max)
				max=this.reviewOrg.get(i);
		return max;
	}
	
	//functie verificare email contine nume sau prenume
	public String emailContineNumePren()
	{
		if(this.checkNumePrenSpatiu())
		{
			String[] sir=this.numePren.split(" ");
			if(this.adresaEmail.contains(sir[0]) || this.adresaEmail.contains(sir[1]))
				return "Adresa email valida.";
			else return "Adresa email invalida.";
		}
		return "Verificare imposibila.NumePren eronat.";
	}
}
