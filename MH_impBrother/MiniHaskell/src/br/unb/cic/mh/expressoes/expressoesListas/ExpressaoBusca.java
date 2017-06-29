package br.unb.cic.mh.expressoes.expressoesListas;

import br.unb.cic.mh.Visitor.Visitor;
import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoBinaria;
import br.unb.cic.mh.valores.*;

public class ExpressaoBusca extends ExpressaoBinaria {

	public ExpressaoBusca(Expressao lista, Expressao indice) {
		super(lista, indice);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tipo tipo() {
		if(sub1.tipo() == Tipo.LISTA &&((Lista<Valor>)sub1).getConteudo() != null ){
			return ((Lista<Valor>)sub1).getConteudo().tipo();
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return sub1.tipo() != Tipo.ERRO;
	}

	@Override
	public Valor avaliar() {
		Lista<Valor> ListaInicial = (Lista<Valor>) sub1.avaliar();
		ValorInteiro indice = (ValorInteiro) sub2.avaliar();
		return ListaInicial.busca(indice.getValor()).getConteudo();
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
		
	}


}
