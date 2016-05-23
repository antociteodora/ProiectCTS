package clase;

import interfete.IEveniment;

public class EvenimentFactory {
	
	public IEveniment createObject (TipEveniment tip)
			throws Exception{
		switch(tip){
		
		case nunta :
			return new Nunta();
			
		case botez :
			return new Botez();
			
		case banchet:
			return new Banchet();
			
		case aniversare:
			return new Aniversare();
			
		default: throw new Exception("Invalid type");
		}
	}

}
