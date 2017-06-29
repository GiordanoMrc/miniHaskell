package br.unb.cic.mh.expressoes.expressoesLogicas;

import br.unb.cic.mh.Visitor.Visitor;
import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.valores.Valor;
import br.unb.cic.mh.valores.ValorBooleano;
import br.unb.cic.mh.valores.ValorInteiro;

public class ExpressaoMenor extends ExpressaoBinariaBooleana {

	public ExpressaoMenor(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	
	@Override 
	 	public Valor avaliar() { 
		ValorInteiro v1 = (ValorInteiro)sub1.avaliar();
		ValorInteiro v2 = (ValorInteiro)sub2.avaliar();
		
	 		return new ValorBooleano(v1.getValor() < v2.getValor()); 
	 	}


	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
		
	} 

}

