package clase;

import interfete.IEveniment;

public class Botez extends Eveniment implements IEveniment{


	@Override
	public String descriere() {
		return "Botezul are loc in sala numarul "+ this.nrSala + " cu un numar de "+this.nrInvitati+" in data de "+this.dataEv.toString()+" .";
	}

	@Override
	public Eveniment copie() {
		return this;
	}

	
}
