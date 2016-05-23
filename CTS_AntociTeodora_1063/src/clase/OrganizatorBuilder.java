package clase;

import java.util.ArrayList;

import interfete.IOrganizatorBuilder;

public class OrganizatorBuilder implements IOrganizatorBuilder{

	private String adresaEmail;
	private String numePren;
	private int anActivitate; // anul inceperii activitatii
	private char gen;
	
	ArrayList <Float> reviewOrg=new ArrayList<>();
	
	
	public OrganizatorBuilder(String adresaEmail, String numePren, int anActivitate, char gen) {
		super();
		this.adresaEmail = adresaEmail;
		this.numePren = numePren;
		this.anActivitate = anActivitate;
		this.gen = gen;
	}


	public OrganizatorBuilder()
	{
		this("antoci.teodoraF@yahoo.com","Antoci Teodora",2000,'F');
	}
	
	
	public OrganizatorBuilder setAdresaEmail(String adresaEmail) {
		this.adresaEmail = adresaEmail;
		return this;
	}


	public OrganizatorBuilder setNumePren(String numePren) {
		this.numePren = numePren;
		return this;
	}


	public OrganizatorBuilder setAnActivitate(int anActivitate) {
		this.anActivitate = anActivitate;
		return this;
	}


	public OrganizatorBuilder setGen(char gen) {
		this.gen = gen;
		return this;
	}


	public OrganizatorBuilder setReviewOrg(ArrayList<Float> reviewOrg) {
		this.reviewOrg = reviewOrg;
		return this;
	}

	

	public String getAdresaEmail() {
		return adresaEmail;
	}


	public String getNumePren() {
		return numePren;
	}


	public int getAnActivitate() {
		return anActivitate;
	}


	public char getGen() {
		return gen;
	}


	public ArrayList<Float> getReviewOrg() {
		return reviewOrg;
	}


	@Override
	public Organizator build() {
		// TODO Auto-generated method stub
		return new Organizator(this.adresaEmail,this.numePren,this.anActivitate,this.gen);
	}


	@Override
	public String toString() {
		return "OrganizatorBuilder [adresaEmail=" + adresaEmail + ", numePren=" + numePren + ", anActivitate="
				+ anActivitate + ", gen=" + gen + ", reviewOrg=" + reviewOrg + "]";
	}
	

	
}
