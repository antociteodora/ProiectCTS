package clase;

import interfete.IPetrecere;

public class EvenimentPrivat implements IPetrecere{
	private Eveniment eveniment;
	

	public EvenimentPrivat(Eveniment ev)
	{
		this.eveniment=ev;
	}
	@Override
	public String freeEntrance() {
		return eveniment.deschisPublic();
	}
	@Override
	public String TicketOnly() {
		
		return eveniment.bazaBilet();
	}

}
