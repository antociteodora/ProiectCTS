package clase;

public class SalonEvenimente {

	//singleton
	private String numeSalon;
	private int numarSali;
	private String locatie;
	
	private static SalonEvenimente instance = null;

	public SalonEvenimente(String numeSalon, int numarSali, String locatie) {
		super();
		this.numeSalon = numeSalon;
		this.numarSali = numarSali;
		this.locatie = locatie;
	}

	public String getNumeSalon() {
		return numeSalon;
	}

	public void setNumeSalon(String numeSalon) {
		this.numeSalon = numeSalon;
	}

	public int getNumarSali() {
		return numarSali;
	}

	public void setNumarSali(int numarSali) {
		this.numarSali = numarSali;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public static SalonEvenimente getInstance(String numeSalon, int numarSali, String locatie) {
		if(instance==null)
			instance = new SalonEvenimente(numeSalon, numarSali, locatie);
		return instance;
	}

	@Override
	public String toString() {
		return "Salonul de evenimente numeSalon " + numeSalon + ", are un numar de " + numarSali + " sali , iar adresa este " + locatie + ". Va asteptam!";
	}

	
	
}
