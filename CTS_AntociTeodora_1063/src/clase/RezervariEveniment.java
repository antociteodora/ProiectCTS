package clase;

import java.util.HashMap;

import interfete.Flyweight;

public class RezervariEveniment implements Flyweight{

	private HashMap<TipEveniment, Eveniment> evenimente;
	
	
	
	public RezervariEveniment() {
		
		evenimente=new HashMap<TipEveniment,Eveniment>();
	}


	@Override
	public Eveniment getEveniment(TipEveniment tip) {
		EvenimentFactory EF = new EvenimentFactory();
		Eveniment ev = new Eveniment();
		ev=evenimente.get(tip);
		if (ev == null) {
			try {
				ev= (Eveniment) EF.createObject(tip);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			evenimente.put(tip, ev);
		}
		return ev;
			
	}


	public int getHashEvenimente() {
		return evenimente.size();
	}
	

}
