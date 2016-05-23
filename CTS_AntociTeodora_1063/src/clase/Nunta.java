package clase;

import interfete.IEveniment;

public class Nunta extends Eveniment implements IEveniment{
	@Override
	public String descriere() {
		return "Nunta are loc in sala numarul "+ this.nrSala + " cu un numar de "+this.nrInvitati+" in data de "+this.dataEv.toString()+" .";
	}

	// prototype
	@Override
	public Eveniment copie() {
		return this;
	}	
}
