package br.unb.cic.mh.expressoes.expressoesAritmeticas;

import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoBinaria;
import br.unb.cic.mh.valores.*;

public abstract class ExpressaoBinariaInteiro extends ExpressaoBinaria {

	public ExpressaoBinariaInteiro(Expressao s1, Expressao s2) {
		super(s1, s2);
	}
	
	@Override
	public Tipo tipo() {
		Tipo t1 = sub1.tipo();
		Tipo t2 = sub2.tipo();
		
		if(t1.equals(Tipo.INTEIRO) && t2.equals(Tipo.INTEIRO)) {
			return Tipo.INTEIRO;
		}
		return Tipo.ERRO;
	}
	
	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.INTEIRO);
	}

}
