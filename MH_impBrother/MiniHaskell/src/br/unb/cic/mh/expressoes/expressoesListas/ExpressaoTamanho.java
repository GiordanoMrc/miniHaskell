package br.unb.cic.mh.expressoes.expressoesListas;

import br.unb.cic.mh.Visitor.Visitor;
import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoUnaria;
import br.unb.cic.mh.valores.*;

public class ExpressaoTamanho extends ExpressaoUnaria{

	public ExpressaoTamanho(Expressao s1) {
		super(s1);
	}

	@Override
	public Tipo tipo() {
		if(sub1.tipo().equals(Tipo.LISTA)){
			return Tipo.INTEIRO;
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.LISTA);
	}

	@Override
	public Valor avaliar() {
		Lista<Valor> ListaInicial = (Lista<Valor>) sub1.avaliar();
		return new ValorInteiro(ListaInicial.lenght());
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}



}
