package interfete;

import clase.Eveniment;
import clase.TipEveniment;

public interface Flyweight {
	Eveniment getEveniment(TipEveniment tip);
}
