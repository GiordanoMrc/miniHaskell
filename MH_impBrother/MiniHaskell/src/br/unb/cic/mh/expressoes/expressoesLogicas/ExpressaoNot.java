package br.unb.cic.mh.expressoes.expressoesLogicas;

import br.unb.cic.mh.Visitor.Visitor;
import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoUnaria;
import br.unb.cic.mh.valores.Tipo;
import br.unb.cic.mh.valores.Valor;
import br.unb.cic.mh.valores.ValorBooleano;

public class ExpressaoNot extends ExpressaoUnaria {

	public ExpressaoNot(Expressao s1) {
		super(s1);
	}

	@Override
	public Tipo tipo() {
		Tipo t = sub1.tipo();
		if(t.equals(Tipo.BOOLEANO)){
			return Tipo.BOOLEANO;
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.BOOLEANO);
	}

	@Override
	public Valor avaliar() {
		ValorBooleano v = (ValorBooleano) sub1.avaliar();
		return new ValorBooleano(!v.getValor());
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
		
	}
	

}
