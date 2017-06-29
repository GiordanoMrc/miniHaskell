package br.unb.cic.mh.expressoes.expressoesAritmeticas;

import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.Visitor.Visitor;
import br.unb.cic.mh.valores.Valor;
import br.unb.cic.mh.valores.ValorInteiro;

public class ExpressaoDivisao extends ExpressaoBinariaInteiro{

	public ExpressaoDivisao(Expressao dividendo, Expressao divisor) {
		super(dividendo, divisor);
	}

	@Override
	public Valor avaliar() {
		
		ValorInteiro v1 = (ValorInteiro)sub1.avaliar();
		ValorInteiro v2 = (ValorInteiro)sub2.avaliar();
		
		return new ValorInteiro(v1.getValor()/v2.getValor());
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
		
	}

}
