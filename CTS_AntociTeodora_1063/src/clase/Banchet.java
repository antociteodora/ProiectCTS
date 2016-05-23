package clase;

import interfete.IEveniment;

public class Banchet extends Eveniment implements IEveniment{

	@Override
	public String descriere() {
		return "Banchetul are loc in sala numarul "+ this.nrSala + " cu un numar de "+this.nrInvitati+" in data de "+this.dataEv.toString()+" .";
	}

	@Override
	public Eveniment copie() {
		// TODO Auto-generated method stub
		return this;
	}

}
