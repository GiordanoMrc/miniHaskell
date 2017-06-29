package br.unb.cic.mh.expressoes.expressoesListas;

import br.unb.cic.mh.Visitor.Visitor;
import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoBinaria;
import br.unb.cic.mh.valores.Lista;
import br.unb.cic.mh.valores.Tipo;
import br.unb.cic.mh.valores.Valor;
import br.unb.cic.mh.valores.ValorInteiro;

public class ExpressaoDropIndice extends ExpressaoBinaria {


	public ExpressaoDropIndice(Expressao lista, Expressao indice) {
		super(lista, indice);
	}

	@Override
	public Tipo tipo() {
		if(sub1.tipo().equals(Tipo.LISTA) && sub2.tipo().equals(Tipo.INTEIRO)){
			return Tipo.LISTA;
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
		ValorInteiro indice = (ValorInteiro) sub2.avaliar();
		ListaInicial.removeIndice(indice.getValor());
		return ListaInicial;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
