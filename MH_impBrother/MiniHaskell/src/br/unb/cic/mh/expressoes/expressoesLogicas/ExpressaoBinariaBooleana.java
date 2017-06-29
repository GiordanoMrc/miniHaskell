package br.unb.cic.mh.expressoes.expressoesLogicas;

import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoBinaria;
import br.unb.cic.mh.valores.Tipo;

public abstract class ExpressaoBinariaBooleana extends ExpressaoBinaria{

	public ExpressaoBinariaBooleana(Expressao s1, Expressao s2) {
		super(s1, s2);
	}
	
	@Override
	public Tipo tipo() {
		Tipo t1 = sub1.tipo();
		Tipo t2 = sub2.tipo();
		
		if(t1.equals(Tipo.BOOLEANO) && t2.equals(Tipo.BOOLEANO)) {
			return Tipo.BOOLEANO;
		}
		return Tipo.ERRO;
	}
	
	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.BOOLEANO);
	}

}
